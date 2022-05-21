package dev.locus.flatup.locacao.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.locacao.model.Locacao;
import dev.locus.flatup.locacao.model.LocacaoDto;


@Component
public class LocacaoBuilder {
    
    public LocacaoDto builderDto(Locacao locacao){
        return LocacaoDto.builder().build();
    }

    public Locacao builderModel(LocacaoDto locacaoDto){
        return Locacao.builder().build();
    }
}
