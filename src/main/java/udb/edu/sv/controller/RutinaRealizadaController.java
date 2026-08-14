package udb.edu.sv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import udb.edu.sv.controller.dto.request.rutina.RutinaRealizadaRequest;
import udb.edu.sv.controller.dto.response.rutina.RutinaRealizadaResponse;
import udb.edu.sv.services.RutinaRealizadaService;

import java.util.List;

@RestController
@RequestMapping("/rutinas/realizadas")
@RequiredArgsConstructor
public class RutinaRealizadaController {
    private final RutinaRealizadaService rutinaRealizadaService;

    @GetMapping("/{idUsuario}")
    public List<RutinaRealizadaResponse> obtenerRutinasUsuario(@PathVariable("idUsuario") Long id) {
        return rutinaRealizadaService.obtenerRutinasUsuario(id);
    }

    @PostMapping("/{idUsuario}")
    public List<RutinaRealizadaResponse> sincronizarRutinas(@PathVariable("idUsuario") Long id, @RequestBody List<RutinaRealizadaRequest> rutinas) {
        return rutinaRealizadaService.sincronizarRutinas(id, rutinas);
    }
}
