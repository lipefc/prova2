package br.com.iblue.prova2.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.iblue.prova2.entity.Usuario;

@Service
public class UsuarioService {

	public Map<String, Object> gerarUuid(Usuario u) {
		Map<String, Object> mapa = new HashMap<String, Object>() {
			{
				u.setUuid(UUID.randomUUID().toString());
				put("uuid-user", u.getIdUsuario());
			}
		};
		return mapa;
	}
}