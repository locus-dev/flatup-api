package dev.locus.flatup.imovel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.imovel.model.Imovel;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    List<Imovel> findAllByIdPessoa(Long idPessoa);

    @Query(value = "SELECT imo FROM Imovel imo INNER JOIN imo.idEnderecoFK ende WHERE ende.cidade = :cidade")
    List<Imovel> findAllByCidade(@Param("cidade") String cidade);
}
