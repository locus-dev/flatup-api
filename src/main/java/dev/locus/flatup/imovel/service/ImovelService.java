package dev.locus.flatup.imovel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.imovel.model.ImovelDto;
import dev.locus.flatup.imovel.repository.ImovelRepository;

@Service
public class ImovelService {
  
  @Autowired
  ImovelRepository repository;

  public List<ImovelDto> listarImovel() {
    return null;
  }

  public ImovelDto salvar() {
    return null;
  }

  public ImovelDto encontrarImovel() {
    return null;
  }

  public ImovelDto alterarImovel() {
    return null;
  }

  public void removerImovel() {
  }
  
}
