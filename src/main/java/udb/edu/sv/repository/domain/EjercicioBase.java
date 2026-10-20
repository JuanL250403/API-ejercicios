package udb.edu.sv.repository.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@MappedSuperclass
public abstract class EjercicioBase<D extends DetalleRutinaBase> {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String idEjercicio;

    @Column(nullable = false)
    private Integer series;

    @Column(nullable = false)
    private Integer descanso;

    @Column(nullable = false)
    private Integer peso;

    @Column(nullable = false)
    private Integer tiempo;

    @Column(nullable = false)
    private Integer repeticiones;

    @OneToMany(mappedBy = "ejercicio", fetch = FetchType.LAZY)
    private List<D> detalle;
}
