package udb.edu.sv.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import udb.edu.sv.controller.dto.request.rutina.RutinaRealizadaRequest;
import udb.edu.sv.controller.dto.response.rutina.RutinaRealizadaResponse;
import udb.edu.sv.repository.ParteAnatomicaRepository;
import udb.edu.sv.repository.RutinaRealizadaRepository;
import udb.edu.sv.repository.UsuarioRepository;
import udb.edu.sv.repository.domain.DetalleRutinaRealizada;
import udb.edu.sv.repository.domain.ParteAnatomica;
import udb.edu.sv.repository.domain.RutinaRealizada;
import udb.edu.sv.repository.domain.Usuario;
import udb.edu.sv.services.mapper.EjercicioRealizadoMapper;
import udb.edu.sv.services.mapper.RutinaRealizadaMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RutinaRealizadaService {

    private final RutinaRealizadaRepository rutinaRealizadaRepository;
    private final RutinaRealizadaMapper rutinaRealizadaMapper;
    private final ParteAnatomicaRepository parteAnatomicaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EjercicioRealizadoMapper ejercicioRealizadoMapper;

    public List<RutinaRealizadaResponse> obtenerRutinasUsuario(Long idUsuario) {
        List<RutinaRealizada> rutinas = rutinaRealizadaRepository.findAllByUsuarioId(idUsuario);

        return rutinaRealizadaMapper.toRutinaRealizadaResponseList(rutinas);
    }

    public List<RutinaRealizadaResponse> sincronizarRutinas(Long idUsaruio, List<RutinaRealizadaRequest> rutinas) {
        Usuario usuario = usuarioRepository.findById(idUsaruio).orElseThrow(() -> new EntityNotFoundException("Usuario no existente"));

        List<RutinaRealizada> rutinasSincronizar = rutinas.stream().map(r -> {
            RutinaRealizada rutinaCrear = rutinaRealizadaMapper.toRutinaRealizada(r);

            rutinaCrear.setUsuario(usuario);

            ParteAnatomica parteAnatomica = parteAnatomicaRepository.findById(r.getParteAnatomica()).orElseThrow(() -> new EntityNotFoundException("Parte anatomica no existente"));

            rutinaCrear.setParteAnatomica(parteAnatomica);

            rutinaCrear = crearDetalleRutina(rutinaCrear, r);

            return rutinaCrear;

        }).toList();

        List<RutinaRealizada> rutinasSincronizadas =  rutinaRealizadaRepository.saveAll(rutinasSincronizar);

        return rutinaRealizadaMapper.toRutinaRealizadaResponseList(rutinasSincronizadas);
    }

    private RutinaRealizada crearDetalleRutina(RutinaRealizada rutinaDetallesCrear, RutinaRealizadaRequest rutinaRequest) {
        List<DetalleRutinaRealizada> detalle = rutinaRequest.getDetalle().stream().map(d ->
                (DetalleRutinaRealizada) DetalleRutinaRealizada.builder()
                        .id(d.getId())
                        .rutina(rutinaDetallesCrear)
                        .ejercicio(ejercicioRealizadoMapper.toEjercicioRealizado(d.getEjercicio()))
                        .build()
        ).toList();

        rutinaDetallesCrear.setDetalle(detalle);

        return rutinaDetallesCrear;
    }
}
