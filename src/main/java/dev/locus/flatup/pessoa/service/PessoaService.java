package dev.locus.flatup.pessoa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.locus.flatup.pessoa.builder.PessoaBuilder;
import dev.locus.flatup.pessoa.model.PessoaDto;
import dev.locus.flatup.pessoa.repository.PessoaRepository;

@Service
public class PessoaService {

  @Autowired
  private PessoaBuilder builder;

  @Autowired
  private PessoaRepository repository;

  public List<PessoaDto> listarPessoas() {
    List<PessoaDto> listaPessoaDtos = new ArrayList<>();

    repository.findAll().forEach(pessoa -> {
      listaPessoaDtos.add(builder.pessoaDtoBuilder(pessoa));
    });

    return listaPessoaDtos;
  }

  @Transactional
  public PessoaDto salvar(PessoaDto pessoaDto) {

    var pessoa = builder.pessoaBuilder(pessoaDto);
    var pessoaSalvo = builder.pessoaDtoBuilder(repository.save(pessoa));
    return pessoaSalvo;
  }

  public PessoaDto encontrarPessoa(Long idPessoa) {
    var pessoa = repository.findById(idPessoa).orElseThrow();
    return builder.builderDto(pessoa);
  }

  @Transactional
  public PessoaDto alterar(Long idPessoa, PessoaDto pessoaDto) {
    pessoaDto.setIdPessoa(idPessoa);
    var pessoa = builder.builderModel(pessoaDto);
    return builder.builderDto(repository.save(pessoa));
  }

  @Transactional
  public void removerPessoa(Long id) {
    repository.deleteById(id);
  }
}
