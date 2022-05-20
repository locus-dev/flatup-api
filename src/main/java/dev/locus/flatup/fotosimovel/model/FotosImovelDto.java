package dev.locus.flatup.fotosimovel.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.locus.flatup.imovel.model.Imovel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FotosImovelDto {

	private Long idFoto;

	@NotNull
	private Imovel idImovelFK;

	@NotBlank
	private String foto;

}