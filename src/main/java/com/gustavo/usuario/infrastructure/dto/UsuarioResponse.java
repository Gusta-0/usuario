package com.gustavo.usuario.infrastructure.dto;

import java.util.List;

public record UsuarioResponse(Long id,
                              String nome,
                              String email,
                              List<EnderecoResponse> enderecos,
                              List<TelefoneResponse> telefones) {
}
