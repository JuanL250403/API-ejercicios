package udb.edu.sv.controller.dto.response.detalle;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import udb.edu.sv.controller.dto.response.ejercicio.EjercicioResponseBase;

import java.util.UUID;

@Data
@SuperBuilder
public abstract class DetalleRutinaResponseBase<E extends EjercicioResponseBase> {
    private UUID id;

    private E ejercicio;
}
