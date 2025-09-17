package com.gustavo.usuario.business.mappers;

import com.gustavo.usuario.business.dto.request.EnderecoRequest;
import com.gustavo.usuario.business.dto.response.EnderecoResponse;
import com.gustavo.usuario.infrastructure.entity.Endereco;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    Endereco toEntity(EnderecoRequest request);
    EnderecoResponse toResponse(Endereco Endereco);
    List<Endereco> toEntityList(List<EnderecoRequest> requests);
    List<EnderecoResponse> toResponseList(List<Endereco> Enderecos);
}
