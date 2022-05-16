package dev.locus.flatup.imovel.enums;

import lombok.Getter;

public enum EnumClimatizado {

    CLIMATIZADO(1, "Climatizado"),
    NAO_CLIMATIZADO(2, "Não Climatizado");

    private EnumClimatizado(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Getter
    private Integer codigo;

    @Getter
    private String descricao;
    
}
