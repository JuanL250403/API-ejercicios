package udb.edu.sv.controller.dto.request.diaSemana;

import lombok.Data;

import java.util.UUID;

@Data
public class DiaSemanaRutinaActualRequest {
    private UUID id;

    private Integer diaSemana;

    private UUID idRutina;

    private boolean estado;
}
