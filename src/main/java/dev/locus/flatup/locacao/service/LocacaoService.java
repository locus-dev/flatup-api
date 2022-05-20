package dev.locus.flatup.locacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.locacao.model.LocacaoDto;
import dev.locus.flatup.locacao.repository.LocacaoRepository;

@Service  
public class LocacaoService {
    
  @Autowired
  LocacaoRepository repository;


  public List<LocacaoDto> listarLocacao() {
    return null;
  }

  public LocacaoDto salvar() {
    return null;
  }

  public LocacaoDto encontrarLocacao() {
    return null;
  }

  public LocacaoDto alterarLocacao() {
    return null;
  }

  public void removerLocacao() {
  }
}
