package es.indra.practicaUsuarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.indra.practicaUsuarios.model.Usuario;
import es.indra.practicaUsuarios.repository.UsuarioRepository;
import es.indra.practicaUsuarios.service.UsuarioService;

@Component
public class UsuarioServiceImpl  implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAllUsuarios() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuarioById(int id) {
		return this.usuarioRepository.getOne(id);
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Boolean editUsuario(Usuario usuario) {
		if (this.usuarioRepository.existsById(usuario.getIdUsuario())) {
			this.usuarioRepository.save(usuario);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void removeUsuario(Usuario usuario) {
		this.usuarioRepository.delete(usuario);
		
	}

	@Override
	public Usuario findByUsernameAndPassword(String username, String Password) {
		return this.usuarioRepository.findByUsernameAndPassword(username, Password);
	}

}
