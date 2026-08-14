package udb.edu.sv.controller.dto.response.rutina;

import lombok.Data;
import udb.edu.sv.controller.dto.response.detalle.DetalleRutinaRealizadaResponse;

import java.time.LocalDate;

@Data
public class RutinaRealizadaResponse extends RutinaResponseBase<DetalleRutinaRealizadaResponse>{
    private Integer tiempoRealizacion;

    private boolean estado;

    private LocalDate fechaRealizacion;

    private String diaSemana;
}
