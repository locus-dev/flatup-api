package dev.locus.flatup.fotosimovel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.fotosimovel.model.FotosImovelDto;
import dev.locus.flatup.fotosimovel.repository.FotosImovelRepository;

@Service
public class FotosImovelService {
  
  @Autowired
  FotosImovelRepository repository;


  public List<FotosImovelDto> listarFotosImovel() {
    return null;
  }

  public FotosImovelDto salvar() {
    return null;
  }

  public FotosImovelDto encontrarFotosImovel() {
    return null;
  }

  public FotosImovelDto alterarFotosImovel() {
    return null;
  }

  public void removerFotosImovel() {
  }

}
