package locus.dev.flatup.locacao.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import locus.dev.flatup.contratolocacao.model.ContratoLocacao;
import locus.dev.flatup.imovel.model.Imovel;
import locus.dev.flatup.usuario.model.Usuario;

@Table
@Entity
public class Locacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocacao;
	
	@ManyToOne
	private Usuario idUsuarioFK;
	
	@OneToOne
	private Imovel idImovelFK;
	
	@OneToOne
	private ContratoLocacao idContratoLocacaoFK;
	
	@Column
	private String statusLocacao;
	
	@Column
	private String quantPessoa;
	
	
	

	public Locacao() {
		super();
	}



	public Locacao(Long idLocacao, Usuario idUsuarioFK, Imovel idImovelFK, ContratoLocacao idContratoLocacaoFK,
			String statusLocacao, String quantPessoa) {
		super();
		this.idLocacao = idLocacao;
		this.idUsuarioFK = idUsuarioFK;
		this.idImovelFK = idImovelFK;
		this.idContratoLocacaoFK = idContratoLocacaoFK;
		this.statusLocacao = statusLocacao;
		this.quantPessoa = quantPessoa;
	}



	public Long getIdLocacao() {
		return idLocacao;
	}



	public void setIdLocacao(Long idLocacao) {
		this.idLocacao = idLocacao;
	}



	public Usuario getIdUsuarioFK() {
		return idUsuarioFK;
	}



	public void setIdUsuarioFK(Usuario idUsuarioFK) {
		this.idUsuarioFK = idUsuarioFK;
	}



	public Imovel getIdImovelFK() {
		return idImovelFK;
	}



	public void setIdImovelFK(Imovel idImovelFK) {
		this.idImovelFK = idImovelFK;
	}



	public ContratoLocacao getIdContratoLocacaoFK() {
		return idContratoLocacaoFK;
	}



	public void setIdContratoLocacaoFK(ContratoLocacao idContratoLocacaoFK) {
		this.idContratoLocacaoFK = idContratoLocacaoFK;
	}



	public String getStatusLocacao() {
		return statusLocacao;
	}



	public void setStatusLocacao(String statusLocacao) {
		this.statusLocacao = statusLocacao;
	}



	public String getQuantPessoa() {
		return quantPessoa;
	}



	public void setQuantPessoa(String quantPessoa) {
		this.quantPessoa = quantPessoa;
	}
	
	
}

	
	