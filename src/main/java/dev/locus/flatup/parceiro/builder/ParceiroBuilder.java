package dev.locus.flatup.parceiro.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.parceiro.model.Parceiro;
import dev.locus.flatup.parceiro.model.ParceiroDto;
import dev.locus.flatup.usuario.model.Usuario;

@Component
public class ParceiroBuilder {

    public ParceiroDto builderDto(Parceiro parceiro) {
        return ParceiroDto.builder()
                .idParceiro(parceiro.getIdParceiro())
                .descricao(parceiro.getDescricao())
                .nomeFantasia(parceiro.getNomeFantasia())
                .cnpj(parceiro.getCnpj())
                .idUsuarioFK(parceiro.getIdUsuarioFK().getIdUsuario())
                .build();
    }

    public Parceiro builderModel(ParceiroDto parceiroDto, Usuario usuario) {
        return Parceiro.builder()
                .descricao(parceiroDto.getDescricao())
                .nomeFantasia(parceiroDto.getNomeFantasia())
                .cnpj(parceiroDto.getCnpj())
                .idUsuarioFK(usuario)
                .build();
    }
}
