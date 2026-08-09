package udb.edu.sv.controller.dto.response.diaSemana;

import lombok.Data;

@Data
public class DiaSemanaRutinaActualResponse {
    private Long id;

    private String diaSemana;

    private Long idRutina;

    private boolean estado;
}
