package udb.edu.sv.controller.dto.request.ejercicio;

import lombok.Data;

@Data
public abstract class EjercicioRequestBase {
    private Long id;

    private Integer idEjercicio;

    private Integer series;

    private Integer descanso;

    private Integer peso;

    private Integer tiempo;

    private Integer repeticiones;

}
