package udb.edu.sv.controller.dto.response.rutina;

import lombok.Data;
import udb.edu.sv.controller.dto.response.detalle.DetalleRutinaResponseBase;

import java.util.List;

@Data
public abstract class RuitnaResponseBase<D extends DetalleRutinaResponseBase> {
    protected Long id;

    protected Long usuarioId;

    protected String nombre;

    protected String parteAnatomica;

    //protected List<DayOfWeek> diasSemana;

    protected List<D> detalle;
}
