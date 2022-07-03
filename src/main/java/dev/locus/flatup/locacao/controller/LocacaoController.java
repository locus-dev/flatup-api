package dev.locus.flatup.locacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.locus.flatup.locacao.model.LocacaoDto;
import dev.locus.flatup.locacao.service.LocacaoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/locacao")
public class LocacaoController {

	@Autowired
	LocacaoService locacaoService;

	@GetMapping("/listar")
	public List<LocacaoDto> listarLocacoes() {
		return locacaoService.listarLocacaos();
	}

	@PostMapping("/salvar")
	public ResponseEntity<LocacaoDto> salvarLocacao(@RequestBody @Valid LocacaoDto locacaoDto) {
		var locacao = locacaoService.salvar(locacaoDto);
		return ResponseEntity.ok(locacao);
	}

	@GetMapping("/encontrar/{id}")
	public ResponseEntity<LocacaoDto> buscarLocacaoPorId(@PathVariable Long id) throws Exception {
		var locacao = locacaoService.encontrarLocacao(id);
		return ResponseEntity.ok(locacao);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<LocacaoDto> editarLocacaoPorId(@PathVariable("id") Long id, @RequestBody @Valid LocacaoDto locacaoDto) throws Exception {
		var novaLocacao = locacaoService.alterar(id, locacaoDto);
		return ResponseEntity.ok(novaLocacao);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> removerLocacaoPorId(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok().build();
	}
}
