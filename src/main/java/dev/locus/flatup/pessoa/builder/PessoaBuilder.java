package dev.locus.flatup.pessoa.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.pessoa.model.Pessoa;
import dev.locus.flatup.pessoa.model.PessoaDto;

@Component
public class PessoaBuilder {

    public PessoaDto builderDto(Pessoa pessoa) {
        return PessoaDto.builder()
        .cnpj(null)
        .cpf(null)
        .dataNascimento(null)
        .idPessoa(null)
        .nome(null)
        .telefone(null)
        .usuarioId(null)
        .build();
    }

    public Pessoa builderModel(PessoaDto pessoaDto) {
        return Pessoa.builder()
        .cnpj(pessoaDto.getCnpj())
        .cpf(pessoaDto.getCpf())
        .dataNascimento(pessoaDto.getDataNascimento())
        .idPessoa(pessoaDto.getIdPessoa())
        .nome(pessoaDto.getNome())
        .telefone(pessoaDto.getTelefone())
        //.usuario(pessoaDto.getUsuarioId()) setar usuário em service
        .build();
    }

}
