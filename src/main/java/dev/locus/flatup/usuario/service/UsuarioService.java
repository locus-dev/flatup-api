package dev.locus.flatup.usuario.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
            listaUsuarioDtos.add(builder.builderDto(usuario));
        });

        return listaUsuarioDtos;
    }

    @Transactional
    public UsuarioDto salvar(UsuarioDto usuarioDto) {
        
        var usuario = builder.builderModel(usuarioDto);
        var usuarioSalvo = builder.builderDto(repository.save(usuario));
        return usuarioSalvo;
    }


    public UsuarioDto encontrarUsuario(Long idUsuario) {
        var usuario = repository.findById(idUsuario).orElseThrow();
        return builder.builderDto(usuario);
    }

    @Transactional
    public UsuarioDto alterar(Long idUsuario, UsuarioDto usuarioDto) {
        usuarioDto.setIdUsuario(idUsuario);
        var usuarioAlterado = repository.save(builder.builderModel(usuarioDto));
        return builder.builderDto(usuarioAlterado);
    }

    @Transactional
    public void removerUsuario(Long id) {
        repository.deleteById(id);
    }
}
