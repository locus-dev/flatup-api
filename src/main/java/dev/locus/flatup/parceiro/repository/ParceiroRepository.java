package dev.locus.flatup.parceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.parceiro.model.Parceiro;

@Repository
public interface ParceiroRepository extends JpaRepository<Parceiro, Long> {

}
