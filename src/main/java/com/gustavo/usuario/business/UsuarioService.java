package com.gustavo.usuario.business;


import com.gustavo.usuario.infrastructure.dto.EnderecoResponse;
import com.gustavo.usuario.infrastructure.dto.TelefoneResponse;
import com.gustavo.usuario.infrastructure.dto.UsuarioResponse;
import com.gustavo.usuario.infrastructure.dto.request.UsuarioRequest;
import com.gustavo.usuario.infrastructure.entity.Endereco;
import com.gustavo.usuario.infrastructure.entity.Telefone;
import com.gustavo.usuario.infrastructure.entity.Usuario;
import com.gustavo.usuario.infrastructure.exception.UsuarioNotFoundException;
import com.gustavo.usuario.infrastructure.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponse criar(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(passwordEncoder.encode(request.senha()));

        if (request.enderecos() != null) {
            usuario.setEnderecos(request.enderecos().stream()
                    .map(e -> {
                        Endereco end = new Endereco();
                        end.setRua(e.rua());
                        end.setNumero(e.numero());
                        end.setComplemento(e.complemento());
                        end.setCidade(e.cidade());
                        end.setEstado(e.estado());
                        end.setCep(e.cep());
                        return end;
                    }).toList());
        }

        if (request.telefones() != null) {
            usuario.setTelefones(request.telefones().stream()
                    .map(t -> {
                        Telefone tel = new Telefone();
                        tel.setNumero(t.numero());
                        tel.setDDD(t.DDD());
                        return tel;
                    }).toList());
        }

        return toResponse(usuarioRepository.save(usuario));
    }

    public List<UsuarioResponse> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        return toResponse(usuario);
    }

    public UsuarioResponse atualizar(Long id, UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(request.senha());

        if (request.enderecos() != null) {
            usuario.setEnderecos(request.enderecos().stream()
                    .map(e -> {
                        Endereco end = new Endereco();
                        end.setRua(e.rua());
                        end.setNumero(e.numero());
                        end.setComplemento(e.complemento());
                        end.setCidade(e.cidade());
                        end.setEstado(e.estado());
                        end.setCep(e.cep());
                        return end;
                    }).toList());
        }

        if (request.telefones() != null) {
            usuario.setTelefones(request.telefones().stream()
                    .map(t -> {
                        Telefone tel = new Telefone();
                        tel.setNumero(t.numero());
                        tel.setDDD(t.DDD());
                        return tel;
                    }).toList());
        }

        return toResponse(usuarioRepository.save(usuario));
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNotFoundException(id);
        }
        usuarioRepository.deleteById(id);
    }

    private UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getEnderecos() != null
                        ? usuario.getEnderecos().stream()
                        .map(e -> new EnderecoResponse(e.getId(), e.getRua(), e.getNumero(), e.getComplemento(),
                                e.getCidade(), e.getEstado(), e.getCep()))
                        .toList()
                        : List.of(),
                usuario.getTelefones() != null
                        ? usuario.getTelefones().stream()
                        .map(t -> new TelefoneResponse(t.getId(), t.getNumero(), t.getDDD()))
                        .toList()
                        : List.of()
        );
    }
}
