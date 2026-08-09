package udb.edu.sv.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import udb.edu.sv.controller.dto.request.diaSemana.DiaSemanaRutinaActualRequest;
import udb.edu.sv.controller.dto.response.diaSemana.DiaSemanaRutinaActualResponse;
import udb.edu.sv.repository.DiaSemanaRutinaActualRepository;
import udb.edu.sv.repository.RutinaActualRepository;
import udb.edu.sv.repository.domain.DiaSemanaRutinaActual;
import udb.edu.sv.repository.domain.RutinaActual;
import udb.edu.sv.services.mapper.DiaSemanaRutinaActualMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaSemanaService {
    private final DiaSemanaRutinaActualRepository diaSemanaRutinaActualRepository;

    private final DiaSemanaRutinaActualMapper diaSemanaRutinaActualMapper;

    private final RutinaActualRepository rutinaActualRepository;

    public List<DiaSemanaRutinaActualResponse> obtenerDiasSemanaUsuario(Long idUsuario) {
        List<DiaSemanaRutinaActual> diasSemana = diaSemanaRutinaActualRepository.findAllByRutinaUsuarioId(idUsuario);

        return diaSemanaRutinaActualMapper.toDiaSemanaRutinaActualResponseList(diasSemana);
    }

    public List<DiaSemanaRutinaActualResponse> sincronizarDiasSemana(List<DiaSemanaRutinaActualRequest> diasSemana, Long idUsuario) {

        List<DiaSemanaRutinaActual> diasSemanaSincronizar = diasSemana.stream().map(d -> {
            RutinaActual rutina = rutinaActualRepository.findById(d.getIdRutina()).orElseThrow(() -> new EntityNotFoundException("Rutina no existente"));

            return DiaSemanaRutinaActual.builder()
                    .id(d.getId())
                    .diaSemana(d.getDiaSemana())
                    .estado(d.isEstado())
                    .rutina(rutina)
                    .build();
        }).toList();

        List<Long> idDiaSemanaSincronizar = diasSemanaSincronizar.stream().map(d -> d.getId()).toList();

        List<DiaSemanaRutinaActual> diasSemanaExistenteUsuario = diaSemanaRutinaActualRepository.findAllByRutinaUsuarioId(idUsuario);

        List<DiaSemanaRutinaActual> diasSemanaEliminar = diasSemanaExistenteUsuario.stream().filter(d -> !idDiaSemanaSincronizar.contains(d.getId())).toList();

        diaSemanaRutinaActualRepository.deleteAll(diasSemanaEliminar);

        List<DiaSemanaRutinaActual> diasSemanaSincornizados = diaSemanaRutinaActualRepository.saveAll(diasSemanaSincronizar);

        return diaSemanaRutinaActualMapper.toDiaSemanaRutinaActualResponseList(diasSemanaSincornizados);
    }


}
