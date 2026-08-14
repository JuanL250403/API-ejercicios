package udb.edu.sv.controller.dto.response.rutina;

import udb.edu.sv.controller.dto.response.detalle.DetalleRutinaActualResponse;

import java.time.LocalDateTime;

public class RutinaActualResponse extends RutinaResponseBase<DetalleRutinaActualResponse> {
    private Integer tiempoRealizacion;

    private boolean estado;

    private LocalDateTime fechaRealizacion;

    private String diaSemana;
}
