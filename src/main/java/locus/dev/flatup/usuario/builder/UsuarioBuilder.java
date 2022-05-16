package locus.dev.flatup.usuario.builder;

import java.util.Optional;

import org.springframework.stereotype.Component;

import locus.dev.flatup.usuario.model.Usuario;
import locus.dev.flatup.usuario.model.UsuarioDto;

@Component
public class UsuarioBuilder {
    
    public UsuarioDto userDtoBuilder(Usuario usuarioRecebido) {
        return UsuarioDto
                .builder()
                .email(usuarioRecebido.getEmail())
                .senha(usuarioRecebido.getSenha())
                .build();
    }

    public Usuario userBuilder(UsuarioDto usuarioDto) {
        return Usuario
                .builder()
                .email(usuarioDto.getEmail())
                .senha(usuarioDto.getSenha())
                .build();
    }
}
