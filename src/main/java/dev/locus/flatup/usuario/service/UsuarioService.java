package dev.locus.flatup.usuario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.usuario.builder.UsuarioBuilder;
import dev.locus.flatup.usuario.model.UsuarioDto;
import dev.locus.flatup.usuario.repository.UsuarioRepository;

/**
 * Classe de serviço e por gerenciar as chamadas ao repositório.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioBuilder builder;

    @Autowired
    private UsuarioRepository repository;


    public List<UsuarioDto> listarUsuarios() {
        List<UsuarioDto> listaUsuarioDtos = new ArrayList<>();
        
        repository.findAll().forEach(usuario -> {
            listaUsuarioDtos.add(builder.userDtoBuilder(usuario));
        });

        return listaUsuarioDtos;
    }


    public UsuarioDto salvar(UsuarioDto usuarioDto) {
        
        var usuario = builder.userBuilder(usuarioDto);
        var usuarioSalvo = builder.userDtoBuilder(repository.save(usuario));
        return usuarioSalvo;
    }


    public UsuarioDto encontrarUsuario(Long idUsuario) {
        var usuario = repository.findById(idUsuario);

        if(usuario.isPresent()){
            return builder.userDtoBuilder(usuario.get());
        }
        return null;
    }


    public UsuarioDto alterar(Long idUsuario, UsuarioDto usuarioDto) {
        var usuarioConsultado = repository.findById(idUsuario);
        
        if(usuarioConsultado.isPresent()) {
            var usuario = usuarioConsultado.get();
            usuario.setEmail(usuario.getEmail());
            usuario.setSenha(usuario.getSenha());
            return builder.userDtoBuilder(repository.save(usuario));
        }
        return null;
    }


    public void removerUsuario(Long id) {
        repository.deleteById(id);
    }
}
