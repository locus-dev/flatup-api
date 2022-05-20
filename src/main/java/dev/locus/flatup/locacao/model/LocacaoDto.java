package dev.locus.flatup.locacao.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocacaoDto {

	private Long idLocacao;
	@NotNull
	private Long idUsuarioFK;
	@NotNull
	private Long idImovelFK;
	@NotNull
	private Long idContratoLocacaoFK;
	@NotNull
	private String statusLocacao;
}