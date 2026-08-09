package udb.edu.sv.controller.dto.response.detalle;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import udb.edu.sv.controller.dto.response.ejercicio.EjercicioResponseBase;

@Data
@SuperBuilder
public abstract class DetalleRutinaResponseBase<E extends EjercicioResponseBase> {
    private Long id;

    private E ejercicio;
}
