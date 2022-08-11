package dev.locus.flatup.auth.controller;

import javax.validation.Valid;

import com.nimbusds.jose.shaded.json.JSONObject;
import dev.locus.flatup.usuario.builder.UsuarioBuilder;
import dev.locus.flatup.usuario.model.UsuarioOAuth;
import dev.locus.flatup.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.locus.flatup.auth.model.TokenDto;
import dev.locus.flatup.auth.service.TokenService;
import dev.locus.flatup.usuario.model.UsuarioDto;

import java.util.Base64;
import java.util.Objects;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private UsuarioBuilder builder;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> retornaTokenLogin(@RequestBody @Valid UsuarioDto usuarioDto) {
        UsernamePasswordAuthenticationToken dadosLogin = usuarioDto.convertTo();
        try {
            var autenticacao = auth.authenticate(dadosLogin);
            var token = tokenService.gerarToken(autenticacao);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/oauth")
    public ResponseEntity<TokenDto> retornaTokenLogin(@RequestBody UsuarioOAuth usuarioOAuth) {
        var usuario = usuarioService.encontraUsuarioToken(usuarioOAuth);

        if(Objects.isNull(usuario)) {
            throw new RuntimeException("Usuario não encontrado");
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
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
