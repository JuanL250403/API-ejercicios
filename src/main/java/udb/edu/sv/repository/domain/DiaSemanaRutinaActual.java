package udb.edu.sv.repository.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.DayOfWeek;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaSemanaRutinaActual{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private DayOfWeek diaSemana;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rutina")
    private RutinaActual rutina;

    private boolean estado;
}
