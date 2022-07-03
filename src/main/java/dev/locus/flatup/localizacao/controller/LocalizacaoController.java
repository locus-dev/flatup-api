package dev.locus.flatup.localizacao.controller;

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

import dev.locus.flatup.localizacao.model.LocalizacaoDto;
import dev.locus.flatup.localizacao.service.LocalizacaoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/localizacao")
public class LocalizacaoController {

	@Autowired
	LocalizacaoService localizacaoService;

	@GetMapping("/listar")
	public List<LocalizacaoDto> listarLocalizacoes() {
		return localizacaoService.listarLocalizacaos();
	}

	@PostMapping("/salvar")
	public ResponseEntity<LocalizacaoDto> salvarLocalizacao(@RequestBody @Valid LocalizacaoDto localizacao) {
		localizacaoService.salvar(localizacao);
		return ResponseEntity.ok(localizacao);
	}

	@GetMapping("/encontrar/{id}")
	public ResponseEntity<LocalizacaoDto> buscarLocalizacaoPorId(@PathVariable Long id) throws Exception {
		var localizacao = localizacaoService.encontrarLocalizacao(id);
		return ResponseEntity.ok(localizacao);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<LocalizacaoDto> editarLocalizacaoPorId(@PathVariable("id") Long id, @RequestBody @Valid LocalizacaoDto localizacaoDto) throws Exception {
		var localizacao = localizacaoService.alterar(id, localizacaoDto);
		return ResponseEntity.ok(localizacao);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> removerLocalizacaoPorId(@PathVariable Long id) throws Exception {
		localizacaoService.removerLocalizacao(id);
		return ResponseEntity.ok().build();
	}

}
