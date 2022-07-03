package dev.locus.flatup.imovel.controller;

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

import dev.locus.flatup.imovel.model.Imovel;
import dev.locus.flatup.imovel.repository.ImovelRepository;
import dev.locus.flatup.imovel.service.ImovelService;
import dev.locus.flatup.imovel.service.PDFGeneratorServiceImovel;
import dev.locus.flatup.usuario.model.Usuario;
import dev.locus.flatup.usuario.service.PDFGeneratorService;

@RestController
@RequestMapping(value = "/imovel")
@CrossOrigin(origins= "http://localhost:3000", allowedHeaders = "*")
public class ImovelController {
	
	@Autowired
	private ImovelService service;
	
	@Autowired
	private ImovelRepository imovelRepository;

	public ImovelController(ImovelRepository imovelRepository) {
		super();
		this.imovelRepository = imovelRepository;
	}
	
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws DocumentException, IOException{
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=imóveis-" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<Imovel> imoveis = service.listAll();
		System.out.println(imoveis);
		PDFGeneratorServiceImovel exporter = new PDFGeneratorServiceImovel(imoveis);
		exporter.export(response);
		
		
	}
	
	
	@GetMapping("/listar")
	public List<Imovel> listarImoveis() {
		return imovelRepository.findAll();

	}

	@PostMapping(path = "/salvar", consumes = "application/json")
	public ResponseEntity<Imovel> salvarImovel(@RequestBody @Valid Imovel imovel) {
		
		
		imovelRepository.save(imovel);

		return ResponseEntity.ok(imovel);

	}

	@GetMapping("/buscarPorId/{id}")
	public Imovel buscarImovelPorId(@PathVariable("id") Long id) throws Exception {
		return imovelRepository.getById(id);

	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<Imovel> editarImovelPorId(@PathVariable("id") Long id, @RequestBody @Valid Imovel imovel)
			throws Exception {

		Imovel opcionalimovel = imovelRepository.getById(id);
		if (opcionalimovel == null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		Imovel novoimovel = imovelRepository.save(opcionalimovel);
		return ResponseEntity.ok(novoimovel);

	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> removerImovelPorId(@PathVariable Long id) throws Exception {
		
		Imovel imovel = imovelRepository.getById(id);
		if (imovel == null) {
			throw new Exception("Imóvel nao encontrado" + id);
		}

		imovelRepository.deleteById(id);
		Map<String, Boolean> responseAwait = new HashMap<>();
		responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
	}

}
