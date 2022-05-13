package locus.dev.flatup.documentoImovel.movel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import locus.dev.flatup.imovel.model.Imovel;

@Table
@Entity
public class DocumentoImovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocumento;
	
	@Column
	private String numCertidao;
	
	@OneToOne
	private Imovel idImovelFK;
	
	
	
	
	public DocumentoImovel() {
		super();
	}




	public DocumentoImovel(Long idDocumento, String numCertidao, Imovel idImovelFK) {
		super();
		this.idDocumento = idDocumento;
		this.numCertidao = numCertidao;
		this.idImovelFK = idImovelFK;
	}




	public Long getIdDocumento() {
		return idDocumento;
	}




	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}




	public String getNumCertidao() {
		return numCertidao;
	}




	public void setNumCertidao(String numCertidao) {
		this.numCertidao = numCertidao;
	}




	public Imovel getIdImovelFK() {
		return idImovelFK;
	}




	public void setIdImovelFK(Imovel idImovelFK) {
		this.idImovelFK = idImovelFK;
	}
	
	
}
	
	
	