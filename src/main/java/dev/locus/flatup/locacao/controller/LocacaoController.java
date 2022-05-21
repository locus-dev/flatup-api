package dev.locus.flatup.locacao.controller;

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

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.locacao.model.Locacao;
import dev.locus.flatup.locacao.repository.LocacaoRepository;

@RestController
public class LocacaoController {

	// @Autowired
	// private LocacaoRepository locacaoRepository;

	// public LocacaoController(LocacaoRepository locacaoRepository) {
	// super();
	// this.locacaoRepository = locacaoRepository;
	// }

	// @GetMapping("/listarLocacoes")
	// public List<Locacao> listarLocacoes(){
	// return locacaoRepository.findAll();

	// }

	// @PostMapping(path="/salvarLocacao", consumes="application/json" )
	// public ResponseEntity<Locacao> salvarLocacao(@RequestBody @Valid Locacao
	// locacao) {

	// locacaoRepository.save(locacao);

	// return ResponseEntity.ok(locacao);

	// }

	// @GetMapping("/cadastro/locacao/{id}")
	// public ResponseEntity<Locacao> buscarLocacaoPorId(@PathVariable Long id)
	// throws Exception{
	// Locacao locacao = locacaoRepository.getById(id);
	// if(locacao == null) {
	// throw new Exception("Locação nao encontrada pelo id" + id);
	// }

	// return ResponseEntity.ok(locacao);

	// }

	// @PutMapping("/cadastro/locacao/editar/{id}")
	// public ResponseEntity<Locacao> editarLocacaoPorId(@PathVariable("id") Long
	// id, @RequestBody @Valid Locacao locacao) throws Exception{

	// Locacao opcionalLocacao = locacaoRepository.getById(id);
	// if(opcionalLocacao == null) {
	// return ResponseEntity.unprocessableEntity().build();
	// }

	// Locacao novoLocacao = locacaoRepository.save(opcionalLocacao);
	// return ResponseEntity.ok(novoLocacao);

	// }

	// @DeleteMapping("/cadastro/locacao/remover/{id}")
	// public ResponseEntity<Map<String, Boolean>> removerLocacaoPorId(@PathVariable
	// Long id) throws Exception{
	// Locacao locacao = locacaoRepository.getById(id);
	// if(locacao == null) {
	// throw new Exception("Locação nao encontrado" + id);
	// }

	// locacaoRepository.deleteById(id);
	// Map<String, Boolean> responseAwait = new HashMap<>();
	// responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
	// return ResponseEntity.ok(responseAwait);
	// }

}
