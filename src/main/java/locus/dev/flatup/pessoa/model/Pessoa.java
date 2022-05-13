package locus.dev.flatup.pessoa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import locus.dev.flatup.usuario.model.Usuario;

@Table(name="pessoa")
@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;
	
	@Column
	private String nome;
	
	@Column
	private Date dataNascimento;
	
	@Column
	private String cpf;
	
	@Column
	private String cnpj;
	
	@Column
	private String telefone;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy="pessoa")
	@JoinColumn
	//@PrimaryKeyJoinColumn
	public Usuario usuario;
	

	public Pessoa() {
		super();
	}

	public Pessoa(Long idPessoa, String nome, Date dataNascimento, String cpf, String cnpj, String telefone) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.telefone = telefone;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
	
	
	
	
	
