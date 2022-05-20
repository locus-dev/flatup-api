package dev.locus.flatup.parceiro.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParceiroDto {

	private Long idParceiro;

	@NotBlank
	private String descricao;

	@NotBlank
	private String nomeFantasia;

	@NotBlank
	private String cnpj;

	@NotNull
	private Long idUsuarioFK;
}