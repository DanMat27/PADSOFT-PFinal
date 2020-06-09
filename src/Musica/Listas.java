package Musica;

/**
 * Listas.java
 * Clase abstracta correspondiente a una lista que engloba albumes y listas de reproduccion.
 * @author Daniel Mateo
 * @author Franccy del Piero Sambrano
 * @author Miguel Manzano
 */

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;

import Usuarios.Autor;
import pads.musicPlayer.exceptions.Mp3PlayerException;

@SuppressWarnings("serial")
public abstract class Listas implements Serializable{
	private double duracion;
	private String name;
	private List<Cancion> listaCanciones;
	private Autor autor;
	private int id;
	
	/**
	 * Constructor de un objeto de tipo Lista 
	 * @param duracion Duracion de la lista
	 * @param name Nombre de la lista
	 * @param listaCanciones Lista de canciones de la lista
	 * @param autor Autor de la lista
	 */
	public Listas(double duracion, String name, List<Cancion> listaCanciones, Autor autor, int id) {
		this.duracion = duracion;
		this.name = name;
		this.listaCanciones = listaCanciones;
		this.autor = autor;
		this.id = id;
	}

	/**
	 * Devuelve la duracion total de la lista.
	 * @return duracion Duracion de la lista.
	 */
	public double getDuracionLista() {
		return duracion;
	}

	/**
	 * Modifica la duracion total de la lista.
	 * @param duracion Duracion para cambiar.
	 */
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	/**
	 * Devuelve el nombre de la lista.
	 * @return name Nombre de la lista.
	 */
	public String getNameLista() {
		return name;
	}
	
	/**
	 * Devuelve la lista de canciones de la lista.
	 * @return listaCanciones Lista de canciones.
	 */
	public List<Cancion> getListaCanciones() {
		return listaCanciones;
	}
	
	/**
	 * Devuelve el autor de la lista.
	 * @return autor Autor.
	 */
	public Autor getAutor() {
		return autor;
	}

	/**
	 * Devuelve el id de la lista.
	 * @return id Id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Añade una cancion a una lista.
	 * @param cancion Cancion para añadir. 
	 * @return true si se añadio, false si no.
	 * @throws Mp3PlayerException 
     * @throws FileNotFoundException 
	 */
	public Boolean añadirCancion(Cancion cancion) throws FileNotFoundException, Mp3PlayerException {
		return true;
	}
	
	/**
	 * Borra una cancion indicada de una lista.
	 * @param cancion Cancion para borrar. 
	 * @return true si se borro, false si no.
	 */
	public Boolean borrarCancion(Cancion cancion) {
		return true;
	}
	
	/**
	 * Calcula la duracion total de una lista.
	 * @return duracion Duracion de la lista.
	 * @throws Mp3PlayerException 
     * @throws FileNotFoundException 
	 */
	public double calculaDuracion() throws FileNotFoundException, Mp3PlayerException {
		return 0;
	}
	
	/**
	 * Indica si la lista es un album.
	 * @return true si es un album, false si no.
	 */
	public Boolean isAlbum() {
		return false;
	}
	
	/**
	 * Indica si la lista es una lista de reproduccion.
	 * @return true si es una lista, false si no.
	 */
	public Boolean isLista() {
		return false;
	}
}
