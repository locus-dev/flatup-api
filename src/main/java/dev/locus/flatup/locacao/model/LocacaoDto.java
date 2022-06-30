package dev.locus.flatup.locacao.model;

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
public class LocacaoDto {

	@JsonProperty(value = "locacao_id")
	private Long idLocacao;
	
	@NotNull(message = "O usuário deve ser informado.")
	@JsonProperty(value = "usuario_id")
	private Long idUsuarioFK;

	@NotNull(message = "O imóvel deve ser informado.")
	@JsonProperty(value = "imovel_id")
	private Long idImovelFK;

	@NotNull(message = "O contto de locação não pode ser vazio.")
	@JsonProperty(value = "contrato_locacao_id")
	private Long idContratoLocacaoFK;
	
	@NotNull(message = "O status da locação não pode ser vazio.")
	@JsonProperty(value = "status_locacao")
	private String statusLocacao;
}
