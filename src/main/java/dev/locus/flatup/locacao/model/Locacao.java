package dev.locus.flatup.locacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.imovel.enums.EnumStatusOcupacao;
import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LOCACAO")
@Entity
public class Locacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idLocacao;

	@ManyToOne
	@JoinColumn(name = "USUARIO_ID")
	private Usuario idUsuarioFK;

	@OneToOne
	@JoinColumn(name = "IMOVEL_ID")
	private Imovel idImovelFK;

	@ManyToOne
	@JoinColumn(name = "CONTRATO_LOCACAO_ID")
	private ContratoLocacao idContratoLocacaoFK;

	@Column(name = "STATUS_LOCACAO")
	@Enumerated(EnumType.STRING)
	private EnumStatusLocacao statusLocacao;
}