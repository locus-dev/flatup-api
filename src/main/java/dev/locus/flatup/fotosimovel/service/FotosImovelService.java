package dev.locus.flatup.fotosimovel.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.fotosimovel.builder.FotosImovelBuilder;
import dev.locus.flatup.fotosimovel.model.FotosImovelDto;
import dev.locus.flatup.fotosimovel.repository.FotosImovelRepository;
import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.imovel.repository.ImovelRepository;

@Service
public class FotosImovelService {
  
  @Autowired
  FotosImovelBuilder builder;

  @Autowired
  FotosImovelRepository repository;

  @Autowired
  ImovelRepository imovelRepository;

  public List<FotosImovelDto> listarFotosImovels() {
    List<FotosImovelDto> listaFotosImovelDtos = new ArrayList<>();

    repository.findAll().forEach(fotosImovel -> {
      listaFotosImovelDtos.add(builder.builderDto(fotosImovel));
    });

    return listaFotosImovelDtos;
  }

  @Transactional
  public FotosImovelDto salvar(FotosImovelDto fotosImovelDto) {
    var imovel = imovelRepository.findById(fotosImovelDto.getIdImovelFK()).orElseThrow();
    var fotosImovel = builder.builderModel(fotosImovelDto, imovel);
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
    var imovel = imovelRepository.findById(fotosImovelDto.getIdImovelFK()).orElseThrow();
    var fotosImovel = builder.builderModel(fotosImovelDto, imovel);
    return builder.builderDto(repository.save(fotosImovel));
  }

  @Transactional
  public void removerFotosImovel(Long id) {
    repository.deleteById(id);
  }

}
