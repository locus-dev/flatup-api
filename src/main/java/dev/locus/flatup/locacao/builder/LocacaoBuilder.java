package dev.locus.flatup.locacao.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.locacao.model.Locacao;
import dev.locus.flatup.locacao.model.LocacaoDto;


@Component
public class LocacaoBuilder {
    
    public LocacaoDto builderDto(Locacao locacao){
        return LocacaoDto.builder()
                .idUsuarioFK(locacao.getIdUsuarioFK())
                .idImovelFK(locacao.getIdImovelFK())
                .idContratoLocacaoFK(locacao.getIdContratoLocacaoFK())
                .statusLocacao(locacao.getStatusLocacao())
                .build();
    }

    public Locacao builderModel(LocacaoDto locacaoDto){
        return Locacao.builder()
                .idUsuarioFK(locacaoDto.getIdUsuarioFK())
                .idImovelFK(locacaoDto.getIdImovelFK())
                .idContratoLocacaoFK(locacaoDto.getIdContratoLocacaoFK())
                .statusLocacao(locacaoDto.getStatusLocacao())
                .build();
    }
}
