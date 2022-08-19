package dev.locus.flatup.endereco.model;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {

	@JsonProperty(value = "endereco_id")
	private Long idEndereco;

	@NotBlank
	@JsonProperty(value = "logradouro")
	private String logradouro;

	@NotBlank
	@JsonProperty(value = "bairro")
	private String bairro;

	@NotBlank
	@JsonProperty(value = "ponto_referencia")
	private String pontoReferencia;

	@NotBlank
	@JsonProperty(value = "cep")
	private String cep;

	@JsonProperty(value = "pessoa_id")
	private Long idPessoaFK;

	@NotBlank
	@JsonProperty(value = "numero")
	private String numero;

	@NotBlank
	@JsonProperty(value = "complemento")
	private String complemento;

	@NotBlank
	@JsonProperty(value = "uf")
	private String uf;
	
	@NotBlank
	@JsonProperty(value = "cidade")
	private String cidade;

}
