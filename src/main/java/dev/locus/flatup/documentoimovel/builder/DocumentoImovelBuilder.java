package dev.locus.flatup.documentoImovel.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.documentoImovel.model.DocumentoImovel;
import dev.locus.flatup.documentoImovel.model.DocumentoImovelDto;

@Component
public class DocumentoImovelBuilder {
    
    public DocumentoImovelDto builderDto(DocumentoImovel documentoImovel){
        return DocumentoImovelDto.builder().build();
    }

    public DocumentoImovel builderModel(DocumentoImovelDto documentoImovelDto){
        return DocumentoImovel.builder().build();
    }
}
