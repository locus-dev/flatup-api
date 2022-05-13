package locus.dev.flatup.parceiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import locus.dev.flatup.usuario.model.Usuario;

@Table
@Entity
public class Parceiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParceiro;
	
	@Column
	private String descricao;
	
	@Column
	private String nomeFantasia;
	
	@Column
	private String cnpj;
	
	@ManyToOne
	private Usuario idUsuarioFK;
	
	

	public Parceiro() {
		super();
	}

	public Parceiro(Long idParceiro, String descricao, String nomeFantasia, String cnpj, Usuario idUsuarioFK) {
		super();
		this.idParceiro = idParceiro;
		this.descricao = descricao;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.idUsuarioFK = idUsuarioFK;
	}

	public Long getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(Long idParceiro) {
		this.idParceiro = idParceiro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Usuario getIdUsuarioFK() {
		return idUsuarioFK;
	}

	public void setIdUsuarioFK(Usuario idUsuarioFK) {
		this.idUsuarioFK = idUsuarioFK;
	}
}