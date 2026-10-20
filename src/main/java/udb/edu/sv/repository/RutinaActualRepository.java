package udb.edu.sv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udb.edu.sv.repository.domain.RutinaActual;

import java.util.List;
import java.util.UUID;

@Repository
public interface RutinaActualRepository extends JpaRepository<RutinaActual, UUID> {

    List<RutinaActual> findAllByUsuarioId(Long usuarioId);

    Long id(Long id);
}
