package dev.locus.flatup.pessoa.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.pessoa.model.Pessoa;
import dev.locus.flatup.pessoa.model.PessoaDto;

@Component
public class PessoaBuilder {

    public PessoaDto pessoaDtoBuilder(Pessoa usuario) {
        return PessoaDto
                .builder()
                .nome(usuario.getNome())
                .dataNascimento(usuario.getDataNascimento())
                .cpf(usuario.getCpf())
                .cnpj(usuario.getCnpj())
                .telefone(usuario.getTelefone())
                .usuarioId(usuario.getUsuarioId())
                .build();
    }

    public Pessoa pessoaBuilder(PessoaDto pessoaDto) {
        return Pessoa
                .builder()
                .nome(pessoaDto.getNome())
                .dataNascimento(pessoaDto.getDataNascimento())
                .cpf(pessoaDto.getCpf())
                .cnpj(pessoaDto.getCnpj())
                .telefone(pessoaDto.getTelefone())
                .usuarioId(pessoaDto.getUsuarioId())
                .build();
    }

}
