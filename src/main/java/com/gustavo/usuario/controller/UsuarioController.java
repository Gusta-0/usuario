package com.gustavo.usuario.controller;

import com.gustavo.usuario.business.UsuarioService;
import com.gustavo.usuario.infrastructure.dto.UsuarioDTO;
import com.gustavo.usuario.infrastructure.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UsuarioController(UsuarioService usuarioService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha())
        );
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }
//
//    @GetMapping
//    public ResponseEntity<List<UsuarioResponse>> listarTodos() {
//        return ResponseEntity.ok(usuarioService.listarTodos());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
//        return ResponseEntity.ok(usuarioService.buscarPorId(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UsuarioResponse> atualizar(@PathVariable Long id, @RequestBody UsuarioRequest request) {
//        return ResponseEntity.ok(usuarioService.atualizar(id, request));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Long id) {
//        usuarioService.deletar(id);
//        return ResponseEntity.noContent().build();
//    }
}
