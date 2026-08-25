package udb.edu.sv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udb.edu.sv.controller.dto.request.usuario.UsuarioRequest;
import udb.edu.sv.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public void registrarUsuario(@RequestBody UsuarioRequest usuario) {
        usuarioService.registrarUsuario(usuario);
    }
}
