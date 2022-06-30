package dev.locus.flatup.documentoimovel.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoImovelDto {
	
	@JsonProperty(value = "documento_id")
	private Long idDocumento;
	
	@NotBlank(message = "O documento deve ser informado.")
	@JsonProperty(value = "documento")
	private String documento;
	
	@NotNull(message = "O imóvel deve ser informado.")
	@JsonProperty(value = "imovel_id")
	private Long idImovelFK;
}
	
	
	
