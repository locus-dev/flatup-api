package dev.locus.flatup.endereco.controller;

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

import dev.locus.flatup.endereco.model.EnderecoDto;
import dev.locus.flatup.endereco.service.EnderecoService;

@RestController
@RequestMapping(name = "/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@GetMapping("/listar")
	public List<EnderecoDto> listarEnderecos(){
		return enderecoService.listarEnderecos();
	}

	@PostMapping("/salvar")
	public ResponseEntity<EnderecoDto> salvarEndereco(@RequestBody @Valid EnderecoDto enderecoDto) {
		var endereco = enderecoService.salvar(enderecoDto);
		return ResponseEntity.ok(endereco);
	}

	@GetMapping("/encontrar/{id}")
	public ResponseEntity<EnderecoDto> buscarEnderecoPorId(@PathVariable Long id) throws Exception{
		var endereco = enderecoService.encontrarEndereco(id);
		return ResponseEntity.ok(endereco);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<EnderecoDto> editarEnderecoPorId(@PathVariable("id") Long id, @RequestBody @Valid EnderecoDto enderecoDto) throws Exception{
		var novoEndereco = enderecoService.alterar(id, enderecoDto);
		return ResponseEntity.ok(novoEndereco);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void>
	RemoverEnderecoPorId(@PathVariable Long id) throws Exception{
		enderecoService.removerEndereco(id);
		return ResponseEntity.ok().build();
	}
}
