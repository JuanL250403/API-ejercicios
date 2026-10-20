package udb.edu.sv.controller.dto.response.rutina;

import lombok.Data;
import udb.edu.sv.controller.dto.response.detalle.DetalleRutinaResponseBase;

import java.util.List;
import java.util.UUID;

@Data
public abstract class RutinaResponseBase<D extends DetalleRutinaResponseBase> {
    protected UUID id;

    protected String nombre;

    protected Long parteAnatomica;

    protected List<D> detalle;
}
