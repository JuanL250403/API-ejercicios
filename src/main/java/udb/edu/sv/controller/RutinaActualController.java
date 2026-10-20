package udb.edu.sv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import udb.edu.sv.controller.dto.request.rutina.RutinaActualRequest;
import udb.edu.sv.controller.dto.response.rutina.RutinaActualResponse;
import udb.edu.sv.services.RutinaActualService;

import java.util.List;

@RestController
@RequestMapping("/api/rutinas/actuales")
@RequiredArgsConstructor
public class RutinaActualController {
    private final RutinaActualService rutinaActualService;

    @GetMapping()
    public List<RutinaActualResponse> obtenerRutinasUsuario() {
        return rutinaActualService.obtenerRutinasUsuario();
    }

    @PostMapping()
    public List<RutinaActualResponse> sincronizarRutinas(@RequestBody List<RutinaActualRequest> rutina) {
        return rutinaActualService.sincronizarRutinas(rutina);
    }   
}
