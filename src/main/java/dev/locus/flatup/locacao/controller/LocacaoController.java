package dev.locus.flatup.locacao.controller;

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

import dev.locus.flatup.locacao.model.Locacao;
import dev.locus.flatup.locacao.model.LocacaoDto;
import dev.locus.flatup.locacao.service.LocacaoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

	@GetMapping("/encontrar/porUsuario/{id}")
	public ResponseEntity<List<LocacaoDto>> buscarLocacaoPorIdDoUsuario(@PathVariable Long id) throws Exception {
		var locacoesDoUsuarioEspecifico = locacaoService.retornaLocacoesPorUsuarioEspecifico(id);
		return ResponseEntity.ok(locacoesDoUsuarioEspecifico);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<LocacaoDto> editarLocacaoPorId(@PathVariable("id") Long id,
			@RequestBody @Valid LocacaoDto locacaoDto) throws Exception {
		var novaLocacao = locacaoService.alterar(id, locacaoDto);
		return ResponseEntity.ok(novaLocacao);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> removerLocacaoPorId(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/pdf", produces = { "text/plain" })
	public void exportPdf(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=locacoes-" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Locacao> locacaoDto = locacaoService.listarLocacaosTodes();

		LocacaoService exporter = new LocacaoService(locacaoDto);
		exporter.export(response);

	}
}
