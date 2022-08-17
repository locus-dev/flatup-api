package dev.locus.flatup.imovel.controller;

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

import dev.locus.flatup.contratolocacao.service.ContratoLocacaoService;
import dev.locus.flatup.imovel.model.ImovelDetalharDto;
import dev.locus.flatup.imovel.model.ImovelDto;
import dev.locus.flatup.imovel.model.ImovelListaDto;
import dev.locus.flatup.imovel.service.ImovelService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/imovel")
public class ImovelController {

	@Autowired
	ImovelService imovelService;


	@GetMapping("/listar")
	public List<ImovelDto> listarImoveis() {
		return imovelService.listarImoveis();
	}

	@GetMapping("/listar/descricao")
	public List<ImovelListaDto> listarImoveisDescricao() {
		return imovelService.listarImoveisDescricoes();
	}
	
	@GetMapping("/listar/detalhes/{id}")
	public ImovelDetalharDto listarImoveisDetalhes(@PathVariable("id") Long id) {
		return imovelService.exibirImovelDetalhamento(id);
	}

	@GetMapping("/listar/{id}")
	public List<ImovelDto> listarMeusImoveis(@PathVariable("id") Long idPessoa) {
		return imovelService.listarImoveisPessoa(idPessoa);
	}

	@GetMapping("/listar/{cidade}")
	public List<ImovelDto> listarMeusImoveis(@PathVariable("cidade") String cidade) {
		return imovelService.listarImoveisCidade(cidade);
	}

	@PostMapping("/salvar")
	public ResponseEntity<ImovelDto> salvarImovel(@RequestBody @Valid ImovelDto imovelDto) {
		var imovel = imovelService.salvar(imovelDto);
		return ResponseEntity.ok(imovel);

	}

	@GetMapping("/encontrar/{id}")
	public ResponseEntity<ImovelDto> buscarImovelPorId(@PathVariable Long id) throws Exception {
		var imovel = imovelService.encontrarImovel(id);
		return ResponseEntity.ok(imovel);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<ImovelDto> editarImovelPorId(@PathVariable("id") Long id, @RequestBody @Valid ImovelDto imovelDto) throws Exception {
		var novoimovel = imovelService.alterar(id, imovelDto);
		return ResponseEntity.ok(novoimovel);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> removerImovelPorId(@PathVariable Long id) throws Exception {
		imovelService.removerImovel(id);
		return ResponseEntity.ok().build();
	}

	
	@GetMapping("/pdf/{idPessoa}")
	public void exportPdf(HttpServletResponse response, @PathVariable("idPessoa")  Long idPessoa) throws DocumentException, IOException{
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=imóveis-" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<ImovelDto> imoveisDto = imovelService.listarImoveisPessoa(idPessoa);
		imovelService.export(response, idPessoa);
	}
	
}
