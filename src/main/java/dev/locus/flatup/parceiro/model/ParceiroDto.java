package dev.locus.flatup.parceiro.model;

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
public class ParceiroDto {

	@JsonProperty(value = "parceiro_id")
	private Long idParceiro;

	@NotBlank(message = "A descricao não pode ser vazia.")
	@JsonProperty(value = "descricao")
	private String descricao;

	@NotBlank(message = "Nome fantasia não pode ser vazio.")
	@JsonProperty(value = "nome_fantasia")
	private String nomeFantasia;

	@NotBlank(message = "O cnpj não pode ser vazio.")
	@JsonProperty(value = "cnpj")
	private String cnpj;

	@NotNull(message = "O usuário deve ser informado.")
	@JsonProperty(value = "usuario_id")
	private Long idUsuarioFK;
}
