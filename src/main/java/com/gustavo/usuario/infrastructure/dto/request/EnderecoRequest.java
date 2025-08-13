package com.gustavo.usuario.infrastructure.dto.request;

public record EnderecoRequest(String rua,
                              Long numero,
                              String complemento,
                              String cidade,
                              String estado,
                              String cep) {
}
