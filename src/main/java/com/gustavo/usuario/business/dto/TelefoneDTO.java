package com.gustavo.usuario.business.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefoneDTO {
    private Long id;
    @NotBlank(message = "O DDD é obrigatório")
    @Pattern(regexp = "^\\d{2}$", message = "O DDD deve ter exatamente 2 dígitos")
    private String ddd;

    @NotBlank(message = "O número é obrigatório")
    @Pattern(regexp = "^\\d{8,9}$", message = "O número deve ter 8 ou 9 dígitos")
    private String numero;
}
