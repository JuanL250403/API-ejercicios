package udb.edu.sv.controller.dto.request.detalle;

import lombok.Data;
import udb.edu.sv.controller.dto.request.ejercicio.EjercicioRequestBase;

import java.util.UUID;

@Data
public abstract class DetalleRutinaRequestBase<E extends EjercicioRequestBase> {
    private UUID id;

    private E ejercicio;
}
