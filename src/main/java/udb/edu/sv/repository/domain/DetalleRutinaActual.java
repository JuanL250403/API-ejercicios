package udb.edu.sv.repository.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class DetalleRutinaActual extends DetalleRutinaBase{

    @ManyToOne
    @JoinColumn(name = "id_rutina_actual")
    private RutinaActual rutina;

    @ManyToOne
    @JoinColumn(name = "id_ejercicio_actual")
    private EjercicioActual ejercicio;
}
