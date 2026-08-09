package udb.edu.sv.services.mapper;

import org.mapstruct.Mapper;
import udb.edu.sv.controller.dto.request.ejercicio.EjercicioActualRequest;
import udb.edu.sv.controller.dto.response.ejercicio.EjercicioActualResponse;
import udb.edu.sv.repository.domain.EjercicioActual;

@Mapper(componentModel = "spring")
public interface EjercicioActualMapper {

    EjercicioActualResponse toEjercicioActualResponse(EjercicioActual ejercicio);

    EjercicioActual toEjercicioActual(EjercicioActualRequest ejercicio);
}
