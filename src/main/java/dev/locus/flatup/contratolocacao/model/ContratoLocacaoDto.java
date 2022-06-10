package dev.locus.flatup.contratolocacao.model;

import java.time.LocalDateTime;

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
public class ContratoLocacaoDto {

	private Long idLocacao;

	@NotNull(message = "O imóvel deve ser informado.")
	private Long idImovelFK;

	@NotNull(message = "Os dias de locação devem ser informado.")
	private Integer diasLocacao;
	
	@NotNull(message = "O valor da locação deve ser informado.")
	private Integer valorLocacao;
	
	@NotNull(message = "A data de entrada deve ser informada.")
	private LocalDateTime checkIn;
	
	@NotNull(message = "A data de entrada deve ser informada.")
	private LocalDateTime checkOut;
	
	@NotBlank(message = "A quantidade de pessoas deve ser informada.")
	private String quantPessoa;
}
