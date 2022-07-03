package dev.locus.flatup.locacao.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.contratolocacao.repository.ContratoLocacaoRepository;
import dev.locus.flatup.imovel.repository.ImovelRepository;
import dev.locus.flatup.locacao.builder.LocacaoBuilder;
import dev.locus.flatup.locacao.model.EnumStatusLocacao;
import dev.locus.flatup.locacao.model.LocacaoDto;
import dev.locus.flatup.locacao.repository.LocacaoRepository;
import dev.locus.flatup.usuario.repository.UsuarioRepository;

@Service  
public class LocacaoService {
    
  @Autowired
  LocacaoBuilder builder;

  @Autowired
  LocacaoRepository repository;

  @Autowired
  ImovelRepository imovelRepository;

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  ContratoLocacaoRepository contratoLocacaoRepository;


  public List<LocacaoDto> listarLocacaos() {
    List<LocacaoDto> listaLocacaoDtos = new ArrayList<>();

    repository.findAll().forEach(Locacao -> {
      listaLocacaoDtos.add(builder.builderDto(Locacao));
    });

    return listaLocacaoDtos;
  }

  @Transactional
  public LocacaoDto salvar(LocacaoDto locacaoDto) {

    var usuario = usuarioRepository.findById(locacaoDto.getIdUsuarioFK()).orElseThrow();
    var imovel = imovelRepository.findById(locacaoDto.getIdImovelFK()).orElseThrow();
    var contratolocacao = contratoLocacaoRepository.findById(locacaoDto.getIdContratoLocacaoFK()).orElseThrow();

    var locacao = builder.builderModel(locacaoDto, imovel, contratolocacao, usuario, EnumStatusLocacao.valueOf(locacaoDto.getStatusLocacao()));
    var locacaoSalvo = builder.builderDto(repository.save(locacao));
    return locacaoSalvo;
  }

  public LocacaoDto encontrarLocacao(Long idLocacao) {
    var locacao = repository.findById(idLocacao).orElseThrow();
    return builder.builderDto(locacao);
  }

  @Transactional
  public LocacaoDto alterar(Long idLocacao, LocacaoDto locacaoDto) {
    var usuario = usuarioRepository.findById(locacaoDto.getIdUsuarioFK()).orElseThrow();
    var imovel = imovelRepository.findById(locacaoDto.getIdImovelFK()).orElseThrow();
    var contratolocacao = contratoLocacaoRepository.findById(locacaoDto.getIdContratoLocacaoFK()).orElseThrow();

    locacaoDto.setIdLocacao(idLocacao);
    var locacao = builder.builderModel(locacaoDto, imovel, contratolocacao, usuario, EnumStatusLocacao.valueOf(locacaoDto.getStatusLocacao()));
    return builder.builderDto(repository.save(locacao));
  }

  @Transactional
  public void removerLocacao(Long id) {
    repository.deleteById(id);
  }
}
