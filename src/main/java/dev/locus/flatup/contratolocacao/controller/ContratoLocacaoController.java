package dev.locus.flatup.contratolocacao.controller;

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

import dev.locus.flatup.contratolocacao.model.ContratoLocacaoDto;
import dev.locus.flatup.contratolocacao.service.ContratoLocacaoService;

@RestController
@RequestMapping(name = "/contratolocacao")
public class ContratoLocacaoController {

	@Autowired
	ContratoLocacaoService contratoLocacaoService;

	@GetMapping("/listar")
	public List<ContratoLocacaoDto> listarContratosLocacoes() {
		return contratoLocacaoService.listarContratoLocacaos();
	}

	@PostMapping("/salvar")
	public ResponseEntity<ContratoLocacaoDto> salvarContratoLocacao(@RequestBody @Valid ContratoLocacaoDto contratoLocacaoDto) {
		var contratoLocacao = contratoLocacaoService.salvar(contratoLocacaoDto);
		return ResponseEntity.ok(contratoLocacao);
	}

	@GetMapping("/encontrar/{id}")
	public ResponseEntity<ContratoLocacaoDto> buscarContratoLocacaoPorId(@PathVariable Long id) throws Exception {
		var contratoLocacao = contratoLocacaoService.encontrarContratoLocacao(id);
		return ResponseEntity.ok(contratoLocacao);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<ContratoLocacaoDto> editarContratoLocacaoPorId(@PathVariable("id") Long id, @RequestBody @Valid ContratoLocacaoDto contratoLocacaoDto) throws Exception {
		var novoContratoLocacao = contratoLocacaoService.alterar(id, contratoLocacaoDto);
		return ResponseEntity.ok(novoContratoLocacao);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> deleteContratoLocacaoById(@PathVariable Long id) throws Exception {
		contratoLocacaoService.removerContratoLocacao(id);
		return ResponseEntity.ok().build();
	}

}
