package locus.dev.flatup.localizacao.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import locus.dev.flatup.contratolocacao.model.ContratoLocacao;
import locus.dev.flatup.usuario.model.Usuario;

@Table
@Entity
public class Localizacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocalizacao;
	
	@Column
	private String latitude;
	
	@Column
	private String longitude;
	
	
	public Localizacao() {
		super();
	}


	public Localizacao(Long idLocalizacao, String latitude, String longitude) {
		super();
		this.idLocalizacao = idLocalizacao;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public Long getIdLocalizacao() {
		return idLocalizacao;
	}


	public void setIdLocalizacao(Long idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
	
	
	
		