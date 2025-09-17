package com.gustavo.usuario.business.mappers.update;

import com.gustavo.usuario.business.dto.request.TelefoneRequest;
import com.gustavo.usuario.business.dto.response.TelefoneResponse;
import com.gustavo.usuario.infrastructure.entity.Telefone;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TelefoneMapperUpdate {
    void updatetelefone(TelefoneRequest telefoneRequest, @MappingTarget Telefone entity);
}
