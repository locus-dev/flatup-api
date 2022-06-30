package dev.locus.flatup.auth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.locus.flatup.auth.model.TokenDto;
import dev.locus.flatup.auth.service.TokenService;
import dev.locus.flatup.usuario.model.UsuarioDto;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private AuthenticationManager auth;

    @PostMapping
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

}
