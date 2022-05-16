package dev.locus.flatup.localizacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import locus.dev.flatup.imovel.model.Imovel;
import locus.dev.flatup.parceiro.model.Parceiro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOCALIZACAO")
public class Localizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idLocalizacao;

	@Column(name = "LATITUDE")
	private String latitude;

	@Column(name = "LONGITUDE")
	private String longitude;

	@OneToOne
	@JoinColumn(name = "IMOVEL_ID")
	private Imovel idImovelFk;

	@OneToOne
	@JoinColumn(name = "PARCEIRO_ID")
	private Parceiro idParceiroFk;

}
