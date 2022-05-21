package dev.locus.flatup.parceiro.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.parceiro.model.Parceiro;
import dev.locus.flatup.parceiro.model.ParceiroDto;


@Component
public class ParceiroBuilder {
    
    public ParceiroDto builderDto(Parceiro parceiro){
        return ParceiroDto.builder().build();
    }

    public Parceiro builderModel(ParceiroDto parceiroDto){
        return Parceiro.builder().build();
    }
}
