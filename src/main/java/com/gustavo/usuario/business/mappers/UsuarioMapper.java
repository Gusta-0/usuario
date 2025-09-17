package com.gustavo.usuario.business.mappers;

import com.gustavo.usuario.business.dto.request.UsuarioRequest;
import com.gustavo.usuario.business.dto.response.UsuarioResponse;
import com.gustavo.usuario.infrastructure.entity.Usuario;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioRequest request);
    UsuarioResponse toResponse(Usuario usuario);
    List<Usuario> toEntityList(List<UsuarioRequest> requests);
    List<UsuarioResponse> toResponseList(List<Usuario> usuarios);
}
