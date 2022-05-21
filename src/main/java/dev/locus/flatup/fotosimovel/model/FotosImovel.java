package dev.locus.flatup.fotosimovel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dev.locus.flatup.imovel.model.Imovel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FOTO_IMOVEL")
public class FotosImovel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idFoto;

	@OneToOne
	@JoinColumn(name = "IMOVEL_ID")
	private Imovel idImovelFK;

	@Column(name = "FOTO")
	private String foto;

}