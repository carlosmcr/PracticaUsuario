package es.indra.practicaUsuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.indra.practicaUsuarios.model.Respuesta;
import es.indra.practicaUsuarios.model.Usuario;
import es.indra.practicaUsuarios.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	Respuesta resp;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value= "/usuario", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		return new ResponseEntity<List<Usuario>>(this.usuarioService.getAllUsuarios(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value= "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") int id){
		return new ResponseEntity<Usuario>(this.usuarioService.getUsuarioById(id), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value= "/usuario", method = RequestMethod.POST)
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(this.usuarioService.saveUsuario(usuario), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value= "/usuario", method = RequestMethod.PUT)
	public ResponseEntity<Respuesta> editUsuario(@RequestBody Usuario usuario){
		if (this.usuarioService.editUsuario(usuario)) {
			resp.setCode(200);
			resp.setMensaje("Usuario Modificada");
			return new ResponseEntity<Respuesta>(resp, HttpStatus.OK);
		}
		resp.setCode(404);
		resp.setMensaje("Error al modificar el  usuario");
		return new ResponseEntity<Respuesta>(resp, HttpStatus.BAD_REQUEST);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value= "/usuario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeUsuario(@PathVariable("id") int id){
		Usuario usuario = this.usuarioService.getUsuarioById(id);
		this.usuarioService.removeUsuario(usuario);
		return new ResponseEntity<String>("Usuario eliminado", HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value= "/usuario/seguridad", method = RequestMethod.POST)
	public ResponseEntity<Respuesta> findByUsernameAndPassword(@RequestBody Usuario usuario){
		if(this.usuarioService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword()) != null) {
			resp.setCode(200);
			resp.setMensaje("Correcto");
			return new ResponseEntity<Respuesta>(resp, HttpStatus.OK);			
		}else
			resp.setCode(404);
			resp.setMensaje("Error");
			return new ResponseEntity<Respuesta>(resp, HttpStatus.OK);
	}
	
}
