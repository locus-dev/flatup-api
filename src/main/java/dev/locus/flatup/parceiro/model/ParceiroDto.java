package dev.locus.flatup.parceiro.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

	@NotEmpty(message = "A descricao não pode ser vazia.")
	@JsonProperty(value = "descricao")
	private String descricao;

	@NotEmpty(message = "Nome fantasia não pode ser vazio.")
	@JsonProperty(value = "nome_fantasia")
	private String nomeFantasia;

	@NotEmpty(message = "O cnpj não pode ser vazio.")
	@JsonProperty(value = "cnpj")
	private String cnpj;

	// @Size(min = 1, message = "O usuário deve ser informado.")
	//@JsonProperty(value = "usuario_id")
	@JsonIgnore
	private Long idUsuarioFK;
}
