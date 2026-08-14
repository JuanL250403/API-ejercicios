package udb.edu.sv.repository.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class RutinaRealizada extends RutinaBase<DetalleRutinaRealizada>{
    @Column(nullable = false)
    private Integer tiempoRealizacion;

    private boolean estado;

    private DayOfWeek diaSemana;

    private LocalDate fechaRealizacion;
}
