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

import java.util.List;

@Mapper(componentModel = "spring")
public interface RutinaRealizadaMapper {
    EjercicioRealizadoMapper ejercicioRealizadoMapper = Mappers.getMapper(EjercicioRealizadoMapper.class);

    List<RutinaRealizadaResponse> toRutinaRealizadaResponseList(List<RutinaRealizada> rutinas);

    @Mapping(source = "parteAnatomica.id", target = "parteAnatomica")
    @Mapping(source = "detalle", target = "detalle", qualifiedByName = "toListaDetalle")
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

}
