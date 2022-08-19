package dev.locus.flatup.contratolocacao.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.contratolocacao.model.ContratoLocacaoDto;
import dev.locus.flatup.contratolocacao.service.ContratoLocacaoService;
import dev.locus.flatup.imovel.repository.ImovelRepository;
import dev.locus.flatup.locacao.repository.LocacaoRepository;
import dev.locus.flatup.parceiro.repository.ParceiroRepository;
import dev.locus.flatup.usuario.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/contratolocacao")
public class ContratoLocacaoController {

	@Autowired
	ContratoLocacaoService contratoLocacaoService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private LocacaoRepository locacaoRepository;
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired
	private ParceiroRepository parceiroRepository;
	
	

	@GetMapping("/listar")
	public List<ContratoLocacaoDto> listarContratosLocacoes() {
		return contratoLocacaoService.listarContratoLocacaos();
	}
	
	@GetMapping("/valorTotal")
	public int listarValorContratosLocacoes() {
		List<ContratoLocacao> contratos = contratoLocacaoService.listarContratoLocacaosTodos();
		int valorTotal = 0;
		for(int i = 0; i < contratos.size(); i++) {
			ContratoLocacao contratoLocacao = contratos.get(i);
			Double valorTotalLocacao = contratoLocacao.getValorLocacao();
			valorTotal += valorTotalLocacao;
		}
			
		return valorTotal;
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
	
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws DocumentException, IOException{
		//response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=contrato-locacoes-" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<ContratoLocacaoDto> contratoLocacaoDto = contratoLocacaoService.listarContratoLocacaos();
		
		ContratoLocacaoService exporter = new ContratoLocacaoService(contratoLocacaoDto);
		exporter.export(response);

	}
	
	@RequestMapping(value = "/quantidade",  method = RequestMethod.GET, 
			  headers = "Accept=application/json")
	@ResponseBody
	public List<Long> quantidadeCadastrada(){
		Long usuarioQtde = usuarioRepository.count();
		Long imovelQtde = imovelRepository.count();
		Long locacaoQtde = locacaoRepository.count();
		Long parceiroQtde = parceiroRepository.count();
		
		ArrayList<Long>  lista = new ArrayList();
		lista.add(usuarioQtde);
		lista.add(imovelQtde);
		lista.add(locacaoQtde);
		lista.add(parceiroQtde);
		
		return lista;
	}
	
	

}
