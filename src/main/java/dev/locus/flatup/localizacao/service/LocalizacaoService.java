package dev.locus.flatup.localizacao.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.imovel.repository.ImovelRepository;
import dev.locus.flatup.localizacao.builder.LocalizacaoBuilder;
import dev.locus.flatup.localizacao.model.LocalizacaoDto;
import dev.locus.flatup.localizacao.repository.LocalizacaoRepository;
import dev.locus.flatup.parceiro.repository.ParceiroRepository;

@Service
public class LocalizacaoService {

  @Autowired
  LocalizacaoBuilder builder;

  @Autowired
  private ImovelRepository imovelRepository;

  @Autowired
  private ParceiroRepository parceiroRepository;

  @Autowired
  LocalizacaoRepository repository;

  public List<LocalizacaoDto> listarLocalizacaos() {
    List<LocalizacaoDto> listaLocalizacaoDtos = new ArrayList<>();

    repository.findAll().forEach(Localizacao -> {
      listaLocalizacaoDtos.add(builder.builderDto(Localizacao));
    });

    return listaLocalizacaoDtos;
  }

  @Transactional
  public LocalizacaoDto salvar(LocalizacaoDto localizacaoDto) {
    var parceiro = parceiroRepository.findById(localizacaoDto.getIdParceiroFk()).orElseThrow();
    var imovel = imovelRepository.findById(localizacaoDto.getIdImovelFk()).orElseThrow();
    var localizacao = builder.builderModel(localizacaoDto, imovel, parceiro);
    var localizacaoSalvo = builder.builderDto(repository.save(localizacao));
    return localizacaoSalvo;
  }

  public LocalizacaoDto encontrarLocalizacao(Long idLocalizacao) {
    var localizacao = repository.findById(idLocalizacao).orElseThrow();
    return builder.builderDto(localizacao);
  }

  @Transactional
  public LocalizacaoDto alterar(Long idLocalizacao, LocalizacaoDto localizacaoDto) {
    var parceiro = parceiroRepository.findById(localizacaoDto.getIdParceiroFk()).orElseThrow();
    var imovel = imovelRepository.findById(localizacaoDto.getIdImovelFk()).orElseThrow();
    localizacaoDto.setIdLocalizacao(idLocalizacao);
    var localizacao = builder.builderModel(localizacaoDto, imovel, parceiro);
    return builder.builderDto(repository.save(localizacao));
  }
  
  @Transactional
  public void removerLocalizacao(Long id) {
    repository.deleteById(id);
  }

}
