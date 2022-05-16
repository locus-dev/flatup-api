package dev.locus.flatup.documentoImovel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import locus.dev.flatup.documentoImovel.movel.DocumentoImovel;



@Repository
public interface DocumentoImovelRepository extends JpaRepository<DocumentoImovel, Long> {

}
