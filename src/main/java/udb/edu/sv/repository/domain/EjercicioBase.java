package udb.edu.sv.repository.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class EjercicioBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer idEjercicio;

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
}
