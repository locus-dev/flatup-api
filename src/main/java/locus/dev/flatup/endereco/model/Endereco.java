package locus.dev.flatup.endereco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import locus.dev.flatup.pessoa.model.Pessoa;

@Table
@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;
	
	@Column
	private String logradouro;
	
	
	@Column
	private String bairro;
	
	@Column
	private String pontoReferencia;
	
	@Column
	private String cep;
	
	@OneToOne
	private Pessoa idPessoaFK;
	
	@Column
	private String numero;
	
	@Column
	private String complemento;
	
	@Column
	private String uf;
	
	@Column
	private String nacionalidade;
	
	

	public Endereco() {
		super();
	}

	public Endereco(Long idEndereco, String logradouro, String bairro, String pontoReferencia, String cep,
			Pessoa idPessoaFK, String numero, String complemento, String uf, String nacionalidade) {
		super();
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.pontoReferencia = pontoReferencia;
		this.cep = cep;
		this.idPessoaFK = idPessoaFK;
		this.numero = numero;
		this.complemento = complemento;
		this.uf = uf;
		this.nacionalidade = nacionalidade;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Pessoa getIdPessoaFK() {
		return idPessoaFK;
	}

	public void setIdPessoaFK(Pessoa idPessoaFK) {
		this.idPessoaFK = idPessoaFK;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	
}
	
	
	

	
