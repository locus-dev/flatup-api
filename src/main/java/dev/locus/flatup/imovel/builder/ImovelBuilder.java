package dev.locus.flatup.imovel.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.endereco.model.Endereco;
import dev.locus.flatup.imovel.enums.EnumClimatizado;
import dev.locus.flatup.imovel.enums.EnumStatusOcupacao;
import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.imovel.model.ImovelDto;


@Component
public class ImovelBuilder {
    
    public ImovelDto builderDto(Imovel imovel){
        return ImovelDto.builder()
                .idImovel(imovel.getIdImovel())
                .areaM2(imovel.getAreaM2())
                .piscina(imovel.getPiscina())
                .areaLazer(imovel.getAreaLazer())
                .quantQuarto(imovel.getQuantQuarto())
                .climatizado(imovel.getClimatizado().getDescricao())
                .idEnderecoFK(imovel.getIdEnderecoFK().getIdEndereco())
                .statusOcupacao(imovel.getStatusOcupacao().getDescricao())
                .quantSuite(imovel.getQuantSuite())
                .build();
    }

    public Imovel builderModel(ImovelDto imovelDto, EnumClimatizado enumClimatizado, Endereco endereco, EnumStatusOcupacao statusOcupacao){
        return Imovel.builder()
        .areaM2(imovelDto.getAreaM2())
        .piscina(imovelDto.getPiscina())
        .areaLazer(imovelDto.getAreaLazer())
        .quantQuarto(imovelDto.getQuantQuarto())
        .climatizado(enumClimatizado)
        .idEnderecoFK(endereco)
        .statusOcupacao(statusOcupacao)
        .quantSuite(imovelDto.getQuantSuite())
        .build();
    }
}
