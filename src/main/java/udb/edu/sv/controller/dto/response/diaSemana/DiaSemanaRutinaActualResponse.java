package udb.edu.sv.controller.dto.response.diaSemana;

import lombok.Data;

import java.util.UUID;

@Data
public class DiaSemanaRutinaActualResponse {
    private UUID id;

    private Integer diaSemana;

    private UUID idRutina;

    private boolean estado;
}
