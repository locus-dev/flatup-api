package dev.locus.flatup.auth.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import dev.locus.flatup.auth.service.TokenService;
import dev.locus.flatup.usuario.repository.UsuarioRepository;

public class AuthWithTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuarioRepository usuarioRepository;

    public AuthWithTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    // filtro para token e autenticação
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var token = recuperarToken(request);
        var valido = tokenService.isTokenValido(token);
        
        if(valido) {
            autenticarCliente(token);
        }

        filterChain.doFilter(request, response);
    }

    // autentica o usuário no contexto do Spring
    private void autenticarCliente(String token) {
        var idUsuario = tokenService.getIdUsuario(token);
        var usuario = usuarioRepository.findById(idUsuario);
        var authentication = new UsernamePasswordAuthenticationToken(usuario, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    // recupera token
    private String recuperarToken(HttpServletRequest request) {
        var token = request.getHeader("Authorization");
        if(Objects.isNull(token) || token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
    
}
