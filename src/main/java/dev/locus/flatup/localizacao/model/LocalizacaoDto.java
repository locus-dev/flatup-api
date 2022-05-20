package dev.locus.flatup.localizacao.model;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalizacaoDto {

	private Long idLocalizacao;

	@NotBlank
	private String latitude;
	
	@NotBlank
	private String longitude;

	@NonNull
	private Long idImovelFk;

	@NonNull
	private Long idParceiroFk;

}
