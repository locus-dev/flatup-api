package dev.locus.flatup.imovel.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.endereco.model.Endereco;
import dev.locus.flatup.imovel.enums.EnumClimatizado;
import dev.locus.flatup.imovel.enums.EnumStatusOcupacao;
import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.imovel.model.ImovelDetalharDto;
import dev.locus.flatup.imovel.model.ImovelDto;
import dev.locus.flatup.imovel.model.ImovelListaDto;
import dev.locus.flatup.localizacao.model.Localizacao;


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
                .tituloAnuncio(imovel.getTituloAnuncio())
                .descricao(imovel.getDescricao())
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
        .tituloAnuncio(imovelDto.getTituloAnuncio())
        .descricao(imovelDto.getDescricao())
        .build();
    }

    public ImovelListaDto buiderImovelListagem(ContratoLocacao contratoLocaco, Imovel imovel) {
        return ImovelListaDto.builder()
            .idImovel(imovel.getIdImovel())
            .valorLocacao(contratoLocaco.getValorLocacao())
            .municipio(imovel.getMunicipio())
            .descricaoAnuncio(imovel.getDescricao())
            .statusOcupacao(imovel.getStatusOcupacao())
            .tituloAnuncio(imovel.getTituloAnuncio())
            .build();
    }

    public ImovelDetalharDto builderImovelDetalhar(ContratoLocacao contratoLocacao, Localizacao localizacao, Imovel imovel) {
        return ImovelDetalharDto.builder()
            .idImovel(imovel.getIdImovel())
            .tituloAnuncio(imovel.getTituloAnuncio())
            .valorLocacao(contratoLocacao.getValorLocacao())
            .validadePromocao(contratoLocacao.getValidadePromocao())
            .logradouro(imovel.getIdEnderecoFK().getLogradouro())
            .bairro(imovel.getIdEnderecoFK().getBairro())
            .numero(imovel.getIdEnderecoFK().getNumero())
            .complemento(imovel.getIdEnderecoFK().getComplemento())
            .municipio(imovel.getIdEnderecoFK().getCidade())
            .uf(imovel.getIdEnderecoFK().getUf())
            .latitude(localizacao.getLatitude())
            .longitude(localizacao.getLongitude())
            .build();
    }
}
