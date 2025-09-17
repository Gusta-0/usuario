package com.gustavo.usuario.business.dto.response;

import com.gustavo.usuario.infrastructure.entity.Endereco;
import com.gustavo.usuario.infrastructure.entity.Telefone;

import java.util.List;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        List<Endereco> enderecos,
        List<Telefone> telefones
) {

}
