package dev.locus.flatup.documentoimovel.model;

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
public class DocumentoImovelDto {
	
	private Long idDocumento;
	
	@NotBlank(message = "O documento deve ser informado.")
	private String documento;
	
	@NotNull(message = "O imóvel deve ser informado.")
	private Long idImovelFK;
}
	
	
	