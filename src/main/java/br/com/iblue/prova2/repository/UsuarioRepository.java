package br.com.iblue.prova2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.iblue.prova2.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	 public Usuario findByEmailAndSenha(String email, String senha);
	 public Usuario findByIdUsuario(Long idUsuario);
	 public List<Usuario>  findByNome(String nome);
}