package dev.locus.flatup.parceiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.locus.flatup.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PARCEIRO")
@Entity
public class Parceiro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idParceiro;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;

	@Column(name = "CNPJ")
	private String cnpj;

	@ManyToOne
	@JoinColumn(name = "USUARIO_ID")
	private Usuario idUsuarioFK;
}