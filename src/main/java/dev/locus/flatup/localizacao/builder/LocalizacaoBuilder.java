package dev.locus.flatup.localizacao.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.localizacao.model.Localizacao;
import dev.locus.flatup.localizacao.model.LocalizacaoDto;


@Component
public class LocalizacaoBuilder {
    
    public LocalizacaoDto builderDto(Localizacao localizacao){
        return LocalizacaoDto.builder()
                .latitude(localizacao.getLatitude())
                .longitude(localizacao.getLongitude())
                .idImovelFk(localizacao.getIdImovelFk())
                .idParceiroFk(localizacao.getIdParceiroFk())
                .build();
    }

    public Localizacao builderModel(LocalizacaoDto localizacaoDto){
        return Localizacao.builder()
        .latitude(localizacaoDto.getLatitude())
        .longitude(localizacaoDto.getLongitude())
        .idImovelFk(localizacaoDto.getIdImovelFk())
        .idParceiroFk(localizacaoDto.getIdParceiroFk())
        .build();
    }
}
