package com.gustavo.usuario.business.mappers.update;

import com.gustavo.usuario.business.dto.request.EnderecoRequest;
import com.gustavo.usuario.infrastructure.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EnderecoMapperUpdate {
    void updateEndereco(EnderecoRequest enderecoRequest, @MappingTarget Endereco entity);

}
