package dev.locus.flatup.pessoa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.locus.flatup.pessoa.model.PessoaDto;
import dev.locus.flatup.pessoa.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;


	@GetMapping("/listar")
	public List<PessoaDto> listarPessoas() {
		return pessoaService.listarPessoas();
	}

	@PostMapping("/salvar")
	public PessoaDto salvarPessoa(@RequestBody @Valid PessoaDto pessoa) {
		return pessoaService.salvar(pessoa);
	}

	@GetMapping("/encontrar/{id}")
	public ResponseEntity<PessoaDto> buscarPessoaPorId(@PathVariable Long id) throws Exception {
		var pessoa = pessoaService.encontrarPessoa(id);
		return ResponseEntity.ok(pessoa);
	}

	@PutMapping("/editar")
	public ResponseEntity<PessoaDto> editarPessoa(@PathVariable Long id, @RequestBody @Valid PessoaDto pessoaDto) throws Exception {
		var pessoaEditada = pessoaService.alterar(id, pessoaDto);
		return ResponseEntity.ok(pessoaEditada);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> removerPessoaPeloId(@PathVariable Long id) throws Exception {
		pessoaService.removerPessoa(id);
		return ResponseEntity.ok().build();
	}

}
