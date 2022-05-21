package dev.locus.flatup.fotosimovel.controller;

import dev.locus.flatup.contratolocacao.model.ContratoLocacao;
import dev.locus.flatup.fotosImovel.model.FotosImovel;
import dev.locus.flatup.fotosImovel.repository.FotosImovelRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FotosImovelController {

	// @Autowired
	// private FotosImovelRepository fotosImovelRepository;

	// public FotosImovelController(FotosImovelRepository fotosImovelRepository) {
	// super();
	// this.fotosImovelRepository = fotosImovelRepository;
	// }

	// @GetMapping("/listarFotosImovel")
	// public List<FotosImovel> listarFotosImoveis(){
	// return fotosImovelRepository.findAll();

	// }

	// @PostMapping(path="/salvarFotosImovel",consumes="application/json" )
	// public ResponseEntity<FotosImovel> salvarFotosImovel(FotosImovel fotosImovel)
	// {

	// fotosImovelRepository.save(fotosImovel);

	// return ResponseEntity.ok(fotosImovel);

	// }

	// @GetMapping("/cadastro/fotosImovel/{id}")
	// public ResponseEntity<FotosImovel> buscarFotosImovelPorId(@PathVariable Long
	// id) throws Exception{
	// FotosImovel fotosImovel = fotosImovelRepository.getById(id);
	// if(fotosImovel == null) {
	// throw new Exception("Fotos do Imóvel nao encontrado pelo id" + id);
	// }

	// return ResponseEntity.ok(fotosImovel);

	// }

	// @PutMapping("/cadastro/fotosImovel/editar/{id}")
	// public ResponseEntity<FotosImovel> editarFotosImovelPorId(@PathVariable("id")
	// Long id, @RequestBody @Valid FotosImovel fotosImovel) throws Exception{

	// FotosImovel opcionalfotosImovel = fotosImovelRepository.getById(id);
	// if(opcionalfotosImovel == null) {
	// return ResponseEntity.unprocessableEntity().build();
	// }

	// FotosImovel novoFotoImovel = fotosImovelRepository.save(opcionalfotosImovel);
	// return ResponseEntity.ok(novoFotoImovel);

	// }

	// @DeleteMapping("/cadastro/fotosImovel/remover/{id}")
	// public ResponseEntity<Map<String, Boolean>>
	// removerFotosImovelPorId(@PathVariable Long id) throws Exception{
	// FotosImovel fotosImovel = fotosImovelRepository.getById(id);
	// if(fotosImovel == null) {
	// throw new Exception("Fotos Do Imóvel nao encontrado" + id);
	// }

	// fotosImovelRepository.deleteById(id);
	// Map<String, Boolean> responseAwait = new HashMap<>();
	// responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
	// return ResponseEntity.ok(responseAwait);
	// }

}
