package dev.locus.flatup.locacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.locacao.model.Locacao;
import dev.locus.flatup.locacao.model.LocacaoDto;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    @Query(value = "SELECT imo FROM Locacao imo WHERE imo.idUsuarioFK.idUsuario = :usuario_id")
    Locacao retornaLocacaoPorUsuario(@Param("usuario_id") Long usuario_id);
}
