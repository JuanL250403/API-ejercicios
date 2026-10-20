package udb.edu.sv.controller.dto.request.ejercicio;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class EjercicioRequestBase {
    private UUID id;

    private String idEjercicio;

    private Integer series;

    private Integer descanso;

    private Integer peso;

    private Integer tiempo;

    private Integer repeticiones;

}
