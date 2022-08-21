package dev.locus.flatup.imovel.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImovelDetalharDto {
    
    private Long idImovel;
    private String tituloAnuncio;
    private Double valorDiaria;
    private LocalDate validadePromocao;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String municipio;
    private String uf;
    private String latitude;
    private String longitude;
}
