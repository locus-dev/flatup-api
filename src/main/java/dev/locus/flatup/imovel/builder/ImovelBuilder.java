package dev.locus.flatup.imovel.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.imovel.model.ImovelDto;


@Component
public class ImovelBuilder {
    
    public ImovelDto builderDto(Imovel imovel){
        return ImovelDto.builder().build();
    }

    public Imovel builderModel(ImovelDto imovelDto){
        return Imovel.builder().build();
    }
}
