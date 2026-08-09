package udb.edu.sv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udb.edu.sv.repository.domain.DetalleRutinaActual;

@Repository
public interface DetalleRutinaActualRepository extends JpaRepository<DetalleRutinaActual, Long> {
}
