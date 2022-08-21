package dev.locus.flatup.auth.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.locus.flatup.auth.model.TokenDto;
import dev.locus.flatup.auth.service.TokenService;
import dev.locus.flatup.usuario.model.UsuarioDto;
import dev.locus.flatup.usuario.model.UsuarioOAuth;
import dev.locus.flatup.usuario.service.UsuarioService;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> retornaTokenLogin(@RequestBody @Valid UsuarioDto usuarioDto) {
        UsernamePasswordAuthenticationToken dadosLogin = usuarioDto.convertTo();
        var usuario = usuarioService.encontrarUsuarioEmail(usuarioDto.getEmail());
        try {
            var autenticacao = auth.authenticate(dadosLogin);
            var token = tokenService.gerarToken(autenticacao);
            return ResponseEntity.ok(new TokenDto(token, "Bearer", usuario.getIdUsuario()));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/oauth")
    public ResponseEntity<TokenDto> retornaTokenLogin(@RequestBody UsuarioOAuth usuarioOAuth) {
        var usuario = usuarioService.encontraUsuarioToken(usuarioOAuth);

        if(Objects.isNull(usuario)) {
            usuario = usuarioService.salvarOA(usuarioOAuth);
        }

        if(Objects.isNull(usuario.getGoogleUid())) {
            usuario.setGoogleUid(usuarioOAuth.getGoogleUid());
            usuarioService.atualizarComUid(usuario);
        } else {
            if(!usuario.getGoogleUid().equals(usuarioOAuth.getGoogleUid())) {
                return ResponseEntity.badRequest().build();
            }
        }
        try {
            var token = tokenService.gerarTokenOauth(usuario);
            return ResponseEntity.ok(new TokenDto(token, "Bearer", usuario.getIdUsuario()));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
