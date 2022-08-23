package dev.locus.flatup.localizacao.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalizacaoDto {

	@JsonProperty(value = "localizacao_id")
	private Long idLocalizacao;

	@NotBlank(message = "A latitude não pode ser vazia.")
	@JsonProperty(value = "latitude")
	private String latitude;
	
	@NotBlank(message = "A longitude não pode ser vazia.")
	@JsonProperty(value = "longitude")
	private String longitude;

	@NotNull(message = "O Endereco deve ser informado.")
	@JsonProperty(value = "endereco_id")
	private Long idEnderecoFk;

	@JsonProperty(value = "parceiro_id")
	private Long idParceiroFk;

}
