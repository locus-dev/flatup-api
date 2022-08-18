package dev.locus.flatup.parceiro.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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

import com.lowagie.text.DocumentException;

import dev.locus.flatup.parceiro.model.Parceiro;
import dev.locus.flatup.parceiro.model.ParceiroDto;
import dev.locus.flatup.parceiro.service.ParceiroService;

@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*" )
@RequestMapping(value = "/parceiro")
public class ParceiroController {

	@Autowired
	private ParceiroService parceiroService;

	@GetMapping("/listar")
	public List<ParceiroDto> listarParceiros() {
		return parceiroService.listarParceiros();
	}

	@PostMapping("/salvar")
	public ResponseEntity<ParceiroDto> salvarParceiro(@RequestBody @Valid ParceiroDto parceiroDto) {
		var parceiro = parceiroService.salvar(parceiroDto);
		return ResponseEntity.ok(parceiro);
	}

	@GetMapping("/encontrar/{id}")
	public ResponseEntity<ParceiroDto> buscarParceiroPorId(@PathVariable Long id) throws Exception {
		var parceiro = parceiroService.encontrarParceiro(id);
		return ResponseEntity.ok(parceiro);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<ParceiroDto> editarParceiroPorId(@PathVariable("id") Long id,
			@RequestBody @Valid ParceiroDto parceiro) throws Exception {
		var novoParceiro = parceiroService.alterar(id, parceiro);
		return ResponseEntity.ok(novoParceiro);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> removerParceiroPeloId(@PathVariable Long id) throws Exception {
		parceiroService.removerParceiro(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	@GetMapping(path="/pdf", produces = { "text/plain" })
	public void exportPdf( HttpServletResponse response) throws DocumentException, IOException{
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=parceiros-" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<Parceiro> parceirosDto = parceiroService.listarParceiroTodes();
		
		ParceiroService exporter = new ParceiroService(parceirosDto);
		exporter.export(response);
		
		
	}
	
	
}
