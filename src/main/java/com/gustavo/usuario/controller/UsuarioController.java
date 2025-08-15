package com.gustavo.usuario.controller;

import com.gustavo.usuario.business.UsuarioService;
import com.gustavo.usuario.infrastructure.dto.EnderecoDTO;
import com.gustavo.usuario.infrastructure.dto.TelefoneDTO;
import com.gustavo.usuario.infrastructure.dto.UsuarioDTO;
import com.gustavo.usuario.infrastructure.entity.Usuario;
import com.gustavo.usuario.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
//@Tag(name = "Tarefas", description = "Cadastra tarefas de usuários")
//@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha())
        );
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvaUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

    @GetMapping
    public ResponseEntity<UsuarioDTO> buscaUsuarioPorEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

//    @DeleteMapping("/{email}")
//    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email) {
//        usuarioService.deletaUsuarioPorEmail(email);
//        return ResponseEntity.ok().build();
//    }

//    @PutMapping
//    public ResponseEntity<UsuarioDTO> atualizDadoUsuario(@RequestBody UsuarioDTO dto,
//                                                         @RequestHeader("Authorization") String token) {
//        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token, dto));
//    }

    @PutMapping("/endereco")
    public ResponseEntity<EnderecoDTO> atualizaEndereco(@RequestBody EnderecoDTO dto,
                                                        @RequestParam("id") Long id){
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto));
    }

    @PutMapping("/telefone")
    public ResponseEntity<TelefoneDTO> atualizaTelefone(@RequestBody TelefoneDTO dto,
                                                        @RequestParam("id") Long id){
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto));
    }

//    @PostMapping("/endereco")
//    public ResponseEntity<EnderecoDTO> cadastaEndereco(@RequestBody EnderecoDTO dto,
//                                                       @RequestHeader("Authorization") String token){
//        return ResponseEntity.ok(usuarioService.cadastraEndereco(token, dto));
//    }

//    @PostMapping("/telefone")
//    public ResponseEntity<TelefoneDTO> cadastraTelefone(@RequestBody TelefoneDTO dto,
//                                                        @RequestHeader("Authorization") String token){
//        return ResponseEntity.ok(usuarioService.cadastraTelefone(token, dto));
//    }
//
//    @GetMapping("/endereco/{cep}")
//    public ResponseEntity<ViaCepDTO> buscarDadosCep(@PathVariable("cep") String cep){
//        return ResponseEntity.ok(viaCepService.buscarDadosEndereco(cep));
//    }


}
