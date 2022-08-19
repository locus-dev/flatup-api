package dev.locus.flatup.imovel.model;

import dev.locus.flatup.imovel.enums.EnumStatusOcupacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImovelListaDto {
    
    private Long idImovel;
    private String tituloAnuncio;
    private String descricaoAnuncio;
    private String municipio;
    private Double valorLocacao;
    private EnumStatusOcupacao statusOcupacao;
}
