package dev.locus.flatup.locacao.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.locacao.model.EnumStatusLocacao;
import dev.locus.flatup.locacao.model.Locacao;
import dev.locus.flatup.locacao.model.LocacaoDto;
import dev.locus.flatup.usuario.model.Usuario;

@Component
public class LocacaoBuilder {

    public LocacaoDto builderDto(Locacao locacao) {
        return LocacaoDto.builder()
                .idImovelFK(locacao.getIdImovelFK().getIdImovel())
                .idContratoLocacaoFK(locacao.getIdContratoLocacaoFK().getIdLocacao())
                .idUsuarioFK(locacao.getIdUsuarioFK().getIdUsuario())
                .statusLocacao(locacao.getStatusLocacao().getDescricao())
                .build();
    }

    public Locacao builderModel(LocacaoDto locacaoDto, Imovel imovel,
            ContratoLocacao contratoLocacao, Usuario usuario,
            EnumStatusLocacao statusLocacao) {
        return Locacao.builder()
                .idUsuarioFK(usuario)
                .idImovelFK(imovel)
                .idContratoLocacaoFK(contratoLocacao)
                .statusLocacao(statusLocacao)
                .build();
    }
}
