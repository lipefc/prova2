package br.com.iblue.prova2.service;

import org.jvnet.hk2.annotations.Service;

import br.com.iblue.prova2.entity.Usuario;

@Service
public class GerarMediaSituacao {

	public Double gerarMedia(Usuario u) {
		u.setMedia((u.getNota1() + u.getNota2() + u.getNota3()) / 3);
		return u.getMedia();
	}
	public String gerarSituacao(Usuario u) {
		u.setSituacao((u.getMedia() >=7) ? "Aprovado" :
			 (u.getMedia()>=5)? "Recuperacao" :  "Reprovado");
		return u.getSituacao();
	}
}