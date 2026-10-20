package udb.edu.sv.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import udb.edu.sv.controller.dto.response.diaSemana.DiaSemanaRutinaActualResponse;
import udb.edu.sv.repository.domain.DiaSemanaRutinaActual;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiaSemanaRutinaActualMapper {

    List<DiaSemanaRutinaActualResponse> toDiaSemanaRutinaActualResponseList(List<DiaSemanaRutinaActual> diaSemana);


    @Mapping(source = "rutina.id", target = "idRutina")
    @Mapping(source = "estado", target = "estado")
    DiaSemanaRutinaActualResponse toDiaSemanaRutinaActualResponse(DiaSemanaRutinaActual diaSemana);

}
