package com.gustavo.usuario.business.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UsuarioRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s]{3,50}$",
                message = "O nome deve conter apenas letras e espaços, entre 3 e 50 caracteres")
        String nome,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
                message = "A senha deve conter letra maiúscula, letra minúscula, número e caractere especial")
        String senha,

        List<EnderecoRequest> enderecos,
        List<TelefoneRequest> telefones
) {
}
