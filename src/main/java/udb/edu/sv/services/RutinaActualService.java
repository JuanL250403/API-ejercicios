package udb.edu.sv.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import udb.edu.sv.controller.dto.request.rutina.RutinaActualRequest;
import udb.edu.sv.controller.dto.response.rutina.RutinaActualResponse;
import udb.edu.sv.repository.DetalleRutinaActualRepository;
import udb.edu.sv.repository.ParteAnatomicaRepository;
import udb.edu.sv.repository.RutinaActualRepository;
import udb.edu.sv.repository.UsuarioRepository;
import udb.edu.sv.repository.domain.DetalleRutinaActual;
import udb.edu.sv.repository.domain.ParteAnatomica;
import udb.edu.sv.repository.domain.RutinaActual;
import udb.edu.sv.repository.domain.Usuario;
import udb.edu.sv.services.mapper.EjercicioActualMapper;
import udb.edu.sv.services.mapper.RutinaActualMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RutinaActualService {

    private final RutinaActualRepository rutinaActualRepository;

    private final RutinaActualMapper rutinaActualMapper;

    private final EjercicioActualMapper ejercicioActualMapper;
    private final UsuarioRepository usuarioRepository;
    private final ParteAnatomicaRepository parteAnatomicaRepository;
    private final DetalleRutinaActualRepository detalleRutinaActualRepository;

    public List<RutinaActualResponse> obtenerRutinasUsuario(Long idUsuario) {
        List<RutinaActual> rutinas = rutinaActualRepository.findAllByUsuarioId(idUsuario);

        return rutinaActualMapper.toRutinaActualResponseList(rutinas);
    }

    @Transactional
    public List<RutinaActualResponse> sincronizarRutinas(Long idUsuario, List<RutinaActualRequest> rutinas) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new EntityNotFoundException("Usuario no existente"));

        List<RutinaActual> rutinasExistentesUsuario = rutinaActualRepository.findAllByUsuarioId(idUsuario);

        List<Long> idDetalleSincronizar = new ArrayList<>();

        List<RutinaActual> rutinasSincronizar = rutinas.stream().map(r -> {
            RutinaActual rutinaCrear = rutinaActualMapper.toRutinaActual(r);
            rutinaCrear.setUsuario(usuario);

            ParteAnatomica parteAnatomica = parteAnatomicaRepository.findById(r.getParteAnatomica()).orElseThrow(() -> new EntityNotFoundException("Parte anatomica no existente"));

            rutinaCrear.setParteAnatomica(parteAnatomica);

            rutinaCrear = crearDetalleRutina(rutinaCrear, r);

            rutinaCrear.getDetalle().forEach(d -> {
                idDetalleSincronizar.add(d.getId());
            });

            return rutinaCrear;
        }).toList();



        List<Long> idRutinasSincronizar = rutinasSincronizar.stream().map(r -> r.getId()).toList();
        List<RutinaActual> rutinasEliminar = rutinasExistentesUsuario.stream().filter(r -> !idRutinasSincronizar.contains(r.getId())).toList();
        rutinaActualRepository.deleteAll(rutinasEliminar);

        rutinasExistentesUsuario.forEach(r -> {
            List<DetalleRutinaActual> detallesEliminar = r.getDetalle().stream().filter(d -> !idDetalleSincronizar.contains(d.getId())).toList();

            detalleRutinaActualRepository.deleteAll(detallesEliminar);
        });

        List<RutinaActual> rutinasSincornizadas = rutinaActualRepository.saveAll(rutinasSincronizar);

        return rutinaActualMapper.toRutinaActualResponseList(rutinasSincornizadas);
    }

    private RutinaActual crearDetalleRutina(RutinaActual rutinaDetallesCrear, RutinaActualRequest rutinaRequest) {
        List<DetalleRutinaActual> detalle = rutinaRequest.getDetalle().stream().map(d ->
                (DetalleRutinaActual) DetalleRutinaActual.builder()
                        .rutina(rutinaDetallesCrear)
                        .ejercicio(ejercicioActualMapper.toEjercicioActual(d.getEjercicio()))
                        .id(d.getId())
                        .build()
        ).toList();

        rutinaDetallesCrear.setDetalle(detalle);

        return rutinaDetallesCrear;
    }
}
