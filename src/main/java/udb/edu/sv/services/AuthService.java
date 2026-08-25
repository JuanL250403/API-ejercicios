package udb.edu.sv.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import udb.edu.sv.controller.dto.request.AuthRequest;
import udb.edu.sv.controller.dto.response.AuthResponse;
import udb.edu.sv.repository.domain.Usuario;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthResponse generarToken(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getCorreo(),
                        authRequest.getContrasenia()
                )
        );

        if (authentication.isAuthenticated()) {
            Usuario user = (Usuario) authentication.getPrincipal();
            String jwtToken = jwtService.generarToken(user);

            return AuthResponse.builder()
                    .authToken(jwtToken)
                    .build();

        }

        throw new UsernameNotFoundException("Credenciales invalidas");
    }

}
