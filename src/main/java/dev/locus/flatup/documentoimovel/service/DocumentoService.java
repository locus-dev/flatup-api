package dev.locus.flatup.documentoimovel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.locus.flatup.documentoimovel.movel.DocumentoImovelDto;
import dev.locus.flatup.documentoimovel.repository.DocumentoImovelRepository;

public class DocumentoService {
  
  @Autowired
  DocumentoImovelRepository repository;


  public List<DocumentoImovelDto> listarDocumento() {
    return null;
  }

  public DocumentoImovelDto salvar() {
    return null;
  }

  public DocumentoImovelDto encontrarDocumento() {
    return null;
  }

  public DocumentoImovelDto alterarDocumento() {
    return null;
  }

  public void removerDocumento() {
  }
  
}
