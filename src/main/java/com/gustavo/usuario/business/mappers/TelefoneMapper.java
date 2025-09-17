package com.gustavo.usuario.business.mappers;

import com.gustavo.usuario.business.dto.request.TelefoneRequest;
import com.gustavo.usuario.business.dto.response.TelefoneResponse;
import com.gustavo.usuario.infrastructure.entity.Telefone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {
    Telefone toEntity(TelefoneRequest request);
    TelefoneResponse toResponse(Telefone Telefone);
    List<Telefone> toEntityList(List<TelefoneRequest> requests);
    List<TelefoneResponse> toResponseList(List<Telefone> Telefones);
}
