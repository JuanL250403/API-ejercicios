package udb.edu.sv.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import udb.edu.sv.controller.dto.request.rutina.RutinaActualRequest;
import udb.edu.sv.controller.dto.response.detalle.DetalleRutinaActualResponse;
import udb.edu.sv.controller.dto.response.rutina.RutinaActualResponse;
import udb.edu.sv.repository.domain.DetalleRutinaActual;
import udb.edu.sv.repository.domain.RutinaActual;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RutinaActualMapper {

    EjercicioActualMapper ejercicioActualMapper = Mappers.getMapper(EjercicioActualMapper.class);

    List<RutinaActualResponse> toRutinaActualResponseList(List<RutinaActual> rutinas);

    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "parteAnatomica.nombre", target = "parteAnatomica")
    @Mapping(source = "detalle", target = "detalle", qualifiedByName = "toListaDetalle")
    RutinaActualResponse toRutinaActualResponse(RutinaActual rutina);

    @Mapping(target = "parteAnatomica", ignore = true)
    RutinaActual toRutinaActual(RutinaActualRequest ruitna);

    @Named("toListaDetalle")
    default List<DetalleRutinaActualResponse> toListaDetalle(List<DetalleRutinaActual> detalle) {
        return detalle.stream().map(d ->
                (DetalleRutinaActualResponse) DetalleRutinaActualResponse.builder()
                        .id(d.getId())
                        .ejercicio(ejercicioActualMapper.toEjercicioActualResponse(d.getEjercicio()))
                        .build()
        ).toList();
    }

}
