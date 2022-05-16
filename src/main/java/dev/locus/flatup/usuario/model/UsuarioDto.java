package dev.locus.flatup.usuario.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    @Email
    @NotBlank(message = "O email não pode ser vazio.")
	private String email;
	
    @Size(min = 8, message = "A senha precisa ser a partir de 8 caracteres.")
    @NotBlank(message = "A senha não pode ser vazia.")
	private String senha;
}
