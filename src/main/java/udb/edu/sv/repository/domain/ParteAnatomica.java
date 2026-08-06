package udb.edu.sv.repository.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParteAnatomica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "parteAnatomica")
    private List<RutinaActual> rutinasActuales;

    @OneToMany(mappedBy = "parteAnatomica")
    private List<RutinaRealizada> rutinasRealizadas;
}
