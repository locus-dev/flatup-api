package dev.locus.flatup.localizacao.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalizacaoDto {

	private Long idLocalizacao;

	@NotBlank
	private String latitude;
	
	@NotBlank
	private String longitude;

	@NotNull
	private Long idImovelFk;

	@NotNull
	private Long idParceiroFk;

}
