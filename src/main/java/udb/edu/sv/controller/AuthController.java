package udb.edu.sv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udb.edu.sv.controller.dto.request.AuthRequest;
import udb.edu.sv.controller.dto.response.AuthResponse;
import udb.edu.sv.services.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse inicioDeSesion(@RequestBody AuthRequest authRequest) {
        return authService.generarToken(authRequest);
    }
}
    