package es.indra.practicaUsuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.indra.practicaUsuarios.model.Usuario;

@Service
public interface UsuarioService {
	
	public List<Usuario> getAllUsuarios();
	
	public Usuario getUsuarioById(int id);
	
	public Usuario saveUsuario(Usuario usuario);
		
	public Boolean editUsuario(Usuario usuario);
	
	public void removeUsuario(Usuario usuario);
	
	public Usuario findByUsernameAndPassword(String username, String Password);
	
	

}
