package dev.locus.flatup.imovel.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dev.locus.flatup.endereco.model.Endereco;
import dev.locus.flatup.imovel.enums.EnumClimatizado;
import dev.locus.flatup.imovel.enums.EnumStatusOcupacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "IMOVEL")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Imovel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idImovel;

	@Column(name = "CLIMATIZADO")
	@Enumerated(EnumType.STRING)
	private EnumClimatizado climatizado;

	@Column(name = "STATUS_OCUPACAO")
	@Enumerated(EnumType.STRING)
	
	private EnumStatusOcupacao statusOcupacao;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	@JsonBackReference
	private Endereco idEnderecoFK;
	

//	public Imovel(Endereco idEnderecoFK) {
//		super();
//		this.idEnderecoFK = new Endereco();
//	}
	
	

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


	
}