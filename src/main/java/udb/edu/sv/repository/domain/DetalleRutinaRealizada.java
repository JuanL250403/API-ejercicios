package udb.edu.sv.repository.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DetalleRutinaRealizada extends DetalleRutinaBase {
    @ManyToOne
    @JoinColumn(name = "id_rutina_realizada")
    private RutinaRealizada rutina;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ejercicio_realizado")
    private EjercicioRealizado ejercicio;
}
