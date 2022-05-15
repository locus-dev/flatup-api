package locus.dev.flatup.pessoa.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {

    @NotBlank(message = "O nome não pode estar em branco.")
	private String nome;
	
    @NotNull(message = "A data de nascimento deve ser fornecida.")
	private LocalDateTime dataNascimento;
	
    @CPF(message = "Cpf inválido, por favor verifique os dados informados.")
    @NotBlank(message = "O cpf deve ser preenchido")
	private String cpf;
	
    @CNPJ(message = "Cnpj inválido, por favor verifique os dados informados.")
    @NotBlank(message = "O cnpj deve ser preenchido")
	private String cnpj;

    @NotBlank(message = "O telefone deve ser fornecido.")
	private String telefone;
	
	@NotNull(message = "Os dados de cadastro devem estar relacionados a um usuário.")
	public Long usuarioId;
}
