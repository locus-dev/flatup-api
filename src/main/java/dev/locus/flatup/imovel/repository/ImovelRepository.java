package dev.locus.flatup.imovel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.imovel.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

}
