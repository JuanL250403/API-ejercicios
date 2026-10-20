package udb.edu.sv.repository.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class RutinaBase<D extends DetalleRutinaBase> {

    @Id
    private UUID id;

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
}
