package dev.locus.flatup.fotosImovel.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.fotosImovel.builder.FotosImovelBuilder;
import dev.locus.flatup.fotosImovel.model.FotosImovelDto;
import dev.locus.flatup.fotosImovel.repository.FotosImovelRepository;

@Service
public class FotosImovelService {
  
  @Autowired
  FotosImovelBuilder builder;

  @Autowired
  FotosImovelRepository repository;

  public List<FotosImovelDto> listarFotosImovels() {
    List<FotosImovelDto> listaFotosImovelDtos = new ArrayList<>();

    repository.findAll().forEach(fotosImovel -> {
      listaFotosImovelDtos.add(builder.builderDto(fotosImovel));
    });

    return listaFotosImovelDtos;
  }

  @Transactional
  public FotosImovelDto salvar(FotosImovelDto fotosImovelDto) {

    var fotosImovel = builder.builderModel(fotosImovelDto);
    var fotosImovelSalvo = builder.builderDto(repository.save(fotosImovel));
    return fotosImovelSalvo;
  }

  public FotosImovelDto encontrarFotosImovel(Long idFotosImovel) {
    var fotosImovel = repository.findById(idFotosImovel).orElseThrow();
    return builder.builderDto(fotosImovel);
  }

  @Transactional
  public FotosImovelDto alterar(Long idFotosImovel, FotosImovelDto fotosImovelDto) {
    fotosImovelDto.setIdFoto(idFotosImovel);
    var fotosImovel = builder.builderModel(fotosImovelDto);
    return builder.builderDto(repository.save(fotosImovel));
  }

  @Transactional
  public void removerFotosImovel(Long id) {
    repository.deleteById(id);
  }

}
