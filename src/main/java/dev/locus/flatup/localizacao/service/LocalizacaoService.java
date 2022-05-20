package dev.locus.flatup.localizacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.localizacao.model.LocalizacaoDto;
import dev.locus.flatup.localizacao.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {
  
  @Autowired
  LocalizacaoRepository repository;

  public List<LocalizacaoDto> listarLocalizacao() {
    return null;
  }

  public LocalizacaoDto salvar() {
    return null;
  }

  public LocalizacaoDto encontrarLocalizacao() {
    return null;
  }

  public LocalizacaoDto alterarLocalizacao() {
    return null;
  }

  public void removerLocalizacao() {
  }

}
