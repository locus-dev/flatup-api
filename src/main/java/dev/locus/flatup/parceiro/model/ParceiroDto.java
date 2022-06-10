package dev.locus.flatup.parceiro.model;

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
public class ParceiroDto {

	private Long idParceiro;

	@NotBlank(message = "A descricao não pode ser vazia.")
	private String descricao;

	@NotBlank(message = "Nome fantasia não pode ser vazio.")
	private String nomeFantasia;

	@NotBlank(message = "O cnpj não pode ser vazio.")
	private String cnpj;

	@NotNull(message = "O usuário deve ser informado.")
	private Long idUsuarioFK;
}