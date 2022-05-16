package dev.locus.flatup.imovel.enums;

import lombok.Getter;

public enum EnumStatusOcupacao {

    OCUPADO(1, "Ocupado"),
    DESOCUPADO(2, "Desocupado");

    private EnumStatusOcupacao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Getter
    private Integer codigo;
    
    @Getter
    private String descricao;
}
