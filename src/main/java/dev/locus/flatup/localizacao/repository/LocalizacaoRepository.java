package dev.locus.flatup.localizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import locus.dev.flatup.locacao.model.Locacao;
import locus.dev.flatup.localizacao.model.Localizacao;



@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {

}
