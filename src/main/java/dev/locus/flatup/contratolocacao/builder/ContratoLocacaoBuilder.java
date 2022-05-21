package dev.locus.flatup.contratolocacao.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.contratolocacao.model.ContratoLocacaoDto;

@Component
public class ContratoLocacaoBuilder {
    
    public ContratoLocacaoDto builderDto(ContratoLocacao contratolocacao){
        return ContratoLocacaoDto.builder().build();
    }

    public ContratoLocacao builderModel(ContratoLocacaoDto contratolocacaoDto){
        return ContratoLocacao.builder().build();
    }
}
