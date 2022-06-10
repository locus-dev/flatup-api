package dev.locus.flatup.locacao.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocacaoDto {

	private Long idLocacao;
	
	@NotNull(message = "O usuário deve ser informado.")
	private Long idUsuarioFK;

	@NotNull(message = "O imóvel deve ser informado.")
	private Long idImovelFK;

	@NotNull(message = "O contto de locação não pode ser vazio.")
	private Long idContratoLocacaoFK;
	
	@NotNull(message = "O status da locação não pode ser vazio.")
	private String statusLocacao;
}