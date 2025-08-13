package com.gustavo.usuario.infrastructure.dto.request;

import java.util.List;

public record UsuarioRequest (String nome,
                              String email,
                              String senha,
                              List<EnderecoRequest> enderecos,
                              List<TelefoneRequest> telefones
){
}
