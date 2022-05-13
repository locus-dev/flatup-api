package locus.dev.flatup.usuario.controller;



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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import locus.dev.flatup.pessoa.model.Pessoa;
import locus.dev.flatup.usuario.model.Usuario;
import locus.dev.flatup.usuario.repository.UsuarioRepository;



@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	public UsuarioController(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/listarUsuario")
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
		
		
	}
	
	@PostMapping(path = "/salvarUsuario", consumes="application/json")
	public ResponseEntity<Usuario> salvarUsuario( @RequestBody @Valid Usuario usuario) {
		
		//Usuario novoUsuario = usuarioRepository.save(usuario);
		Pessoa p = new Pessoa();
		p.setIdPessoa(usuario.getPessoa().getIdPessoa());
		p.setNome(usuario.getPessoa().getNome());
		p.setCpf(usuario.getPessoa().getCpf());
		p.setCnpj(usuario.getPessoa().getCnpj());
		p.setDataNascimento(usuario.getPessoa().getDataNascimento());
		p.setTelefone(usuario.getPessoa().getTelefone());
		
		Usuario s = new Usuario();
		s.setEmail(usuario.getEmail());
		s.setSenha(usuario.getSenha());
		s.setPessoa(p);
		
		usuarioRepository.save(s);
		
		return ResponseEntity.ok(s);
		
		
		
				
	}
	
	
	
	@GetMapping("/cadastro/usuario/{id}")
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) throws Exception{
		Usuario usuario = usuarioRepository.getById(id);
		if(usuario == null) {
			throw new Exception("Usuário nao encontrado pelo id" + id);
		}
		
		return ResponseEntity.ok(usuario);
		
	}
	
	@PutMapping("/cadastro/usuario/editar/{id}")
	public ResponseEntity<Usuario>  editarUsuarioPorId(@PathVariable("id") Long id, @RequestBody @Valid Usuario usuario) throws Exception{
		
		
		Usuario opcionalUsuario = usuarioRepository.getById(id);		
		if(opcionalUsuario == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		opcionalUsuario.setEmail(usuario.getEmail());
		opcionalUsuario.setSenha(usuario.getSenha());
		opcionalUsuario.setPessoa(usuario.getPessoa());
	
		
		Usuario novoUsuario = usuarioRepository.save(opcionalUsuario);
		return ResponseEntity.ok(novoUsuario);
		
		
	}
	
	@DeleteMapping("/cadastro/usuario/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> removeUsuarioPeloId(@PathVariable Long id) throws Exception{
		Usuario usuario = usuarioRepository.getById(id);
		if(usuario == null) {
			throw new Exception("Usuario nao encontrado" + id);
		}
		
		usuarioRepository.deleteById(id);
		Map<String, Boolean> responseAwait = new HashMap<>();
		responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
	}

}
