package dev.locus.flatup.fotosimovel.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.fotosimovel.model.FotosImovel;
import dev.locus.flatup.fotosimovel.model.FotosImovelDto;
import dev.locus.flatup.imovel.model.Imovel;


@Component
public class FotosImovelBuilder {
    
    public FotosImovelDto builderDto(FotosImovel fotosImovel){
        return FotosImovelDto.builder()
                .idFoto(fotosImovel.getIdFoto())
                .idImovelFK(fotosImovel.getIdImovelFK().getIdImovel())
                .foto(fotosImovel.getFoto())
                .build();
    }

    public FotosImovel builderModel(FotosImovelDto fotosImovelDto, Imovel imovel){
        return FotosImovel.builder()
        .foto(fotosImovelDto.getFoto())
        .idImovelFK(imovel)
        .build();
    }
}
