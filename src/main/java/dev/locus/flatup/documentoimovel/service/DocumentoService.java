package dev.locus.flatup.documentoimovel.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import dev.locus.flatup.documentoimovel.builder.DocumentoImovelBuilder;
import dev.locus.flatup.documentoimovel.model.DocumentoImovelDto;
import dev.locus.flatup.documentoimovel.repository.DocumentoImovelRepository;
import dev.locus.flatup.imovel.repository.ImovelRepository;

public class DocumentoService {
  
  @Autowired
  DocumentoImovelBuilder builder;

  @Autowired
  ImovelRepository imovelRepository;

  @Autowired
  DocumentoImovelRepository repository;

  public List<DocumentoImovelDto> listarDocumentoImovels() {
    List<DocumentoImovelDto> listaDocumentoImovelDtos = new ArrayList<>();

    repository.findAll().forEach(documentoImovel -> {
      listaDocumentoImovelDtos.add(builder.builderDto(documentoImovel));
    });

    return listaDocumentoImovelDtos;
  }

  @Transactional
  public DocumentoImovelDto salvar(DocumentoImovelDto documentoImovelDto) {
    var imovel = imovelRepository.findById(documentoImovelDto.getIdImovelFK()).orElseThrow();
    var documentoImovel = builder.builderModel(documentoImovelDto, imovel);
    var documentoImovelSalvo = builder.builderDto(repository.save(documentoImovel));
    return documentoImovelSalvo;
  }

  public DocumentoImovelDto encontrarDocumentoImovel(Long idDocumentoImovel) {
    var DocumentoImovel = repository.findById(idDocumentoImovel).orElseThrow();
    return builder.builderDto(DocumentoImovel);
  }

  @Transactional
  public DocumentoImovelDto alterar(Long idDocumentoImovel, DocumentoImovelDto documentoImovelDto) {
    documentoImovelDto.setIdDocumento(idDocumentoImovel);
    var imovel = imovelRepository.findById(documentoImovelDto.getIdImovelFK()).orElseThrow();
    var documentoImovel = builder.builderModel(documentoImovelDto, imovel);
    return builder.builderDto(repository.save(documentoImovel));
  }

  @Transactional
  public void removerDocumentoImovel(Long id) {
    repository.deleteById(id);
  }  
}
