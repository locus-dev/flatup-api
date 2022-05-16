package locus.dev.flatup.documentoImovel.movel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import locus.dev.flatup.imovel.model.Imovel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DOCUMENTO_IMOVEL")
@Entity
public class DocumentoImovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idDocumento;
	
	@Column(name = "DOCUMENTO")
	private String documento;
	
	@ManyToOne
	@JoinColumn(name = "IMOVEL_ID")
	private Imovel idImovelFK;
}
	
	
	