package udb.edu.sv.repository.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

import java.time.DayOfWeek;

@Getter
@Setter
@MappedSuperclass
public abstract class RutinaBase<D extends DetalleRutinaBase, S extends DiaSemanaRutinaBase> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_parte_anatomica")
    private ParteAnatomica parteAnatomica;

    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL)
    private List<D> detalle;

    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL)
    private List<S> diasSemana;
}
