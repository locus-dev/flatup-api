package dev.locus.flatup.contratolocacao.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.contratolocacao.model.ContratoLocacaoDto;
import dev.locus.flatup.imovel.model.Imovel;

@Component
public class ContratoLocacaoBuilder {

    public ContratoLocacaoDto builderDto(ContratoLocacao contratolocacao) {
        return ContratoLocacaoDto.builder()
                .idLocacao(contratolocacao.getIdLocacao())
                .idImovelFK(contratolocacao.getIdImovelFK().getIdImovel())
                .checkIn(contratolocacao.getCheckIn())
                .checkOut(contratolocacao.getCheckOut())
                .diasLocacao(contratolocacao.getDiasLocacao())
                .quantPessoa(contratolocacao.getQuantPessoa())
                .valorLocacao(contratolocacao.getValorLocacao())
                .build();
    }

    public ContratoLocacao builderModel(ContratoLocacaoDto contratolocacaoDto, Imovel imovel) {
        return ContratoLocacao.builder()
                .idImovelFK(imovel)
                .checkIn(contratolocacaoDto.getCheckIn())
                .checkOut(contratolocacaoDto.getCheckOut())
                .diasLocacao(contratolocacaoDto.getDiasLocacao())
                .quantPessoa(contratolocacaoDto.getQuantPessoa())
                .valorLocacao(contratolocacaoDto.getValorLocacao())
                .build();
    }
}
