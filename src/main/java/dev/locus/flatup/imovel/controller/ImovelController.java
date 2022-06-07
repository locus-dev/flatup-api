package dev.locus.flatup.imovel.controller;

import java.util.List;

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

import dev.locus.flatup.imovel.model.ImovelDto;
import dev.locus.flatup.imovel.service.ImovelService;

@RestController
@RequestMapping(value = "/imovel")
public class ImovelController {

	@Autowired
	ImovelService imovelService;

	@GetMapping("/listar")
	public List<ImovelDto> listarImoveis() {
		return imovelService.listarImovels();
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

}
