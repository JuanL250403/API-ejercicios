package udb.edu.sv.controller.dto.response.ejercicio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class EjercicioResponseBase {

    protected Long id;

    protected Integer idEjercicio;

    protected Integer series;

    protected Integer descanso;

    protected Integer peso;

    protected Integer tiempo;

    protected Integer repeticiones;

}
