package br.com.iblue.prova2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.iblue.prova2.entity.Usuario;
import br.com.iblue.prova2.repository.UsuarioRepository;
import br.com.iblue.prova2.service.UsuarioService;

@ResponseBody
@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioRepository dao;

	@Autowired
	UsuarioService service;

	@PostMapping("/usuario")
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		try {
			Usuario u = dao.save(usuario);
			Map<String, Object> mapa = new HashMap<String, Object>() {
				{
					put("senha", usuario.getSenha());
					put("usuario-saved", u);
					put("status", "gravado com sucesso");
				}
			};
			return ResponseEntity.status(200).body(mapa);
		} catch (Exception ex) {
			Map<String, Object> mapa = new HashMap<String, Object>() {
				{
					put("usuario-error", ex.getMessage());
					put("status", "nao gravado");
				}
			};
			return ResponseEntity.status(500).body(mapa);
		}
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long idUsuario) {
		try {
			Usuario usuario = dao.findById(idUsuario).get();
			if (usuario == null) {
				throw new IllegalAccessException("nao encontrado");
			}
			return ResponseEntity.status(200).body(usuario);
		} catch (Exception ex) {
			Map<String, Object> mapa = new HashMap<String, Object>();
			mapa.put("error-find", ex.getMessage());
			return ResponseEntity.status(404).body(mapa);
		}
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.status(200).body(dao.findAll());
	}
}