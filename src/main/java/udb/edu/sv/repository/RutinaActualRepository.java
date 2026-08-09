package udb.edu.sv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udb.edu.sv.repository.domain.RutinaActual;

import java.util.List;

@Repository
public interface RutinaActualRepository extends JpaRepository<RutinaActual, Long> {

    List<RutinaActual> findAllByUsuarioId(Long usuarioId);

    Long id(Long id);
}
