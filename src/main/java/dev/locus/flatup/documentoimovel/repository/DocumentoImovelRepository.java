package dev.locus.flatup.documentoimovel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.documentoimovel.movel.DocumentoImovel;

@Repository
public interface DocumentoImovelRepository extends JpaRepository<DocumentoImovel, Long> {

}
