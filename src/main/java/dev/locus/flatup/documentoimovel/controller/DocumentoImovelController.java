package dev.locus.flatup.documentoimovel.controller;

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

import dev.locus.flatup.documentoimovel.model.DocumentoImovelDto;
import dev.locus.flatup.documentoimovel.service.DocumentoService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/documentoimovel")
public class DocumentoImovelController {

	@Autowired
	DocumentoService documentoImovelService;

	@GetMapping("/listar")
	public List<DocumentoImovelDto> listarDocumentoImoveis() {
		return documentoImovelService.listarDocumentoImovels();
	}

	@PostMapping("/salvar")
	public ResponseEntity<DocumentoImovelDto> salvarDocumentoImovel(@RequestBody @Valid DocumentoImovelDto documentoImovelDto) {
		var documentoImovel = documentoImovelService.salvar(documentoImovelDto);
		return ResponseEntity.ok(documentoImovel);
	}

	@GetMapping("/encontrar/{id}")
	public ResponseEntity<DocumentoImovelDto> buscarDocumentoImovelPorId(@PathVariable Long id) throws Exception {
		var documentoImovel = documentoImovelService.encontrarDocumentoImovel(id);
		return ResponseEntity.ok(documentoImovel);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<DocumentoImovelDto> editarDocumentoImovelPorId(@PathVariable("id") Long id, @RequestBody @Valid DocumentoImovelDto documentoImovelDto) throws Exception {
		var novoDocumentoImovel = documentoImovelService.alterar(id, documentoImovelDto);
		return ResponseEntity.ok(novoDocumentoImovel);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> removerDocumentoImovelPorId(@PathVariable Long id) throws Exception {
		documentoImovelService.removerDocumentoImovel(id);
		return ResponseEntity.ok().build();
	}
}
