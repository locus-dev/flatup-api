package dev.locus.flatup.parceiro.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.parceiro.builder.ParceiroBuilder;
import dev.locus.flatup.parceiro.model.ParceiroDto;
import dev.locus.flatup.parceiro.repository.ParceiroRepository;
import dev.locus.flatup.usuario.repository.UsuarioRepository;

@Service
public class ParceiroService {
  
  @Autowired
  ParceiroBuilder builder;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  ParceiroRepository repository;
  
  public List<ParceiroDto> listarParceiros() {
    List<ParceiroDto> listaParceiroDtos = new ArrayList<>();

    repository.findAll().forEach(parceiro -> {
      listaParceiroDtos.add(builder.builderDto(parceiro));
    });

    return listaParceiroDtos;
  }

  @Transactional
  public ParceiroDto salvar(ParceiroDto parceiroDto) {
    var usuario = usuarioRepository.findById(parceiroDto.getIdParceiro()).orElseThrow();
    var parceiro = builder.builderModel(parceiroDto, usuario);
    var parceiroSalvo = builder.builderDto(repository.save(parceiro));
    return parceiroSalvo;
  }

  public ParceiroDto encontrarParceiro(Long idParceiro) {
    var parceiro = repository.findById(idParceiro).orElseThrow();
    return builder.builderDto(parceiro);
  }

  @Transactional
  public ParceiroDto alterar(Long idParceiro, ParceiroDto parceiroDto) {
    var usuario = usuarioRepository.findById(parceiroDto.getIdParceiro()).orElseThrow();
    parceiroDto.setIdParceiro(idParceiro);
    var parceiro = builder.builderModel(parceiroDto, usuario);
    return builder.builderDto(repository.save(parceiro));
  }

  @Transactional
  public void removerParceiro(Long id) {
    repository.deleteById(id);
  }
}
