package dev.locus.flatup.endereco.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.locus.flatup.pessoa.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {

	private Long idEndereco;

	@NotBlank
	private String logradouro;

	@NotBlank
	private String bairro;

	@NotBlank
	private String pontoReferencia;

	@NotBlank
	private String cep;

	@NotNull
	private Pessoa idPessoaFK;

	@NotBlank
	private String numero;

	@NotBlank
	private String complemento;

	@NotBlank
	private String uf;
}
