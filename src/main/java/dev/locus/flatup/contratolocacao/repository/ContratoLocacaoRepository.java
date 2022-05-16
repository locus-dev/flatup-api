package dev.locus.flatup.contratolocacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import locus.dev.flatup.contratolocacao.model.ContratoLocacao;



@Repository
public interface ContratoLocacaoRepository extends JpaRepository<ContratoLocacao, Long> {

}
