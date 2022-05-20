package dev.locus.flatup.contratolocacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.contratolocacao.model.ContratoLocacaoDto;
import dev.locus.flatup.contratolocacao.repository.ContratoLocacaoRepository;

@Service
public class ContratoLocacaoService {
  
  @Autowired
  ContratoLocacaoRepository repository;

  public List<ContratoLocacaoDto> listarContratoLocacao() {
    return null;
  }

  public ContratoLocacaoDto salvar() {
    return null;
  }

  public ContratoLocacaoDto encontrarContratoLocacao() {
    return null;
  }

  public ContratoLocacaoDto alterarContratoLocacao() {
    return null;
  }

  public void removerContratoLocacao() {
  }
  
}
