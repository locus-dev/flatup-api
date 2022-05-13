package locus.dev.flatup.contratolocacao.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import locus.dev.flatup.contratolocacao.model.ContratoLocacao;
import locus.dev.flatup.contratolocacao.repository.ContratoLocacaoRepository;



@RestController
public class ContratoLocacaoController {
	
	@Autowired
	private ContratoLocacaoRepository contratoLocacaoRepository;
	
	
	
	public ContratoLocacaoController(ContratoLocacaoRepository contratoLocacaoRepository) {
		super();
		this.contratoLocacaoRepository = contratoLocacaoRepository;
	}

	@GetMapping("/listarContratoLocacoes")
	public List<ContratoLocacao> listarContratosLocacoes(){
		return contratoLocacaoRepository.findAll();
		
		
	}
	
	@PostMapping(path="/salvarContratoLocacao", consumes="application/json")
	public ResponseEntity<ContratoLocacao> salvarContratoLocacao(@RequestBody @Valid ContratoLocacao contratoLocacao) {
		
		contratoLocacaoRepository.save(contratoLocacao);
		
		return ResponseEntity.ok(contratoLocacao);
		
		
	}
	
	
	
	@GetMapping("/cadastro/contratoLocacao/{id}")
	public ResponseEntity<ContratoLocacao> buscarContratoLocacaoPorId(@PathVariable Long id) throws Exception{
		ContratoLocacao contratoLocacao = contratoLocacaoRepository.getById(id);
		if(contratoLocacao == null) {
			throw new Exception("Contrato de Locação nao encontrado pelo id" + id);
		}
		
		return ResponseEntity.ok(contratoLocacao);
		
	}
	
	@PutMapping("/cadastro/contratoLocacao/editar/{id}")
	public ResponseEntity<ContratoLocacao>  editarContratoLocacaoPorId(@PathVariable("id") Long id, @RequestBody @Valid ContratoLocacao contratoLocacao) throws Exception{
		
		
		ContratoLocacao opcionalcontratoLocacao = contratoLocacaoRepository.getById(id);		
		if(opcionalcontratoLocacao == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		opcionalcontratoLocacao.setIdImovelFK(contratoLocacao.getIdImovelFK());
		opcionalcontratoLocacao.setDiasLocacao(contratoLocacao.getDiasLocacao());
		opcionalcontratoLocacao.setValorLocacao(contratoLocacao.getValorLocacao());
		opcionalcontratoLocacao.setCheckIn(contratoLocacao.getCheckIn());
		opcionalcontratoLocacao.setCheckOut(contratoLocacao.getCheckOut());
		

		
		ContratoLocacao novoContratoLocacao = contratoLocacaoRepository.save(opcionalcontratoLocacao);
		return ResponseEntity.ok(novoContratoLocacao);
		
		
	}
	
	@DeleteMapping("/cadastro/contratoLocacao/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContratoLocacaoById(@PathVariable Long id) throws Exception{
		ContratoLocacao contratoLocacao = contratoLocacaoRepository.getById(id);
		if(contratoLocacao == null) {
			throw new Exception("Contrato de Locação nao encontrado" + id);
		}
		
		contratoLocacaoRepository.deleteById(id);
		Map<String, Boolean> responseAwait = new HashMap<>();
		responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
	}

}
