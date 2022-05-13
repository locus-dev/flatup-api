package locus.dev.flatup.imovel.controller;



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
import locus.dev.flatup.imovel.model.Imovel;
import locus.dev.flatup.imovel.repository.ImovelRepository;



@RestController
public class ImovelController {
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	
	
	public ImovelController(ImovelRepository imovelRepository) {
		super();
		this.imovelRepository = imovelRepository;
	}

	@GetMapping("/listarImovel")
	public List<Imovel> listarImoveis(){
		return imovelRepository.findAll();
		
		
	}
	
	@PostMapping(path="/salvarImovel", consumes="application/json")
	public ResponseEntity<Imovel> salvarImovel(@RequestBody @Valid Imovel imovel) {
		
		imovelRepository.save(imovel);
		
		
		return ResponseEntity.ok(imovel);
				
	}
	
	
	@GetMapping("/cadastro/imovel/{id}")
	public ResponseEntity<Imovel> buscarImovelPorId(@PathVariable Long id) throws Exception{
		Imovel imovel = imovelRepository.getById(id);
		if(imovel == null) {
			throw new Exception("Imóvel nao encontrado pelo id" + id);
		}
		
		return ResponseEntity.ok(imovel);
		
	}
	
	@PutMapping("/cadastro/imovel/editar/{id}")
	public ResponseEntity<Imovel>  editarImovelPorId(@PathVariable("id") Long id, @RequestBody @Valid Imovel imovel) throws Exception{
		
		
		Imovel opcionalimovel = imovelRepository.getById(id);		
		if(opcionalimovel == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		opcionalimovel.setClimatizado(imovel.getClimatizado());
		opcionalimovel.setStatusOcupacao(imovel.getStatusOcupacao());
		opcionalimovel.setIdEnderecoFK(imovel.getIdEnderecoFK());
		opcionalimovel.setQuantQuarto(imovel.getQuantQuarto());
		opcionalimovel.setAreaLazer(imovel.getAreaLazer());
		opcionalimovel.setM2(imovel.getM2());
		opcionalimovel.setPiscina(imovel.getPiscina());
		opcionalimovel.setQuantSuite(imovel.getQuantSuite());
		
		
		Imovel novoimovel = imovelRepository.save(opcionalimovel);
		return ResponseEntity.ok(novoimovel);
		
		
	}
	
	@DeleteMapping("/cadastro/imovel/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> removerImovelPorId(@PathVariable Long id) throws Exception{
		Imovel imovel = imovelRepository.getById(id);
		if(imovel == null) {
			throw new Exception("Imóvel nao encontrado" + id);
		}
		
		imovelRepository.deleteById(id);
		Map<String, Boolean> responseAwait = new HashMap<>();
		responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
	}

}
