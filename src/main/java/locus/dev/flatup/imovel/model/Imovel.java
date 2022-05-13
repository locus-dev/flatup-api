package locus.dev.flatup.imovel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import locus.dev.flatup.endereco.model.Endereco;

@Table
@Entity
public class Imovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImovel;
	
	@Column
	private Enum climatizado;
	
	@Column
	private String statusOcupacao;
	
	@OneToOne
	private Endereco idEnderecoFK;
	
	@Column
	private String quantQuarto;
	
	@Column
	private String areaLazer;
	
	@Column
	private String m2;
	
	@Column
	private String piscina;
	
	@Column
	private String quantSuite;
	
	

	public Imovel() {
		super();
	}

	public Imovel(Long idImovel, Enum climatizado, String statusOcupacao, Endereco idEnderecoFK, String quantQuarto,
			String areaLazer, String m2, String piscina, String quantSuite) {
		super();
		this.idImovel = idImovel;
		this.climatizado = climatizado;
		this.statusOcupacao = statusOcupacao;
		this.idEnderecoFK = idEnderecoFK;
		this.quantQuarto = quantQuarto;
		this.areaLazer = areaLazer;
		this.m2 = m2;
		this.piscina = piscina;
		this.quantSuite = quantSuite;
	}

	public Long getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Long idImovel) {
		this.idImovel = idImovel;
	}

	public Enum getClimatizado() {
		return climatizado;
	}

	public void setClimatizado(Enum climatizado) {
		this.climatizado = climatizado;
	}

	public String getStatusOcupacao() {
		return statusOcupacao;
	}

	public void setStatusOcupacao(String statusOcupacao) {
		this.statusOcupacao = statusOcupacao;
	}

	public Endereco getIdEnderecoFK() {
		return idEnderecoFK;
	}

	public void setIdEnderecoFK(Endereco idEnderecoFK) {
		this.idEnderecoFK = idEnderecoFK;
	}

	public String getQuantQuarto() {
		return quantQuarto;
	}

	public void setQuantQuarto(String quantQuarto) {
		this.quantQuarto = quantQuarto;
	}

	public String getAreaLazer() {
		return areaLazer;
	}

	public void setAreaLazer(String areaLazer) {
		this.areaLazer = areaLazer;
	}

	public String getM2() {
		return m2;
	}

	public void setM2(String m2) {
		this.m2 = m2;
	}

	public String getPiscina() {
		return piscina;
	}

	public void setPiscina(String piscina) {
		this.piscina = piscina;
	}

	public String getQuantSuite() {
		return quantSuite;
	}

	public void setQuantSuite(String quantSuite) {
		this.quantSuite = quantSuite;
	}
}