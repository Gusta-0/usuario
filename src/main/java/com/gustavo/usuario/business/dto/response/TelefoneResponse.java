package com.gustavo.usuario.business.dto.response;

public record TelefoneResponse(
        Long id,
        String numero,
        String ddd,
        Long usuario_id
) {
}
