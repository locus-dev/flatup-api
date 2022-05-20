package dev.locus.flatup.parceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.parceiro.model.ParceiroDto;
import dev.locus.flatup.parceiro.repository.ParceiroRepository;

@Service
public class ParceiroService {
  
  @Autowired
  ParceiroRepository repository;
  
  public List<ParceiroDto> listarParceiros() {
    return null;
  }

  public ParceiroDto salvar() {
    return null;
  }

  public ParceiroDto encontrarParceiro() {
    return null;
  }

  public ParceiroDto alterarParceiro() {
    return null;
  }

  public void removerParceiro() {
  }
  
}
