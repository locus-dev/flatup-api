package dev.locus.flatup.pessoa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dev.locus.flatup.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PESSOA")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idPessoa;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DATA_NASCIMENTO")
	private Date dataNascimento;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "CNPJ")
	private String cnpj;

	@Column(name = "TELEFONE")
	private String telefone;

	@OneToOne
	public Usuario usuario;
}
