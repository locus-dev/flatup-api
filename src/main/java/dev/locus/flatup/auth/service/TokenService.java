package dev.locus.flatup.auth.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import dev.locus.flatup.usuario.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
    
    @Value("${flatup.jwt.expiration}")
    private String expiration;


    @Value("${flatup.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        
        var logado = (Usuario) authentication.getPrincipal();
        
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
            .setIssuer("Usuário do sistema FlatUp")
            .setSubject(logado.getIdUsuario().toString())
            .setIssuedAt(new Date())
            .setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public String gerarTokenOauth(Usuario usuarioOauth) {
        ;
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Usuário do sistema FlatUp")
                .setSubject(usuarioOauth.getIdUsuario().toString())
                .setIssuedAt(new Date())
                .setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        var claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }


}
