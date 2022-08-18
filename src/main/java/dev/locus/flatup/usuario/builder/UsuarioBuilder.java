package dev.locus.flatup.usuario.builder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import dev.locus.flatup.usuario.model.Usuario;
import dev.locus.flatup.usuario.model.UsuarioDto;

@Component
public class UsuarioBuilder {

    public UsuarioDto builderDto(Usuario usuarioRecebido) {
        return UsuarioDto
                .builder()
                .idUsuario(usuarioRecebido.getIdUsuario())
                .email(usuarioRecebido.getEmail())
                .senha(new BCryptPasswordEncoder().encode(usuarioRecebido.getSenha()))
                .build();
    }

    public Usuario builderModel(UsuarioDto usuarioDto) {
        return Usuario
                .builder()
                .email(usuarioDto.getEmail())
                .senha(new BCryptPasswordEncoder().encode(usuarioDto.getSenha()))
                .build();
    }
}
