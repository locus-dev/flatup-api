package dev.locus.flatup.imovel.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

	@NotBlank(message = "A climatização não pode ser vazia.")
	private String climatizado;

	@NotBlank(message = "O status da ocupação não pode ser vazia.")
	private String statusOcupacao;

	@NotNull(message = "O endereço deve ser informado.")
	private Long idEnderecoFK;

	@NotNull(message = "A quantidade de quarto deve ser informado.")
	private Integer quantQuarto;

	@NotNull
	private Boolean areaLazer;

	@NotNull(message = "A área em m2 não pode ser vazia.")
	private Integer areaM2;

	@NotNull
	private Boolean piscina;

	@NotNull(message = "A quantidade de suítes não pode ser vazia.")
	private Integer quantSuite;

	@NotNull
	private String tituloAnuncio;

	@NotNull
	private String descricao;

	@NotNull
	private String municipio;

	@NotNull
	private LocalDate validadePromocao;

	@NotNull
	private Double valorDiaria;
}