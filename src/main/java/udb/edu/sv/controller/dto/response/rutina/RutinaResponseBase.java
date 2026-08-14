package udb.edu.sv.controller.dto.response.rutina;

import lombok.Data;
import udb.edu.sv.controller.dto.response.detalle.DetalleRutinaResponseBase;

import java.util.List;

@Data
public abstract class RutinaResponseBase<D extends DetalleRutinaResponseBase> {
    protected Long id;

    protected String nombre;

    protected String parteAnatomica;

    protected List<D> detalle;
}
