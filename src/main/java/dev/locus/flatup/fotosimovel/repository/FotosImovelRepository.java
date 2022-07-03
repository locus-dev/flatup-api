package dev.locus.flatup.fotosimovel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.fotosimovel.model.FotosImovel;

@Repository
public interface FotosImovelRepository extends JpaRepository<FotosImovel, Long> {

}
