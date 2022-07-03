package dev.locus.flatup.imovel.model;

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
public class ImovelDto {

	
	private Long idImovel;

	@NotBlank
	private String climatizado;

	@NotBlank
	private String statusOcupacao;

	@NotNull
	private Long idEnderecoFK;

	@NotNull
	private Integer quantQuarto;

	@NotNull
	private Boolean areaLazer;

	@NotNull
	private Integer areaM2;

	@NotNull
	private Boolean piscina;

	@NotNull
	private Integer quantSuite;
}