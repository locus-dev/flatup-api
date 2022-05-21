package dev.locus.flatup.parceiro.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.parceiro.model.Parceiro;
import dev.locus.flatup.parceiro.model.ParceiroDto;


@Component
public class ParceiroBuilder {
    
    public ParceiroDto builderDto(Parceiro parceiro){
        return ParceiroDto.builder()
                .descricao(parceiro.getDescricao())
                .nomeFantasia(parceiro.getNomeFantasia())
                .cnpj(parceiro.getCnpj())
                .idUsuarioFK(parceiro.getIdUsuarioFK())
                .build();
    }

    public Parceiro builderModel(ParceiroDto parceiroDto){
        return Parceiro.builder()
                .descricao(parceiroDto.getDescricao())
                .nomeFantasia(parceiroDto.getNomeFantasia())
                .cnpj(parceiroDto.getCnpj())
                .idUsuarioFK(parceiroDto.getIdUsuarioFK())
                .build();
    }
}
