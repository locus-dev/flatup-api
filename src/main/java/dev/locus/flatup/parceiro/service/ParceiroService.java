package dev.locus.flatup.parceiro.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.parceiro.builder.ParceiroBuilder;
import dev.locus.flatup.parceiro.model.ParceiroDto;
import dev.locus.flatup.parceiro.repository.ParceiroRepository;

@Service
public class ParceiroService {
  
  @Autowired
  ParceiroBuilder builder;

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

    var parceiro = builder.builderModel(parceiroDto);
    var parceiroSalvo = builder.builderDto(repository.save(parceiro));
    return parceiroSalvo;
  }

  public ParceiroDto encontrarParceiro(Long idParceiro) {
    var parceiro = repository.findById(idParceiro).orElseThrow();
    return builder.builderDto(parceiro);
  }

  @Transactional
  public ParceiroDto alterar(Long idParceiro, ParceiroDto parceiroDto) {
    parceiroDto.setIdParceiro(idParceiro);
    var parceiro = builder.builderModel(parceiroDto);
    return builder.builderDto(repository.save(parceiro));
  }

  @Transactional
  public void removerParceiro(Long id) {
    repository.deleteById(id);
  }
}
