package dev.locus.flatup.localizacao.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.localizacao.model.Localizacao;
import dev.locus.flatup.localizacao.model.LocalizacaoDto;
import dev.locus.flatup.parceiro.model.Parceiro;

@Component
public class LocalizacaoBuilder {

    public LocalizacaoDto builderDto(Localizacao localizacao) {
        return LocalizacaoDto.builder()
                .idImovelFk(localizacao.getIdImovelFk().getIdImovel())
                .idParceiroFk(localizacao.getIdParceiroFk().getIdParceiro())
                .latitude(localizacao.getLatitude())
                .longitude(localizacao.getLongitude())
                .build();
    }

    public Localizacao builderModel(LocalizacaoDto localizacaoDto, Imovel imovel, Parceiro parceiro) {
        return Localizacao.builder()
                .idImovelFk(imovel)
                .idParceiroFk(parceiro)
                .latitude(localizacaoDto.getLatitude())
                .longitude(localizacaoDto.getLongitude())
                .build();
    }
}
