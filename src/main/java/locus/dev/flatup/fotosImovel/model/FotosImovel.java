package locus.dev.flatup.fotosImovel.model;

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
public class FotosImovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFoto;
	
	
	@OneToOne
	private Imovel idImovelFK;
	
	@Column
	private String fotoInterna;
	
	@Column
	private String fotoExterna;
	
	
	
	

	public FotosImovel() {
		super();
	}





	public FotosImovel(Long idFoto, Imovel idImovelFK, String fotoInterna, String fotoExterna) {
		super();
		this.idFoto = idFoto;
		this.idImovelFK = idImovelFK;
		this.fotoInterna = fotoInterna;
		this.fotoExterna = fotoExterna;
	}





	public Long getIdFoto() {
		return idFoto;
	}





	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}





	public Imovel getIdImovelFK() {
		return idImovelFK;
	}





	public void setIdImovelFK(Imovel idImovelFK) {
		this.idImovelFK = idImovelFK;
	}





	public String getFotoInterna() {
		return fotoInterna;
	}





	public void setFotoInterna(String fotoInterna) {
		this.fotoInterna = fotoInterna;
	}





	public String getFotoExterna() {
		return fotoExterna;
	}





	public void setFotoExterna(String fotoExterna) {
		this.fotoExterna = fotoExterna;
	}
	
	
	
	
	
	
	
}