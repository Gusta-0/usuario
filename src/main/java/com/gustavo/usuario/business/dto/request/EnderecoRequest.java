package com.gustavo.usuario.business.dto.request;

import jakarta.validation.constraints.*;

public record EnderecoRequest(
        @NotBlank(message = "A rua é obrigatória")
        @Size(max = 100) String rua,

        @NotNull(message = "O número é obrigatório")
        @Min(value = 1, message = "O número deve ser maior ou igual a 1")
        Long numero,

        @Size(max = 50) String complemento,

        @NotBlank(message = "A cidade é obrigatória")
        @Size(max = 60) String cidade,

        @NotBlank(message = "O estado é obrigatório")
        @Size(max = 2) String estado,

        @NotBlank(message = "O CEP é obrigatório")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 12345-678")
        String cep
) {
}
