package dev.locus.flatup.fotosimovel.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.fotosimovel.model.FotosImovel;
import dev.locus.flatup.fotosimovel.model.FotosImovelDto;


@Component
public class FotosImovelBuilder {
    
    public FotosImovelDto builderDto(FotosImovel fotosImovel){
        return FotosImovelDto.builder().build();
    }

    public FotosImovel builderModel(FotosImovelDto fotosImovelDto){
        return FotosImovel.builder().build();
    }
}
