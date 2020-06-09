package Excepciones;

import Usuarios.*;

/**
 * UsuarioInvalido.java
 * Clase correspondiente a la excepcion cuando se intenta realizar una accion siendo un usuario no valido.
 * @author Daniel Mateo
 * @author Franccy del Piero Sambrano
 * @author Miguel Manzano
 */

public class UsuarioInvalido extends Exception{
	private static final long serialVersionUID = 1L;
	Usuario usuario;
	
	/**
	 * Constructor de la excepcion UsuarioInvalido.
	 * @param usuario Usuario no valido.
	 */
	public UsuarioInvalido(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo toString que muestra la informacion de error de la excepcion.
	 */
	@Override
	public String toString() {
		return "ERROR. USUARIO INVALIDO: " + this.usuario.getNombre() + ".";
	}
}
