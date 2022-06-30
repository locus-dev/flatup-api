package dev.locus.flatup.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.locus.flatup.usuario.repository.UsuarioRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var usuarioRetornado = usuarioRepository.findByEmail(email);
        if(usuarioRetornado.isPresent()){
            return usuarioRetornado.get();
        }
        throw new UsernameNotFoundException("Dados inválidos para o usuário");
    }
    
}
