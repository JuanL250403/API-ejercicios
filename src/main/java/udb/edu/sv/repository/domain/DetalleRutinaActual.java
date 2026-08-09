package udb.edu.sv.repository.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DetalleRutinaActual extends DetalleRutinaBase{

    @ManyToOne
    @JoinColumn(name = "id_rutina_actual")
    private RutinaActual rutina;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ejercicio_actual")
    private EjercicioActual ejercicio;
}
