package dev.locus.flatup.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.locus.flatup.endereco.model.Endereco;
import dev.locus.flatup.pessoa.model.Pessoa;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
