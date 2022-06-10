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

	@NotBlank(message = "A latitude não pode ser vazia.")
	private String latitude;
	
	@NotBlank(message = "A longitude não pode ser vazia.")
	private String longitude;

	@NotNull(message = "O imóvel deve ser informado.")
	private Long idImovelFk;

@NotNull(message = "O parceiro do imóvel deve ser informado.")
	private Long idParceiroFk;

}
