package udb.edu.sv.services.mapper;

import org.mapstruct.Mapper;
import udb.edu.sv.controller.dto.request.ejercicio.EjercicioRealizadoRequest;
import udb.edu.sv.controller.dto.response.ejercicio.EjercicioRealizadoResponse;
import udb.edu.sv.repository.domain.EjercicioRealizado;

@Mapper(componentModel = "spring")
public interface EjercicioRealizadoMapper {

    EjercicioRealizadoResponse toEjercicioRealizadoResponse(EjercicioRealizado ejercicio);

    EjercicioRealizado toEjercicioRealizado(EjercicioRealizadoRequest ejercicio);
}
