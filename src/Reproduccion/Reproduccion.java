package Reproduccion;

import java.io.Serializable;

/**
 * Reproduccion.java
 * Clase correspondiente a una reproduccion.
 * @author Daniel Mateo
 * @author Franccy del Piero Sambrano
 * @author Miguel Manzano
 */

import java.time.*;
import Musica.Cancion;
import Usuarios.*;

@SuppressWarnings("serial")
public class Reproduccion implements Serializable{
	private LocalDate fecha;
	private Usuario usuario;
	private Cancion cancion;
	private int id;
	
	/**
	 * Constructor del Conteo de Reproducciones
	 * @param fecha Fecha de la cancion
	 * @param usuario Usuario de la cancion
	 * @param cancion Cancion que se va a contar
	 * @param id Id de la cancion
	 */
	public Reproduccion(LocalDate fecha, Usuario usuario, Cancion cancion, int id) {
		this.fecha = fecha;
		this.usuario = usuario;
		this.cancion = cancion;
		this.id = id;
	}
	
	/**
	 * Devuelve la fecha en la que se reproduce la cancion
	 * @return LocalDate: fecha en la que se reproduce la cancion
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	
	/**
	 * Devuelve el autor de la cancion que se va a reproducir
	 * @return Autor: autor de la cancion
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * Devuelve la cancion que se va a reproducir
	 * @return Cancion: cancion que se va a reproducir
	 */
	public Cancion getCancion() {
		return cancion;
	}

	/**
	 * Devuelve el Id de la reproduccion.
	 * @return Id de la reproduccion.
	 */
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Reproduccion [fecha=" + fecha + ", usuario=" + usuario.getNombre() + ", cancion=" + cancion + ", id=" + id + "]";
	}
	
	
	
}
