package udb.edu.sv.repository.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaSemanaRutinaActual{
    @Id
    protected UUID id;

    private Integer diaSemana;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rutina")
    private RutinaActual rutina;

    private boolean estado;
}
