package locus.dev.flatup.localizacao.controller;



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

import locus.dev.flatup.localizacao.model.Localizacao;
import locus.dev.flatup.localizacao.repository.LocalizacaoRepository;



@RestController
public class LocalizacaoController {
	
	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	
	
	public LocalizacaoController(LocalizacaoRepository localizacaoRepository) {
		super();
		this.localizacaoRepository = localizacaoRepository;
	}

	@GetMapping("/listarLocalizacoes")
	public List<Localizacao> listarLocalizacoes(){
		return localizacaoRepository.findAll();
		
		
	}
	
	@PostMapping(path="/salvarLocalizacao",consumes="application/json" )
	public ResponseEntity<Localizacao> salvarLocalizacao(@RequestBody @Valid Localizacao localizacao) {
		
		localizacaoRepository.save(localizacao);
		
		return ResponseEntity.ok(localizacao);
				
	}
	
	

	@GetMapping("/cadastro/localizacao/{id}")
	public ResponseEntity<Localizacao> buscarLocalizacaoPorId(@PathVariable Long id) throws Exception{
		Localizacao localizacao = localizacaoRepository.getById(id);
		if(localizacao == null) {
			throw new Exception("Localização nao encontrada pelo id" + id);
		}
		
		return ResponseEntity.ok(localizacao);
		
	}
	
	@PutMapping("/cadastro/localizacao/editar/{id}")
	public ResponseEntity<Localizacao>  editarLocalizacaoPorId(@PathVariable("id") Long id, @RequestBody @Valid Localizacao localizacao) throws Exception{
		
		
		Localizacao opcionalLocalizacao = localizacaoRepository.getById(id);		
		if(opcionalLocalizacao == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		opcionalLocalizacao.setLatitude(localizacao.getLatitude());
		opcionalLocalizacao.setLongitude(localizacao.getLongitude());
		
		
		
		

		
		Localizacao novoLocalizacao = localizacaoRepository.save(opcionalLocalizacao);
		return ResponseEntity.ok(novoLocalizacao);
		
		
	}
	
	@DeleteMapping("/cadastro/localizacao/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> removerLocalizacaoPorId(@PathVariable Long id) throws Exception{
		Localizacao localizacao = localizacaoRepository.getById(id);
		if(localizacao == null) {
			throw new Exception("Localização nao encontrado" + id);
		}
		
		localizacaoRepository.deleteById(id);
		Map<String, Boolean> responseAwait = new HashMap<>();
		responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
	}


}
