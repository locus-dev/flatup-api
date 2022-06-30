package dev.locus.flatup.fotosimovel.model;

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
public class FotosImovelDto {

	@JsonProperty(value = "foto_id")
	private Long idFoto;

	@NotNull
	@JsonProperty(value = "imovel_id")
	private Long idImovelFK;

	@NotBlank
	@JsonProperty(value = "foto")
	private String foto;

}