package com.gustavo.usuario.business.mappers.update;

import com.gustavo.usuario.business.dto.request.UsuarioRequest;
import com.gustavo.usuario.infrastructure.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioUpdateMapper {

    @Mapping(target = "id", ignore = true)
    void updateUsuario(UsuarioRequest request, @MappingTarget Usuario entity);
}
