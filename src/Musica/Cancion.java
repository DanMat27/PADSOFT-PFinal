package Musica;

/**
 * Cancion.java
 * Clase correspondiente a una cancion.
 * @author Daniel Mateo
 * @author Franccy del Piero Sambrano
 * @author Miguel Manzano
 */

import Usuarios.*;
import pads.musicPlayer.exceptions.Mp3PlayerException;
import Reproduccion.*;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@SuppressWarnings("serial")
public class Cancion implements Serializable{
	
	private int Id;
	private int NReproducciones;
	private EstadosCancion estado;
	private double duracion; 
	private String name;
	private String MP3;
	private Autor autor;
	private List<Reproduccion> listaReproducciones;
	private LocalDate fechaNV;
	
	/**
	 * Constructor de un objeto de tipo Cancion
	 * @param duracion: Duracion en mm:ss de la Cancion
	 * @param name: Nombre de la Cancion
	 * @param id: id de la Cancion
	 * @param est: Estado de la cancion
	 * @param mp3 Path del fichero mp3
	 * @param autor Autor de la cancion
	 * @throws FileNotFoundException 
	 * @throws Mp3PlayerException 
	 */
	public Cancion(double duracion, String name, int id, EstadosCancion est, String mp3, Autor autor) throws FileNotFoundException, Mp3PlayerException {
		this.duracion = duracion;
		this.name = name;
		this.Id = id;
		this.NReproducciones = 0;
		this.estado = est;
		this.MP3 = mp3;
		this.autor = autor;
		this.listaReproducciones = new ArrayList<Reproduccion>();
		this.fechaNV = null;
	}
	
	/**
	 * Devuelve la duracion de la cancion
	 * @return double: duracion de la cancion
	 */
	public double getDuracion() {
		return duracion;
	}
	
	/**
	 * Devuelve el nombre de la cancion
	 * @return String: nombre de la cancion
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Devuelve la id de la Cancion
	 * @return Id: id de la cancion
	 */
	public int getCancionId() {
		return Id;
	}
	
	/**
	 * Devuelve el numero de reproducciones de la Cancion
	 * @return NReproducciones: numero de reproducciones de la cancion
	 */
	public int getNReproducciones() {
		return NReproducciones;
	}
	
	/**
	 * Devuelve el estado de la Cancion
	 * @return estado: Estado actual de la Cancion
	 */
	public EstadosCancion getEstado() {
		return estado;
	}
	
	/**
	 * Devuelve el nombre del archivo mp3
	 * @return string: nombre archivo mp3;
	 */
	public String getMP3() {
		return MP3;
	}
	
	/**
	 * Devuelve el id de la cancion.
	 * @return Id Id de la cancion.
	 */
	public int getId() {
		return Id;
	}
	
	/**
	 * Devuelve el autor de la cancion.
	 * @return autor Autor.
	 */
	public Autor getAutor() {
		return autor;
	}

	/**
	 * Devuelve la lista de reproducciones de una cancion.
	 * @return listaReproducciones Lista de reproducciones
	 */
	public List<Reproduccion> getListaReproducciones() {
		return listaReproducciones;
	}
	
	/**
	 * Devuelve la fecha de no validacion de una cancion.
	 * @return fechaNV Fecha.
	 */
	public LocalDate getFechaNV() {
		return fechaNV;
	}

	/**
	 * Modifica el estado de la Cancion
	 * @param estado: Nuevo estado que se asignara a Cancion
	 */
	public void modificarEstado(EstadosCancion estado) {
		this.estado = estado;
	}
	
	/**
	 * Modifica la fecha cuando no se valida la Cancion.
	 * @param fechaNV Nueva fecha.
	 */
	public void modificarFechaNV(LocalDate fechaNV) {
		this.fechaNV = fechaNV;
	}

	/**
	 * Modifica el numero de reproducciones de una cancion.
	 * @param NReproducciones Nuevo numero de reproducciones.
	 */
	public void modificarNReproducciones(int NReproducciones) {
		this.NReproducciones = NReproducciones;
	}
	
	/**
	 * Devuelve la informacion correspondiente a una cancion.
	 * @return informacion Info de una cancion.
	 */
	public String toString() {
	    return getName() + "[ Autor: " + getAutor().getNickname() + ", Path: " + MP3 + ", duracion:" + getDuracion() + ", con id: " + getCancionId() + ", Numero de Reproducciones: " + getNReproducciones() + " y en estado: " + getEstado() + "]" ; 
	}
}