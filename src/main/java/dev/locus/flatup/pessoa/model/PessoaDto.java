package dev.locus.flatup.pessoa.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {

    @JsonProperty(value = "pessoa_id")
    private Long idPessoa;
    
    @NotBlank(message = "O nome não pode estar em branco.")
    @JsonProperty(value = "nome")
    private String nome;

    @NotNull(message = "A data de nascimento deve ser fornecida.")
    @JsonProperty(value = "data_nascimento")
    private LocalDateTime dataNascimento;

    @JsonProperty(value = "cpf")
    private String cpf;

    @JsonProperty(value = "cnpj")
    private String cnpj;

    @NotBlank(message = "O telefone deve ser fornecido.")
    @JsonProperty(value = "telefone")
    private String telefone;

    @NotNull(message = "Os dados de cadastro devem estar relacionados a um usuário.")
    @JsonProperty(value = "usuario_id")
    public Long usuarioId;
}
