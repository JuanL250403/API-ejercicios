package udb.edu.sv.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import udb.edu.sv.controller.dto.request.usuario.UsuarioRequest;
import udb.edu.sv.repository.UsuarioRepository;
import udb.edu.sv.repository.domain.Usuario;
import udb.edu.sv.services.mapper.UsuarioMapper;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public void registrarUsuario(UsuarioRequest usuario) {
        if(usuarioRepository.existsUsuarioByCorreo(usuario.getCorreo()))
            throw new DataIntegrityViolationException("Un usuario con ese correo ya existe");

        Usuario usuarioRegistrar = usuarioMapper.toUsurio(usuario);

        usuarioRegistrar.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));

        usuarioRegistrar.setFechaRegistro(LocalDateTime.now());

        usuarioRepository.save(usuarioRegistrar);
    }

}
