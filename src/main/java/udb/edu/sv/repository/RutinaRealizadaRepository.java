package udb.edu.sv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udb.edu.sv.repository.domain.RutinaRealizada;

import java.util.List;

@Repository
public interface RutinaRealizadaRepository extends JpaRepository<RutinaRealizada, Long> {
    List<RutinaRealizada> findAllByUsuarioId(Long usuarioId);

    Long id(Long id);
}
