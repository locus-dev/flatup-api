package dev.locus.flatup.documentoimovel.builder;

import org.springframework.stereotype.Component;

import dev.locus.flatup.documentoimovel.model.DocumentoImovel;
import dev.locus.flatup.documentoimovel.model.DocumentoImovelDto;
import dev.locus.flatup.imovel.model.Imovel;

@Component
public class DocumentoImovelBuilder {
    
    public DocumentoImovelDto builderDto(DocumentoImovel documentoImovel){
        return DocumentoImovelDto.builder()
        .idImovelFK(documentoImovel.getIdImovelFK().getIdImovel())
        .documento(documentoImovel.getDocumento())
        .build();
    }

    public DocumentoImovel builderModel(DocumentoImovelDto documentoImovelDto, Imovel imovel){
        return DocumentoImovel.builder()
        .idImovelFK(imovel)
        .documento(documentoImovelDto.getDocumento())
        .build();
    }
}
