package dev.locus.flatup.contratolocacao.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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

import com.lowagie.text.DocumentException;

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.contratolocacao.repository.ContratoLocacaoRepository;
import dev.locus.flatup.contratolocacao.service.ContratoLocacaoService;
import dev.locus.flatup.contratolocacao.service.PDFGeneratorService;
import dev.locus.flatup.contratolocacao.*;

@RestController
@RequestMapping(value = "/contratoLocacao")
public class ContratoLocacaoController {

	@Autowired
	private ContratoLocacaoService contratoLocacaoService;
	
	@Autowired
	private ContratoLocacaoRepository contratoLocacaoRepository;

	
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws DocumentException, IOException{
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=contrato-locacoes-" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<ContratoLocacao> contratoLocacao = contratoLocacaoRepository.findAll();
		System.out.println(contratoLocacao);
		PDFGeneratorService exporter = new PDFGeneratorService(contratoLocacao);
		exporter.export(response);
		
		
	}
	
	@GetMapping("/listar")
	public List<ContratoLocacao> listarContratosLocacoes() {
		return contratoLocacaoRepository.findAll();

	}

	@PostMapping(path = "/salvar", consumes = "application/json")
	public ResponseEntity<ContratoLocacao> salvarContratoLocacao(@RequestBody @Valid ContratoLocacao contratoLocacao) {

		contratoLocacaoRepository.save(contratoLocacao);

		return ResponseEntity.ok(contratoLocacao);

	}

	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<ContratoLocacao> buscarContratoLocacaoPorId(@PathVariable Long id) throws Exception {
		ContratoLocacao contratoLocacao = contratoLocacaoRepository.getById(id);
		if (contratoLocacao == null) {
			throw new Exception("Contrato de Locação nao encontrado pelo id" + id);
		}

		return ResponseEntity.ok(contratoLocacao);

	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<ContratoLocacao> editarContratoLocacaoPorId(@PathVariable("id") Long id,
			@RequestBody @Valid ContratoLocacao contratoLocacao) throws Exception {

		ContratoLocacao opcionalcontratoLocacao = contratoLocacaoRepository.getById(id);
		if (opcionalcontratoLocacao == null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		ContratoLocacao novoContratoLocacao = contratoLocacaoRepository.save(opcionalcontratoLocacao);
		return ResponseEntity.ok(novoContratoLocacao);

	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContratoLocacaoById(@PathVariable Long id) throws Exception {
		ContratoLocacao contratoLocacao = contratoLocacaoRepository.getById(id);
		if (contratoLocacao == null) {
			throw new Exception("Contrato de Locação nao encontrado" + id);
		}

		contratoLocacaoRepository.deleteById(id);
		Map<String, Boolean> responseAwait = new HashMap<>();
		responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
	}

}
