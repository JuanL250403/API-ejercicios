package udb.edu.sv.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import udb.edu.sv.controller.dto.diaSemana.DiaSemanaAsignarRutinaRequest;
import udb.edu.sv.controller.dto.rutina.RutinaActualModificarRequest;
import udb.edu.sv.controller.dto.rutina.RutinaActualRequest;
import udb.edu.sv.controller.dto.rutina.RutinaActualResponse;
import udb.edu.sv.services.RutinaActualService;
import java.util.List;

@RestController
@RequestMapping("/rutinasActuales")
@AllArgsConstructor
public class RutinaActualController {

    private final RutinaActualService rutinaActualService;

    @GetMapping("/usuario/{id}")
    public List<RutinaActualResponse> obtenerRutinasActualesUsuario(@PathVariable("id") Long id) {
        return rutinaActualService.obtenerRutinasUsuario(id);
    }

    @GetMapping("/{id}")
    public RutinaActualResponse obtenerRutinaActual(@PathVariable("id") Long id){
        return rutinaActualService.obtenerRutina(id);
    }

    @PostMapping
    public RutinaActualResponse crearRutinaActual(@RequestBody RutinaActualRequest rutina){
        return rutinaActualService.crearRutina(rutina);
    }

    @PutMapping("/{id}")
    public RutinaActualResponse modificarRutna(@PathVariable("id") Long id, @RequestBody RutinaActualModificarRequest rutina){
        return rutinaActualService.modificarRutina(id, rutina);
    }

    @PostMapping("/diaAsignar")
    public RutinaActualResponse asignarDiaRutina(@RequestBody DiaSemanaAsignarRutinaRequest asignarDia) {
        return rutinaActualService.asignarDiaRutina(asignarDia);
    }
}
