package dev.locus.flatup.pessoa.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.pessoa.model.Pessoa;
import dev.locus.flatup.pessoa.model.PessoaDto;

@Component
public class PessoaBuilder {

    public PessoaDto pessoaDtoBuilder(Pessoa pessoa) {
        return PessoaDto.builder().build();
    }

    public Pessoa pessoaBuilder(PessoaDto pessoaDto) {
        return Pessoa.builder().build();
    }

}
