package com.gustavo.usuario.infrastructure.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    String nome;
    String email;
    String senha;
    List<EnderecoDTO> enderecos;
    List<TelefoneDTO> telefones;
}
