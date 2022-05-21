package dev.locus.flatup.locacao.model;

import lombok.Getter;

public enum EnumStatusLocacao {

    UNDEFINED(0,"undefined"),
    AGENDADA(1, "Agendada"),
    ATIVA(2, "Ativa"),
    CANCELADA(3, "Cancelada"),
    ENCERRADA(4, "Encerrada");

    private EnumStatusLocacao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Getter
    private Integer codigo;

    @Getter
    private String descricao;
}
