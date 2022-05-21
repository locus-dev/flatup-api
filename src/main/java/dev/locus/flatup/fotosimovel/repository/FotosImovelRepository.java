package dev.locus.flatup.fotosImovel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.fotosImovel.model.FotosImovel;



@Repository
public interface FotosImovelRepository extends JpaRepository<FotosImovel, Long> {

}
