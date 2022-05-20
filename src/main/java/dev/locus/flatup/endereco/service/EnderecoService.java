package dev.locus.flatup.endereco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.endereco.model.EnderecoDto;
import dev.locus.flatup.endereco.repository.EnderecoRepository;

@Service
public class EnderecoService {
  
  @Autowired
  EnderecoRepository repository;

  public List<EnderecoDto> listarEndereco() {
    return null;
  }

  public EnderecoDto salvar() {
    return null;
  }

  public EnderecoDto encontrarEndereco() {
    return null;
  }

  public EnderecoDto alterarEndereco() {
    return null;
  }

  public void removerEndereco() {
  }

}
