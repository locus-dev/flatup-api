package locus.dev.flatup.locacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import locus.dev.flatup.locacao.model.Locacao;



@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
