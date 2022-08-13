package dev.locus.flatup.endereco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import dev.locus.flatup.pessoa.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idEndereco;

	@Column(name = "LOGRADOURO")
	private String logradouro;

	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "PONTO_REFERENCIA")
	private String pontoReferencia;

	@Column(name = "CEP")
	private String cep;

	@OneToOne
	@JoinColumn(name = "PESSOA_ID")
	private Pessoa idPessoaFK;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "UF")
	private String uf;

	@Column(name = "NACIONALIDADE")
	private String nacionalidade;
}
