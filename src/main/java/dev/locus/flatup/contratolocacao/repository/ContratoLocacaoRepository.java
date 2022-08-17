package dev.locus.flatup.contratolocacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;

@Repository
public interface ContratoLocacaoRepository extends JpaRepository<ContratoLocacao, Long> {

    @Query(value = "SELECT cont FROM ContratoLocacao cont WHERE cont.idImovelFK = :idImovel")
    Optional<ContratoLocacao> findContratoByImovelFk(@Param("idImovel") Long id);

}
