package dev.locus.flatup.contratolocacao.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dev.locus.flatup.imovel.model.Imovel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "CONTRATO_LOCACAO")
public class ContratoLocacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idLocacao;

	@OneToOne
	@JoinColumn(name = "IMOVEL_ID")
	private Imovel idImovelFK;

	@Column(name = "DIAS_LOCACAO")
	private Integer diasLocacao;

	@Column(name = "VALOR_LOCACAO")
	private Double valorLocacao;

	@Column(name = "CHECK_IN")
	private LocalDateTime checkIn;

	@Column(name = "CHECK_OUT")
	private LocalDateTime checkOut;

	@Column(name = "QUANT_PESSOA")
	private String quantPessoa;

	@Column(name = "VALIDADE_PROMOCAO")
	private LocalDateTime validadePromocao;
}
