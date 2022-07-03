package dev.locus.flatup.fotosimovel.model;

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
public class FotosImovelDto {

	private Long idFoto;

	@NotNull
	private Long idImovelFK;

	@NotBlank
	private String foto;

}