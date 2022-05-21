package dev.locus.flatup.imovel.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.imovel.model.ImovelDto;


@Component
public class ImovelBuilder {
    
    public ImovelDto builderDto(Imovel imovel){
        return ImovelDto.builder()
                .climatizado(imovel.getClimatizado())
                .idEnderecaoFK(imovel.getIdEnderecoFK())
                .quantQuarto(imovel.getQuantQuarto())
                .areaLazer(imovel.getAreaLazer())
                .areaM2(imovel.getAreaM2())
                .piscina(imovel.getPiscina())
                .quantSuite(imovel.getQuantSuite())
                .build();
    }

    public Imovel builderModel(ImovelDto imovelDto){
        return Imovel.builder()
                .climatizado(imovelDto.getClimatizado())
                .idEnderecaoFK(imovelDto.getIdEnderecoFK())
                .quantQuarto(imovelDto.getQuantQuarto())
                .areaLazer(imovelDto.getAreaLazer())
                .areaM2(imovelDto.getAreaM2())
                .piscina(imovelDto.getPiscina())
                .quantSuite(imovelDto.getQuantSuite())
                .build();
    }
}
