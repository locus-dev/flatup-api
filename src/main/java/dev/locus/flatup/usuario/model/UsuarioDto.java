package dev.locus.flatup.usuario.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long idUsuario;

    @Email
    @NotBlank(message = "O email não pode ser vazio.")
    @JsonProperty(value = "email")
    private String email;

    @Length(min = 8, message = "A senha precisa ser a partir de 8 caracteres.")
    @NotBlank(message = "A senha não pode ser vazia.")
    @JsonProperty(value = "senha")
    private String senha;

    @JsonProperty("google_id")
    private String googleUid;

    public UsernamePasswordAuthenticationToken convertTo() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }

    public UsernamePasswordAuthenticationToken convertOAuthTo() {
        return new UsernamePasswordAuthenticationToken(email, googleUid, null);
    }
}
