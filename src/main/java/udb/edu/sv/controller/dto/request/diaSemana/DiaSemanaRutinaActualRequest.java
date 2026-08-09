package udb.edu.sv.controller.dto.request.diaSemana;

import lombok.Data;

import java.time.DayOfWeek;

@Data
public class DiaSemanaRutinaActualRequest {
    private Long id;

    private DayOfWeek diaSemana;

    private Long idRutina;

    private boolean estado;
}
