package udb.edu.sv.repository.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class RutinaActual extends RutinaBase<DetalleRutinaActual>{

    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL)
    private List<DiaSemanaRutinaActual> diasSemana;
}
