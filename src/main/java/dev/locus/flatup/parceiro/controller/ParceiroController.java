package dev.locus.flatup.parceiro.controller;



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

import locus.dev.flatup.parceiro.model.Parceiro;
import locus.dev.flatup.parceiro.repository.ParceiroRepository;
import locus.dev.flatup.usuario.repository.UsuarioRepository;



@RestController
public class ParceiroController {
	
	// @Autowired
	// private ParceiroRepository parceiroRepository;
	
	// @Autowired
	// private UsuarioRepository usuarioRepository;
	
	
	// public ParceiroController(ParceiroRepository parceiroRepository) {
	// 	super();
	// 	this.parceiroRepository = parceiroRepository;
	// }

	// @GetMapping("/listarParceiros")
	// public List<Parceiro> listarParceiros(){
	// 	return parceiroRepository.findAll();
		
		
	// }
	
	// @PostMapping(path="/salvarParceiro" , consumes="application/json")
	// public ResponseEntity<Parceiro> salvarParceiro(@RequestBody @Valid Parceiro parceiro) {
	// 	//Usuario optUsuario = usuarioRepository.findById(parceiro.getIdUsuarioFK());
		
	// 	parceiroRepository.save(parceiro);
		
	// 	return ResponseEntity.ok(parceiro);
				
	// }
		
	// @GetMapping("/cadastro/parceiro/{id}")
	// public ResponseEntity<Parceiro> buscarParceiroPorId(@PathVariable Long id) throws Exception{
	// 	Parceiro parceiro = parceiroRepository.getById(id);
	// 	if(parceiro == null) {
	// 		throw new Exception("Parceiro nao encontrado pelo id" + id);
	// 	}
		
	// 	return ResponseEntity.ok(parceiro);
		
	// }
	
	// @PutMapping("/cadastro/parceiro/editar/{id}")
	// public ResponseEntity<Parceiro>  editarParceiroPorId(@PathVariable("id") Long id, @RequestBody @Valid Parceiro parceiro) throws Exception{
		
		
	// 	Parceiro opcionalParceiro = parceiroRepository.getById(id);		
	// 	if(opcionalParceiro == null) {
	// 		return ResponseEntity.unprocessableEntity().build();
	// 	}
		
	// 	Parceiro novoparceiro = parceiroRepository.save(opcionalParceiro);
	// 	return ResponseEntity.ok(novoparceiro);
		
		
	// }
	
	// @DeleteMapping("/cadastro/parceiro/remover/{id}")
	// public ResponseEntity<Map<String, Boolean>> removerParceiroPeloId(@PathVariable Long id) throws Exception{
	// 	Parceiro parceiro = parceiroRepository.getById(id);
	// 	if(parceiro == null) {
	// 		throw new Exception("Parceiro nao encontrado" + id);
	// 	}
		
	// 	parceiroRepository.deleteById(id);
	// 	Map<String, Boolean> responseAwait = new HashMap<>();
	// 	responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
	// 	return ResponseEntity.ok(responseAwait);
	// }

}
