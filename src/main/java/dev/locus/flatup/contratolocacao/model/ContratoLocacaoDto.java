package dev.locus.flatup.contratolocacao.model;

import java.time.LocalDateTime;

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
public class ContratoLocacaoDto {

	@JsonProperty(value = "locacao_id")
	private Long idLocacao;

	@NotNull
	@JsonProperty(value = "imovel_id")
	private Long idImovelFK;

	@NotNull
	@JsonProperty(value = "dias_locacao")
	private Integer diasLocacao;
	
	@NotNull
	@JsonProperty(value = "valor_locacao")
	private Integer valorLocacao;
	
	@NotNull
	@JsonProperty(value = "check_in")
	private LocalDateTime checkIn;
	
	@NotNull
	@JsonProperty(value = "check_out")
	private LocalDateTime checkOut;
	
	@NotBlank
	@JsonProperty(value = "quant_pessoa")
	private String quantPessoa;
}
