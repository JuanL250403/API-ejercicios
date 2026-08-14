package udb.edu.sv.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import udb.edu.sv.controller.dto.request.rutina.RutinaRealizadaRequest;
import udb.edu.sv.controller.dto.response.detalle.DetalleRutinaRealizadaResponse;
import udb.edu.sv.controller.dto.response.rutina.RutinaRealizadaResponse;
import udb.edu.sv.repository.domain.DetalleRutinaRealizada;
import udb.edu.sv.repository.domain.RutinaRealizada;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Mapper(componentModel = "spring")
public interface RutinaRealizadaMapper {
    EjercicioRealizadoMapper ejercicioRealizadoMapper = Mappers.getMapper(EjercicioRealizadoMapper.class);

    List<RutinaRealizadaResponse> toRutinaRealizadaResponseList(List<RutinaRealizada> rutinas);

    @Mapping(source = "parteAnatomica.nombre", target = "parteAnatomica")
    @Mapping(source = "detalle", target = "detalle", qualifiedByName = "toListaDetalle")
    @Mapping(source = "diaSemana", target = "diaSemana", qualifiedByName = "traducirDiaSemana")
    RutinaRealizadaResponse toRutinaRealizadaResponse(RutinaRealizada rutina);

    @Mapping(target = "parteAnatomica", ignore = true)
    RutinaRealizada toRutinaRealizada(RutinaRealizadaRequest ruitna);

    @Named("toListaDetalle")
    default List<DetalleRutinaRealizadaResponse> toListaDetalle(List<DetalleRutinaRealizada> detalle) {
        return detalle.stream().map(d ->
                (DetalleRutinaRealizadaResponse) DetalleRutinaRealizadaResponse.builder()
                        .id(d.getId())
                        .ejercicio(ejercicioRealizadoMapper.toEjercicioRealizadoResponse(d.getEjercicio()))
                        .build()
        ).toList();
    }

    @Named("traducirDiaSemana")
    default String traducirDiaSemana(DayOfWeek dia) {
        return dia.getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
}
