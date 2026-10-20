package udb.edu.sv.controller.dto.request.rutina;

import lombok.Data;
import udb.edu.sv.controller.dto.request.detalle.DetalleRutinaRealizadaRequest;

import java.time.LocalDate;

@Data
public class RutinaRealizadaRequest extends RutinaRequestBase<DetalleRutinaRealizadaRequest>{
    private Integer tiempoRealizacion;

    private LocalDate fechaRealizacion;

    private Integer diaSemana;
}
