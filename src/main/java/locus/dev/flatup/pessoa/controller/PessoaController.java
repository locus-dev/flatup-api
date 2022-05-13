package locus.dev.flatup.pessoa.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import locus.dev.flatup.parceiro.model.Parceiro;
import locus.dev.flatup.pessoa.model.Pessoa;
import locus.dev.flatup.pessoa.repository.PessoaRepository;



@RestController
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	
	public PessoaController(PessoaRepository pessoaRepository) {
		super();
		this.pessoaRepository = pessoaRepository;
	}

	@GetMapping("/listarPessoa")
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
		
		
	}
	
	@PostMapping("/salvarPessoa")
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
				
	}
	
	
	
	
	
	@GetMapping("/cadastro/pessoa/{id}")
	public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) throws Exception{
		Pessoa pessoa = pessoaRepository.getById(id);
		if(pessoa == null) {
			throw new Exception("Parceiro nao encontrado pelo id" + id);
		}
		
		return ResponseEntity.ok(pessoa);
		
	}
	
	@PutMapping("/cadastro/pessoa/editar/{id}")
	public ResponseEntity<Pessoa>  editarPessoaPorId(@PathVariable("id") Long id, @RequestBody @Valid Pessoa pessoa) throws Exception{
		
		
		Pessoa opcionalPessoa = pessoaRepository.getById(id);		
		if(opcionalPessoa == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		opcionalPessoa.setNome(pessoa.getNome());
		opcionalPessoa.setDataNascimento(pessoa.getDataNascimento());
		opcionalPessoa.setCnpj(pessoa.getCnpj());
		opcionalPessoa.setCpf(pessoa.getCpf());
		opcionalPessoa.setTelefone(pessoa.getTelefone());
		
		Pessoa novopessoa = pessoaRepository.save(opcionalPessoa);
		return ResponseEntity.ok(novopessoa);
		
		
	}
	
	@DeleteMapping("/cadastro/pessoa/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> removerPessoaPeloId(@PathVariable Long id) throws Exception{
		Pessoa pessoa = pessoaRepository.getById(id);
		if(pessoa == null) {
			throw new Exception("Pessoa nao encontrada" + id);
		}
		
		pessoaRepository.deleteById(id);
		Map<String, Boolean> responseAwait = new HashMap<>();
		responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
	}

}
