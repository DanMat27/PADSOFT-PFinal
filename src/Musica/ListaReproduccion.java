package Musica;
 
/**
 * ListaReproduccion.java
 * Clase correspondiente a una lista de tipo lista de reproduccion.
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
public class ListaReproduccion extends Listas implements Serializable{
     
    private List<Listas> listaListas;
     
    /**
     * Constructor de una lista de reproduccion.
     * @param duracion Duracion de la lista de reproduccion.
     * @param name Nombre de la lista de reproduccion.
     * @param listaCanciones Lista de canciones de la lista de reproduccion.
     * @param autor Autor de la lista de reproduccion.
     */
    public ListaReproduccion(double duracion, String name, List<Cancion> listaCanciones, Autor autor, int id) {
        super(duracion, name, listaCanciones, autor, id);
        listaListas = new ArrayList<Listas>();
    }
     
    /**
     * Aniade una lista de reproduccion a otra lista de reproduccion.
     * @param lista Lista de reproduccion para añadir.
     * @return true si se añadio, false si no.
     * @throws Mp3PlayerException 
     * @throws FileNotFoundException 
     */
    public Boolean añadirLista(ListaReproduccion lista) throws FileNotFoundException, Mp3PlayerException {
        double duracion, nuevaduracion;
         
        if(listaListas.contains(lista)) {
            return false;
        }
        else {
            duracion = this.getDuracionLista();
            listaListas.add(lista);
            nuevaduracion = duracion + lista.calculaDuracion();
            this.setDuracion(nuevaduracion);
            return true;
        }
    }
         
     
    /**
     * Borra una lista de reproduccion de otra lista de reproduccion.
     * @param lista Lista de reproduccion para borrar.
     * @return true si se borro, false si no.
     */
    public Boolean borrarLista(ListaReproduccion lista) {
        if(!listaListas.contains(lista)) {
            return false;
        }
        else {
            listaListas.remove(lista);
            return true;
        }
     
    }
     
    /**
     * Aniade un album a una lista de reproduccion.
     * @param album Album para añadir.
     * @return true si se añadio, false si no.
     * @throws Mp3PlayerException 
     * @throws FileNotFoundException 
     */
    public Boolean añadirAlbum(Album album) throws FileNotFoundException, Mp3PlayerException {
        double duracion, nuevaduracion;
         
        if(listaListas.contains(album)) {
            return false;
        }
        else {
            duracion = this.getDuracionLista();
            listaListas.add(album);
            nuevaduracion = duracion + album.calculaDuracion();
            this.setDuracion(nuevaduracion);
            return true;
        }
    }
     
    /**
     * Borra un album de una lista de reproduccion
     * @param album Album para borrar
     * @return true si se añadio, false si no
     */
    public Boolean borrarAlbum(Album album) {
        if(!listaListas.contains(album)) {
            return false;
        }
        else {
            listaListas.remove(album);
            return true;
        }
    }
     
    /**
     * Aniade una cancion a una lista de reproduccion.
     * @param cancion Cancion para aniadir.
     * @return true si se anadio con exito, false si no.
     * @throws Mp3PlayerException 
     * @throws FileNotFoundException 
     */
    @Override
    public Boolean añadirCancion(Cancion cancion) throws FileNotFoundException, Mp3PlayerException {
        double nuevaduracion;
         
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
     * Borra una cancion de una lista de reproduccion.
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
     * Calcula la duracion total de la lista de reproduccion.
     * @return total Total de reproducciones de la lista.
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
         
        for(Listas l: listaListas) {
            for(Cancion c: l.getListaCanciones()) {
                aux = player.getDuration(c.getMP3());
                total = total + aux;
            }
         
        }
        return total;
    }
 
	/**
	 * Indica si la lista es una lista de reproduccion.
	 * @return true si es una lista, false si no.
	 */
    @Override
	public Boolean isLista() {
		return true;
	}
     
	/**
	 * Devuelve la informacion correspondiente a una lista de reproduccion.
	 * @return informacion Info de una lista de reproduccion.
	 */
    public String toString() {
        return "ListaReproduccion: " + this.getNameLista() + this.getDuracionLista() + this.getListaCanciones() + listaListas;
    }
     
}    
