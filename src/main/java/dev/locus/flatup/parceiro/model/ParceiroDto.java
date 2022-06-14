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

	@NotBlank
	@JsonProperty(value = "descricao")
	private String descricao;

	@NotBlank
	@JsonProperty(value = "nome_fantasia")
	private String nomeFantasia;

	@NotBlank
	@JsonProperty(value = "cnpj")
	private String cnpj;

	@NotNull
	@JsonProperty(value = "usuario_id")
	private Long idUsuarioFK;
}