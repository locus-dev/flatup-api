package dev.locus.flatup.documentoimovel.movel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoImovelDto {
	
	private Long idDocumento;
	
	@NotBlank
	private String documento;
	
	@NotNull
	private Long idImovelFK;
}
	
	
	