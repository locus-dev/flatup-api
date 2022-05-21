package dev.locus.flatup.locacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.locacao.model.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
