package udb.edu.sv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import udb.edu.sv.controller.dto.request.rutina.RutinaActualRequest;
import udb.edu.sv.controller.dto.response.rutina.RutinaActualResponse;
import udb.edu.sv.services.RutinaActualService;

import java.util.List;

@RestController
@RequestMapping("/rutinas/actuales")
@RequiredArgsConstructor
public class RutinaActualController {
    private final RutinaActualService rutinaActualService;

    @GetMapping("/{id}")
    public List<RutinaActualResponse> obtenerRutinasUsuario(@PathVariable("id") Long id) {
        return rutinaActualService.obtenerRutinasUsuario(id);
    }

    @PostMapping("/sincronizar/{id}")
    public List<RutinaActualResponse> sincronizarRutinas(@RequestBody List<RutinaActualRequest> rutina, @PathVariable("id") Long id) {
        return rutinaActualService.sincronizarRutinas(id, rutina);
    }
}
