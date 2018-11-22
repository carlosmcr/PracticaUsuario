package es.indra.practicaUsuarios.model;

import javax.annotation.ManagedBean;

@ManagedBean
public class Respuesta {

	private String mensaje;
	private int code;

	public Respuesta() {

	}

	public Respuesta(String mensaje, int code) {
		super();
		this.mensaje = mensaje;
		this.code = code;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Respuesta [mensaje=" + mensaje + ", code=" + code + "]";
	}
}
