package udb.edu.sv.repository.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DetalleRutinaRealizada extends DetalleRutinaBase {
    @ManyToOne
    @JoinColumn(name = "id_rutina_realizada")
    private RutinaRealizada rutina;

    @ManyToOne
    @JoinColumn(name = "id_ejercicio_realizado")
    private EjercicioRealizado ejercicio;
}
