package locus.dev.flatup.usuario.model;

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

import locus.dev.flatup.pessoa.model.Pessoa;

@Table
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Pessoa pessoa;
	
	

	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String email, String senha, Pessoa pessoa) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
		this.pessoa = pessoa;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
	
	
	

	
