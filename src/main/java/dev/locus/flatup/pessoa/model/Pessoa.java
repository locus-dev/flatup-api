package dev.locus.flatup.pessoa.model;

import dev.locus.flatup.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
	private LocalDate dataNascimento;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "CNPJ")
	private String cnpj;

	@Column(name = "TELEFONE")
	private String telefone;

	@OneToOne
	@JoinColumn(name = "USUARIO", unique = true)
	public Usuario usuario;
}
