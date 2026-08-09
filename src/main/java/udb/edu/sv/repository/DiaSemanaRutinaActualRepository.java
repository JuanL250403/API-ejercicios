package udb.edu.sv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udb.edu.sv.repository.domain.DiaSemanaRutinaActual;

import java.util.List;

@Repository
public interface DiaSemanaRutinaActualRepository extends JpaRepository<DiaSemanaRutinaActual, Long> {
    List<DiaSemanaRutinaActual> findAllByRutinaUsuarioId(Long rutinaUsuarioId);
}
