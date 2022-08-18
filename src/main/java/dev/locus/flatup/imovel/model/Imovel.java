package dev.locus.flatup.imovel.model;

import dev.locus.flatup.endereco.model.Endereco;
import dev.locus.flatup.imovel.enums.EnumClimatizado;
import dev.locus.flatup.imovel.enums.EnumStatusOcupacao;
import dev.locus.flatup.pessoa.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "IMOVEL")
@Entity
public class Imovel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idImovel;

	@Column(name = "titulo_anuncio")
	private String tituloAnuncio;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "municipio")
	private String municipio;

	@Column(name = "valor_diaria")
	private int valorDiaria;

	@Column(name = "validade_promocao")
	private LocalDate validadePromocao;

	@Column(name = "CLIMATIZADO")
	@Enumerated(EnumType.STRING)
	private EnumClimatizado climatizado;

	@Column(name = "STATUS_OCUPACAO")
	@Enumerated(EnumType.STRING)
	private EnumStatusOcupacao statusOcupacao;

	@OneToOne
	@JoinColumn(name = "ENDERECO_ID")
	private Endereco idEnderecoFK;

	@Column(name = "QUANT_QUARTOS")
	private Integer quantQuarto;

	@Column(name = "AREA_LAZER")
	private Boolean areaLazer;

	@Column(name = "AREA_M2")
	private Integer areaM2;

	@Column(name = "PISCINA")
	private Boolean piscina;

	@Column(name = "QUANT_SUITE")
	private Integer quantSuite;

	@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa idPessoa;
}