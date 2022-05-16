package dev.locus.flatup.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import locus.dev.flatup.endereco.model.Endereco;
import locus.dev.flatup.pessoa.model.Pessoa;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
