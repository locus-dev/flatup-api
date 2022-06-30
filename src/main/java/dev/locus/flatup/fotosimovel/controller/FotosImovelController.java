package dev.locus.flatup.fotosimovel.controller;

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

import dev.locus.flatup.fotosimovel.model.FotosImovelDto;
import dev.locus.flatup.fotosimovel.service.FotosImovelService;

@RestController
@RequestMapping(value = "/fotosimovel")
public class FotosImovelController {

	@Autowired
	FotosImovelService fotosImovelService;

	@GetMapping("/listar")
	public List<FotosImovelDto> listarFotosImoveis() {
		return fotosImovelService.listarFotosImovels();
	}

	@PostMapping("/salvar")
	public ResponseEntity<FotosImovelDto> salvarFotosImovel(@RequestBody @Valid FotosImovelDto fotosImoveldDto) {
		var fotosImovel = fotosImovelService.salvar(fotosImoveldDto);
		return ResponseEntity.ok(fotosImovel);

	}

	@GetMapping("/encontrar{id}")
	public ResponseEntity<FotosImovelDto> buscarFotosImovelPorId(@PathVariable Long id) throws Exception {
		var fotosImovel = fotosImovelService.encontrarFotosImovel(id);
		return ResponseEntity.ok(fotosImovel);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<FotosImovelDto> editarFotosImovelPorId(@PathVariable("id") Long id, @RequestBody @Valid FotosImovelDto fotosImovelDto) throws Exception {
		var novoFotoImovel = fotosImovelService.alterar(id, fotosImovelDto);
		return ResponseEntity.ok(novoFotoImovel);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> removerFotosImovelPorId(@PathVariable Long id) throws Exception {
		fotosImovelService.removerFotosImovel(id);
		return ResponseEntity.ok().build();
	}

}
