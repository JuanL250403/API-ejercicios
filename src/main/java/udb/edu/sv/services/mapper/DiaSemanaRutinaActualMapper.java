package udb.edu.sv.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import udb.edu.sv.controller.dto.response.diaSemana.DiaSemanaRutinaActualResponse;
import udb.edu.sv.repository.domain.DiaSemanaRutinaActual;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Mapper(componentModel = "spring")
public interface DiaSemanaRutinaActualMapper {

    List<DiaSemanaRutinaActualResponse> toDiaSemanaRutinaActualResponseList(List<DiaSemanaRutinaActual> diaSemana);


    @Mapping(source = "diaSemana", target = "diaSemana", qualifiedByName = "traducirDiaSemana")
    @Mapping(source = "rutina.id", target = "idRutina")
    @Mapping(source = "estado", target = "estado")
    DiaSemanaRutinaActualResponse toDiaSemanaRutinaActualResponse(DiaSemanaRutinaActual diaSemana);

    @Named("traducirDiaSemana")
    default String traducirDiaSemana(DayOfWeek dia) {
        return dia.getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
}
