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

	@NotBlank
	@JsonProperty(value = "latitude")
	private String latitude;
	
	@NotBlank
	@JsonProperty(value = "longitude")
	private String longitude;

	@NotNull
	@JsonProperty(value = "imovel_id")
	private Long idImovelFk;

	@JsonProperty(value = "parceiro_id")
	private Long idParceiroFk;
}
