package dev.locus.flatup.endereco.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.endereco.model.Endereco;
import dev.locus.flatup.endereco.model.EnderecoDto;

@Component
public class EnderecoBuilder {
    
    public EnderecoDto builderDto(Endereco endereco){
        return EnderecoDto.builder().build();
    }

    public Endereco builderModel(EnderecoDto dnderecoDto){
        return Endereco.builder().build();
    }
}
