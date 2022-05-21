package dev.locus.flatup.localizacao.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.localizacao.model.Localizacao;
import dev.locus.flatup.localizacao.model.LocalizacaoDto;


@Component
public class LocalizacaoBuilder {
    
    public LocalizacaoDto builderDto(Localizacao localizacao){
        return LocalizacaoDto.builder().build();
    }

    public Localizacao builderModel(LocalizacaoDto localizacaoDto){
        return Localizacao.builder().build();
    }
}
