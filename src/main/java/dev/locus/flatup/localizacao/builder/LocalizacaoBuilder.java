package dev.locus.flatup.localizacao.builder;

import dev.locus.flatup.endereco.model.Endereco;
import org.springframework.stereotype.Component;

import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.localizacao.model.Localizacao;
import dev.locus.flatup.localizacao.model.LocalizacaoDto;
import dev.locus.flatup.parceiro.model.Parceiro;

@Component
public class LocalizacaoBuilder {

    public LocalizacaoDto builderDto(Localizacao localizacao) {
        return LocalizacaoDto.builder()
                .idLocalizacao(localizacao.getIdLocalizacao())
                .idEnderecoFk(localizacao.getIdEnderecoFk().getIdEndereco())
                .latitude(localizacao.getLatitude())
                .longitude(localizacao.getLongitude())
                .build();
    }

    public Localizacao builderModel(LocalizacaoDto localizacaoDto, Endereco endereco) {
        return Localizacao.builder()
                .idEnderecoFk(endereco)
                .latitude(localizacaoDto.getLatitude())
                .longitude(localizacaoDto.getLongitude())
                .build();
    }
}
