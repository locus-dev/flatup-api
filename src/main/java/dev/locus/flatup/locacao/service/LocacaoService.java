package dev.locus.flatup.locacao.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.locacao.builder.LocacaoBuilder;
import dev.locus.flatup.locacao.model.LocacaoDto;
import dev.locus.flatup.locacao.repository.LocacaoRepository;

@Service  
public class LocacaoService {
    
  @Autowired
  LocacaoBuilder builder;

  @Autowired
  LocacaoRepository repository;

  public List<LocacaoDto> listarLocacaos() {
    List<LocacaoDto> listaLocacaoDtos = new ArrayList<>();

    repository.findAll().forEach(Locacao -> {
      listaLocacaoDtos.add(builder.builderDto(Locacao));
    });

    return listaLocacaoDtos;
  }

  @Transactional
  public LocacaoDto salvar(LocacaoDto locacaoDto) {

    var locacao = builder.builderModel(locacaoDto);
    var locacaoSalvo = builder.builderDto(repository.save(locacao));
    return locacaoSalvo;
  }

  public LocacaoDto encontrarLocacao(Long idLocacao) {
    var locacao = repository.findById(idLocacao).orElseThrow();
    return builder.builderDto(locacao);
  }

  @Transactional
  public LocacaoDto alterar(Long idLocacao, LocacaoDto locacaoDto) {
    locacaoDto.setIdLocacao(idLocacao);
    var locacao = builder.builderModel(locacaoDto);
    return builder.builderDto(repository.save(locacao));
  }

  @Transactional
  public void removerLocacao(Long id) {
    repository.deleteById(id);
  }
}
