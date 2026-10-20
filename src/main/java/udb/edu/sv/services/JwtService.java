package udb.edu.sv.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import udb.edu.sv.repository.domain.Usuario;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiracion;

    @Value("${jwt.refresh-expiration}")
    private Long refrescoExpiracion;

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public String generarToken(Usuario user){
        HashMap<String, Object> detalles = new HashMap<>();
        detalles.put("id", user.getId());
        detalles.put("nombre", user.getNombre());
        detalles.put("peso", user.getPeso());
        detalles.put("altura", user.getAltura());
        detalles.put("fechaNacimiento", user.getFechaNacimiento().toString());

        return buildToken(detalles, user, expiracion);
    }

    public boolean tokenValido(String token, Usuario userDetails){
        String userName = extractCorreoElectronico(token);
        return (userName.equals(userDetails.getCorreo()) && !tokenExpirado(token));
    }

    private boolean tokenExpirado(String token){
        Date expiracion = extractExpiracion(token);
        return expiracion.before(new Date());
    }

    public String extractCorreoElectronico(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private Date extractExpiracion(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private String buildToken(Map<String, Object> extraclaims, Usuario userDetails, long expiracion) {
        return Jwts.builder()
                .setClaims(extraclaims)
                .setSubject(userDetails.getCorreo())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiracion))
                .signWith(getSecretKey())
                .compact();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
