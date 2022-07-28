package dev.locus.flatup.imovel.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.endereco.repository.EnderecoRepository;
import dev.locus.flatup.imovel.builder.ImovelBuilder;
import dev.locus.flatup.imovel.enums.EnumClimatizado;
import dev.locus.flatup.imovel.enums.EnumStatusOcupacao;
import dev.locus.flatup.imovel.model.ImovelDto;
import dev.locus.flatup.imovel.repository.ImovelRepository;

@Service
public class ImovelService {

  @Autowired
  ImovelBuilder builder;

  @Autowired
  ImovelRepository repository;

  @Autowired
  EnderecoRepository enderecoRepository;

  public List<ImovelDto> listarImovels() {
    List<ImovelDto> listaImovelDtos = new ArrayList<>();

    repository.findAll().forEach(Imovel -> {
      listaImovelDtos.add(builder.builderDto(Imovel));
    });

    return listaImovelDtos;
  }

  @Transactional
  public ImovelDto salvar(ImovelDto imovelDto) {
    var endereco = enderecoRepository.findById(imovelDto.getIdEnderecoFK()).orElseThrow();
    var imovel = builder.builderModel(imovelDto, EnumClimatizado.valueOf(imovelDto.getClimatizado()), endereco,
        EnumStatusOcupacao.valueOf(imovelDto.getStatusOcupacao()));
    var imovelSalvo = builder.builderDto(repository.save(imovel));
    return imovelSalvo;
  }

  public ImovelDto encontrarImovel(Long idImovel) {
    var imovel = repository.findById(idImovel).orElseThrow();
    return builder.builderDto(imovel);
  }

  @Transactional
  public ImovelDto alterar(Long idImovel, ImovelDto imovelDto) {
    imovelDto.setIdImovel(idImovel);
    var endereco = enderecoRepository.findById(imovelDto.getIdImovel()).orElseThrow();
    var imovel = builder.builderModel(imovelDto, EnumClimatizado.valueOf(imovelDto.getClimatizado()), endereco,
        EnumStatusOcupacao.valueOf(imovelDto.getStatusOcupacao()));
    return builder.builderDto(repository.save(imovel));
  }

  @Transactional
  public void removerImovel(Long id) {
    repository.deleteById(id);
  }

}
