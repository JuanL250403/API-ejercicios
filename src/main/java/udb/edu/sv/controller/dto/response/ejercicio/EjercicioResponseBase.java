package udb.edu.sv.controller.dto.response.ejercicio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class EjercicioResponseBase {

    protected UUID id;

    protected String idEjercicio;

    protected Integer series;

    protected Integer descanso;

    protected Integer peso;

    protected Integer tiempo;

    protected Integer repeticiones;

}
