package dev.locus.flatup.endereco.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.endereco.builder.EnderecoBuilder;
import dev.locus.flatup.endereco.model.EnderecoDto;
import dev.locus.flatup.endereco.repository.EnderecoRepository;
import dev.locus.flatup.pessoa.repository.PessoaRepository;

@Service
public class EnderecoService {
  
  @Autowired
  EnderecoBuilder builder;

  @Autowired
  PessoaRepository pessoaRepository;

  @Autowired
  EnderecoRepository repository;

  public List<EnderecoDto> listarEnderecos() {
    List<EnderecoDto> listaEnderecoDtos = new ArrayList<>();

    repository.findAll().forEach(endereco -> {
      listaEnderecoDtos.add(builder.builderDto(endereco));
    });

    return listaEnderecoDtos;
  }

  @Transactional
  public EnderecoDto salvar(EnderecoDto enderecoDto) {
    var pessoa = pessoaRepository.findById(enderecoDto.getIdPessoaFK()).orElseThrow();
    var endereco = builder.builderModel(enderecoDto, pessoa);
    var enderecoSalvo = builder.builderDto(repository.save(endereco));
    return enderecoSalvo;
  }

  public EnderecoDto encontrarEndereco(Long idEndereco) {
    var endereco = repository.findById(idEndereco).orElseThrow();
    return builder.builderDto(endereco);
  }

  @Transactional
  public EnderecoDto alterar(Long idEndereco, EnderecoDto enderecoDto) {
    enderecoDto.setIdEndereco(idEndereco);
    var pessoa = pessoaRepository.findById(enderecoDto.getIdPessoaFK()).orElseThrow();
    var endereco = builder.builderModel(enderecoDto, pessoa);
    return builder.builderDto(repository.save(endereco));
  }

  @Transactional
  public void removerEndereco(Long id) {
    repository.deleteById(id);
  }  

}
