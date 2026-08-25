package udb.edu.sv.services.mapper;

import org.mapstruct.Mapper;
import udb.edu.sv.controller.dto.request.usuario.UsuarioRequest;
import udb.edu.sv.repository.domain.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toUsurio(UsuarioRequest usuario);
}
