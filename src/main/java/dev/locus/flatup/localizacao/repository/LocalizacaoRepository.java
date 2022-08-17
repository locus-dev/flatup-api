package dev.locus.flatup.localizacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.localizacao.model.Localizacao;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {

    @Query(value = "SELECT loc FROM Localizacao loc WHERE loc.imovelFk = :idImovel")
    Optional<Localizacao> findByIdImovelFk(@Param("idImovel") Long id);

}
