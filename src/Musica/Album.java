package Musica;
 
/**
 * Album.java
 * Clase correspondiente a una lista de tipo album.
 * @author Daniel Mateo
 * @author Franccy del Piero Sambrano
 * @author Miguel Manzano
 */ 

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;

import Usuarios.Autor;
import pads.musicPlayer.Mp3Player;
import pads.musicPlayer.exceptions.Mp3PlayerException;
 
@SuppressWarnings("serial")
public class Album extends Listas implements Serializable{
    /**
     * Constructor de un album
     * @param duracion Duracion total del album
     * @param name Nombre del album
     * @param listaCanciones Lista de Canciones del album
     * @param autor Autor del album
     */
    public Album(double duracion, String name, List<Cancion> listaCanciones, Autor autor, int id) {
        super(duracion, name, listaCanciones, autor, id);
    }
     
    /**
     * Aniade una cancion a un album.
     * @param cancion Cancion para aniadir.
     * @return true si se anadio, false si no.
     * @throws Mp3PlayerException 
     * @throws FileNotFoundException 
     */
    @Override
    public Boolean añadirCancion(Cancion cancion) throws FileNotFoundException, Mp3PlayerException {
         
        double nuevaduracion = 0;
         
        if(cancion.getEstado() != EstadosCancion.VALIDADA) {
            return false;
        }
         
        if(this.getListaCanciones().contains(cancion)){
            return false;
        }
        else {
            getListaCanciones().add(cancion);
            nuevaduracion = this.calculaDuracion();
             
            this.setDuracion(nuevaduracion);
            return true;
        }
    }
     
    /**
     * Borrar una cancion del album.
     * @param cancion Cancion para borrar.
     * @return true si se borro, false si no.
     */
    @Override
    public Boolean borrarCancion(Cancion cancion) {
        if(!this.getListaCanciones().contains(cancion)){
            return false;
        }
        else {
            getListaCanciones().remove(cancion);
            return true;
        }
    }
     
    /**
     * Calcula la duracion total del album.
     * @return total Total de reproducciones del album.
     * @throws Mp3PlayerException 
     * @throws FileNotFoundException 
     */
    @SuppressWarnings("static-access")
	@Override
    public double calculaDuracion() throws FileNotFoundException, Mp3PlayerException {
         
        Mp3Player player = new Mp3Player();
        double total = 0, aux=0;
         
        for(Cancion c: getListaCanciones()) {
            aux = player.getDuration(c.getMP3());
            total = total + aux;
        }
         
        return total;
    }
     
	/**
	 * Indica si la lista es un album.
	 * @return true si es un album, false si no.
	 */
    @Override
	public Boolean isAlbum() {
		return true;
	}
     
    public String toString() {
        return "Album: " + this.getNameLista() + this.getDuracionLista() + this.getListaCanciones();
    }
}