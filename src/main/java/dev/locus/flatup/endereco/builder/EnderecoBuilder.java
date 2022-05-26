package dev.locus.flatup.endereco.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.endereco.model.Endereco;
import dev.locus.flatup.endereco.model.EnderecoDto;
import dev.locus.flatup.pessoa.model.Pessoa;

@Component
public class EnderecoBuilder {

    public EnderecoDto builderDto(Endereco endereco) {
        return EnderecoDto.builder()
                .uf(endereco.getUf())
                .cep(endereco.getCep())
                .bairro(endereco.getBairro())
                .numero(endereco.getNumero())
                .logradouro(endereco.getLogradouro())
                .complemento(endereco.getComplemento())
                .idPessoaFK(endereco.getIdPessoaFK().getIdPessoa())
                .pontoReferencia(endereco.getPontoReferencia())
                .build();
    }

    public Endereco builderModel(EnderecoDto enderecoDto, Pessoa pessoa) {
        return Endereco.builder()
                .idPessoaFK(pessoa)
                .uf(enderecoDto.getUf())
                .cep(enderecoDto.getCep())
                .bairro(enderecoDto.getBairro())
                .numero(enderecoDto.getNumero())
                .logradouro(enderecoDto.getLogradouro())
                .complemento(enderecoDto.getComplemento())
                .pontoReferencia(enderecoDto.getPontoReferencia())
                .build();
    }
}
