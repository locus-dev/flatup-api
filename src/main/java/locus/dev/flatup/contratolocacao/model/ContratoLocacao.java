package locus.dev.flatup.contratolocacao.model;



import java.time.LocalDateTime;

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
public class ContratoLocacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocacao;
	
	@OneToOne
	private Imovel idImovelFK;
	
	@Column
	private String diasLocacao;
	
	@Column
	private String valorLocacao;
	
	@Column
	private LocalDateTime  checkIn;
	
	@Column
	private LocalDateTime  checkOut;
	
	
	

	public ContratoLocacao() {
		super();
	}

	public ContratoLocacao(Long idLocacao, Imovel idImovelFK, String diasLocacao, String valorLocacao, LocalDateTime checkIn,
			LocalDateTime checkOut) {
		super();
		this.idLocacao = idLocacao;
		this.idImovelFK = idImovelFK;
		this.diasLocacao = diasLocacao;
		this.valorLocacao = valorLocacao;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Long getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(Long idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Imovel getIdImovelFK() {
		return idImovelFK;
	}

	public void setIdImovelFK(Imovel idImovelFK) {
		this.idImovelFK = idImovelFK;
	}

	public String getDiasLocacao() {
		return diasLocacao;
	}

	public void setDiasLocacao(String diasLocacao) {
		this.diasLocacao = diasLocacao;
	}

	public String getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(String valorLocacao) {
		this.valorLocacao = valorLocacao;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}
	
}
	
	
	