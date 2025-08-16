package com.gustavo.usuario.business.converter;

import com.gustavo.usuario.business.dto.EnderecoDTO;
import com.gustavo.usuario.business.dto.TelefoneDTO;
import com.gustavo.usuario.business.dto.UsuarioDTO;
import com.gustavo.usuario.infrastructure.entity.Endereco;
import com.gustavo.usuario.infrastructure.entity.Telefone;
import com.gustavo.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UsuarioConverter {


    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha()) // lembre de codificar antes de salvar
                .enderecos(dto.getEnderecos() != null ?
                        paraListaEndereco(dto.getEnderecos()) : Collections.emptyList())
                .telefones(dto.getTelefones() != null ?
                        paraListaTelefones(dto.getTelefones()) : Collections.emptyList())
                .build();
    }


    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS) {
        List<Endereco> enderecos = new ArrayList<>();
        for (EnderecoDTO enderecoDTO : enderecoDTOS) {
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<Telefone> paraListaTelefones(List<TelefoneDTO> telefoneDTOS) {
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public UsuarioDTO toDTO(Usuario entity) {
        if (entity == null) return null;

        return UsuarioDTO.builder()
                .nome(entity.getNome())
                .email(entity.getEmail())
                .enderecos(entity.getEnderecos() != null ?
                        paraListaEnderecoDTO(entity.getEnderecos()) : Collections.emptyList())
                .telefones(entity.getTelefones() != null ?
                        paraListaTelefonesDTO(entity.getTelefones()) : Collections.emptyList())
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTOS) {
        List<EnderecoDTO> enderecos = new ArrayList<>();
        for (Endereco enderecoDTO : enderecoDTOS) {
            enderecos.add(paraEnderecoDTO(enderecoDTO));
        }
        return enderecos;
    }

    public EnderecoDTO paraEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .cidade(endereco.getCidade())
                .complemento(endereco.getComplemento())
                .cep(endereco.getCep())
                .estado(endereco.getEstado())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefonesDTO(List<Telefone> telefoneDTOS) {
        return telefoneDTOS.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .id(telefone.getId())
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

    public Usuario updateEntity(UsuarioDTO dto, Usuario entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getNome() != null) entity.setNome(dto.getNome());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getSenha() != null) entity.setSenha(dto.getSenha()); // lembre de codificar

        // se quiser permitir atualização de endereços/telefones:
        if (dto.getEnderecos() != null) {
            entity.setEnderecos(paraListaEndereco(dto.getEnderecos()));
        }
        if (dto.getTelefones() != null) {
            entity.setTelefones(paraListaTelefones(dto.getTelefones()));
        }

        return entity;
    }

    public Endereco updateEndereco(EnderecoDTO dto, Endereco entity) {
        return Endereco.builder()
                .id(entity.getId())
                .rua(dto.getRua() != null ? dto.getRua() : entity.getRua())
                .numero(dto.getNumero() != null ? dto.getNumero() : entity.getNumero())
                .cidade(dto.getCidade() != null ? dto.getCidade() : entity.getCidade())
                .cep(dto.getCep() != null ? dto.getCep() : entity.getCep())
                .complemento(dto.getComplemento() != null ? dto.getComplemento() : entity.getComplemento())
                .estado(dto.getEstado() != null ? dto.getEstado() : entity.getEstado())
                .usuario_id(entity.getUsuario_id())
                .build();
    }

    public Telefone updateTelefone(TelefoneDTO dto, Telefone entity) {
        return Telefone.builder()
                .id(entity.getId())
                .ddd(dto.getDdd() != null ? dto.getDdd() : entity.getDdd())
                .numero(dto.getNumero() != null ? dto.getNumero() : entity.getNumero())
                .usuario_id(entity.getUsuario_id())
                .build();
    }

    public Endereco paraEnderecoEntity(EnderecoDTO dto, Long idUsuario) {
        return Endereco.builder()
                .rua(dto.getRua())
                .cidade(dto.getCidade())
                .cep(dto.getCep())
                .complemento(dto.getComplemento())
                .estado(dto.getEstado())
                .numero(dto.getNumero())
                .usuario_id(idUsuario)
                .build();
    }

    public Telefone paraTelefoneEntity(TelefoneDTO dto, Long idUsuario) {
        return Telefone.builder()
                .numero(dto.getNumero())
                .ddd(dto.getDdd())
                .usuario_id(idUsuario)
                .build();
    }

}