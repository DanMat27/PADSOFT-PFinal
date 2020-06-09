package Usuarios;

import java.io.Serializable;

/**
 * Notificaciones.java
 * Clase correspondiente a una notificacion.
 * @author Daniel Mateo
 * @author Franccy del Piero Sambrano
 * @author Miguel Manzano
 */
 
@SuppressWarnings("serial")
public class Notificaciones implements Serializable{
	private String mensaje;
	private Usuario usuario;
	private int id;
	 
	/**
	 * Constructor de una notificacion.
	 * @param mensaje Texto de la notificacion.
	 * @param usuario Usuario que envia la notificacion.
	 * @param id Id de la notificacion.
	 */
	public Notificaciones(String mensaje,Usuario usuario, int id) {
	    this.mensaje = mensaje;
	    this.usuario = usuario;
	    this.id = id;
	}
	 
	/**
	 * Devuelve el texto de la notificacion.
	 * @return mensaje Texto.
	 */
	public String getMensaje() {
	    return mensaje;
	}
	 
	/**
	 * Devuelve el usuario de la notificacion.
	 * @return usuario Usuario.
	 */
	public Usuario getUsuario() {
	    return usuario;
	}
	 
	/**
	 * Devuelve el id de la notificacion.
	 * @return id Identificador.
	 */
	public int getId() {
	    return id;
	}
	 
	/**
	 * Modifica el texto de la notificacion.
	 * @param mensaje Texto para cambiar.
	 */
	public void setMensaje(String mensaje) {
	    this.mensaje = mensaje;
	}
	 
	/**
	* Devuelve la informacion correspondiente a una notificacion.
	* @return informacion Info de una notificacion.
	*/
	@Override
	public String toString() {
	    return id + ": [ "+ mensaje + " ] Remitente: "+ usuario.getNombre();
	}
	  
}
