package udb.edu.sv.controller.dto.request.rutina;

import lombok.Data;
import udb.edu.sv.controller.dto.request.detalle.DetalleRutinaRequestBase;

import java.util.List;

@Data
public abstract class RutinaRequestBase<D extends DetalleRutinaRequestBase> {
    private Long id;

    private String nombre;

    private Long parteAnatomica;

    private List<D> detalle;
}
