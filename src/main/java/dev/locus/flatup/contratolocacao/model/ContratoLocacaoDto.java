package dev.locus.flatup.contratolocacao.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.locus.flatup.imovel.model.Imovel;
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

	@NotNull
	private Imovel idImovelFK;

	@NotNull
	private Integer diasLocacao;
	
	@NotNull
	private Integer valorLocacao;
	
	@NotNull
	private LocalDateTime checkIn;
	
	@NotNull
	private LocalDateTime checkOut;
	
	@NotBlank
	private String quantPessoa;
}
