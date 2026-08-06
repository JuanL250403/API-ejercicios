package udb.edu.sv.repository.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RutinaRealizada extends RutinaBase{
    @Column(nullable = false)
    private Integer tiempoRealizacion;

    @Column(nullable = false)
    private boolean realizada;
}
