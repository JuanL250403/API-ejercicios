package udb.edu.sv.repository.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class RutinaRealizada extends RutinaBase<DetalleRutinaRealizada, DiaSemanaRutinaRealizada>{
    @Column(nullable = false)
    private Integer tiempoRealizacion;

    @Column(nullable = false)
    private boolean realizada;
}
