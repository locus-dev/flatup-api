package dev.locus.flatup.contratolocacao.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.contratolocacao.builder.ContratoLocacaoBuilder;
import dev.locus.flatup.contratolocacao.model.ContratoLocacaoDto;
import dev.locus.flatup.contratolocacao.repository.ContratoLocacaoRepository;
import dev.locus.flatup.imovel.repository.ImovelRepository;

@Service
public class ContratoLocacaoService {

  @Autowired
  ContratoLocacaoBuilder builder;

  @Autowired
  ContratoLocacaoRepository repository;

  @Autowired
  ImovelRepository imovelRepository;

  public List<ContratoLocacaoDto> listarContratoLocacaos() {
    List<ContratoLocacaoDto> listaContratoLocacaoDtos = new ArrayList<>();

    repository.findAll().forEach(ContratoLocacao -> {
      listaContratoLocacaoDtos.add(builder.builderDto(ContratoLocacao));
    });

    return listaContratoLocacaoDtos;
  }

  @Transactional
  public ContratoLocacaoDto salvar(ContratoLocacaoDto contratoLocacaoDto) {
    var imovel = imovelRepository.findById(contratoLocacaoDto.getIdImovelFK()).orElseThrow();
    var contratoLocacao = builder.builderModel(contratoLocacaoDto, imovel);
    var contratoLocacaoSalvo = builder.builderDto(repository.save(contratoLocacao));
    return contratoLocacaoSalvo;
  }

  public ContratoLocacaoDto encontrarContratoLocacao(Long idContratoLocacao) {
    var contratoLocacao = repository.findById(idContratoLocacao).orElseThrow();
    return builder.builderDto(contratoLocacao);
  }

  @Transactional
  public ContratoLocacaoDto alterar(Long idContratoLocacao, ContratoLocacaoDto contratoLocacaoDto) {
    contratoLocacaoDto.setIdLocacao(idContratoLocacao);
    var imovel = imovelRepository.findById(contratoLocacaoDto.getIdImovelFK()).orElseThrow();
    var contratoLocacao = builder.builderModel(contratoLocacaoDto, imovel);
    return builder.builderDto(repository.save(contratoLocacao));
  }

  @Transactional
  public void removerContratoLocacao(Long id) {
    repository.deleteById(id);
  }

}
