package com.gustavo.usuario.infrastructure.dto;

public record EnderecoResponse( Long id,
                                String rua,
                                Long numero,
                                String complemento,
                                String cidade,
                                String estado,
                                String cep) {
}
