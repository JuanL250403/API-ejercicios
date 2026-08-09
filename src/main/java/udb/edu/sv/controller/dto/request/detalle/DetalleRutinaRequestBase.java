package udb.edu.sv.controller.dto.request.detalle;

import lombok.Data;
import udb.edu.sv.controller.dto.request.ejercicio.EjercicioRequestBase;

@Data
public abstract class DetalleRutinaRequestBase<E extends EjercicioRequestBase> {
    private Long id;

    private E ejercicio;
}
