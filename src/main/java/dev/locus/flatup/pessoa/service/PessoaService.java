package dev.locus.flatup.pessoa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locus.dev.flatup.pessoa.builders.PessoaBuilder;
import locus.dev.flatup.pessoa.model.PessoaDto;
import locus.dev.flatup.pessoa.repository.PessoaRepository;

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

    public PessoaDto salvar(PessoaDto PessoaDto) {
        
        var pessoa = builder.pessoaBuilder(PessoaDto);
        var pessoaSalvo = builder.pessoaDtoBuilder(repository.save(pessoa));
        return pessoaSalvo;
    }


    public PessoaDto encontrarpessoa(Long idpessoa) {
        var pessoa = repository.findById(idpessoa);

        if(pessoa.isPresent()){
            return builder.pessoaDtoBuilder(pessoa.get());
        }
        return null;
    }


    public PessoaDto alterar(Long idpessoa, PessoaDto PessoaDto) {
        var pessoaConsultado = repository.findById(idpessoa);
        
        if(pessoaConsultado.isPresent()) {
            var pessoa = pessoaConsultado.get();
            // TODO adicionar builder para preencher dados.
            return builder.pessoaDtoBuilder(repository.save(pessoa));
        }
        return null;
    }


    public void removerpessoa(Long id) {
        repository.deleteById(id);
    }
}
