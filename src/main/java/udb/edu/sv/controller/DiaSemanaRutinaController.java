package udb.edu.sv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import udb.edu.sv.controller.dto.request.diaSemana.DiaSemanaRutinaActualRequest;
import udb.edu.sv.controller.dto.response.diaSemana.DiaSemanaRutinaActualResponse;
import udb.edu.sv.services.DiaSemanaService;

import java.util.List;

@RestController
@RequestMapping("/semana")
@RequiredArgsConstructor
public class DiaSemanaRutinaController {

    private final DiaSemanaService diaSemanaService;

    @GetMapping("/{idUsuario}")
    public List<DiaSemanaRutinaActualResponse> obtenerDiasSemanaUsuario(@PathVariable("idUsuario") Long idUsuario){
        return diaSemanaService.obtenerDiasSemanaUsuario(idUsuario);
    }

    @PostMapping("/{idUsuario}")
    public List<DiaSemanaRutinaActualResponse> sincronizarDiasSemana(@PathVariable("idUsuario") Long id, @RequestBody List<DiaSemanaRutinaActualRequest> diasSemana) {
        return diaSemanaService.sincronizarDiasSemana(diasSemana, id);
    }
}
