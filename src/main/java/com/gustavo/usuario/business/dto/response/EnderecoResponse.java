package com.gustavo.usuario.business.dto.response;

public record EnderecoResponse(
        Long id,
        String rua,
        Long numero,
        String complemento,
        String cidade,
        String estado,
        String cep,
        Long usuario_id
) {
}
