package udb.edu.sv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import udb.edu.sv.controller.dto.request.diaSemana.DiaSemanaRutinaActualRequest;
import udb.edu.sv.controller.dto.response.diaSemana.DiaSemanaRutinaActualResponse;
import udb.edu.sv.services.DiaSemanaService;

import java.util.List;

@RestController
@RequestMapping("/api/semana")
@RequiredArgsConstructor
public class DiaSemanaRutinaController {

    private final DiaSemanaService diaSemanaService;

    @GetMapping()
    public List<DiaSemanaRutinaActualResponse> obtenerDiasSemanaUsuario(){
        return diaSemanaService.obtenerDiasSemanaUsuario();
    }

    @PostMapping()
    public List<DiaSemanaRutinaActualResponse> sincronizarDiasSemana(@RequestBody List<DiaSemanaRutinaActualRequest> diasSemana) {
        return diaSemanaService.sincronizarDiasSemana(diasSemana);
    }
}
