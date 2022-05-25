package dev.locus.flatup.pessoa.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.pessoa.model.Pessoa;
import dev.locus.flatup.pessoa.model.PessoaDto;
import dev.locus.flatup.usuario.model.Usuario;

@Component
public class PessoaBuilder {

    public PessoaDto builderDto(Pessoa pessoa) {
        return PessoaDto.builder()
                .cnpj(pessoa.getCnpj())
                .cpf(pessoa.getCpf())
                .dataNascimento(pessoa.getDataNascimento())
                .idPessoa(pessoa.getIdPessoa())
                .nome(pessoa.getNome())
                .telefone(pessoa.getTelefone())
                .usuarioId(pessoa.getUsuario().getIdUsuario())
                .build();
    }

    public Pessoa builderModel(PessoaDto pessoaDto, Usuario usuario) {
        return Pessoa.builder()
                .cnpj(pessoaDto.getCnpj())
                .cpf(pessoaDto.getCpf())
                .dataNascimento(pessoaDto.getDataNascimento())
                .idPessoa(pessoaDto.getIdPessoa())
                .nome(pessoaDto.getNome())
                .telefone(pessoaDto.getTelefone())
                .usuario(usuario)
                .build();
    }

}
