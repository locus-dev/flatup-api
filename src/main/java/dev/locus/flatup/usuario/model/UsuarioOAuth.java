package dev.locus.flatup.usuario.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioOAuth {

    @JsonProperty("email")
    private String email;

    @JsonProperty("google_id")
    private String googleUid;
}
