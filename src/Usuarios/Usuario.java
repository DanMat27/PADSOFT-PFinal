package Usuarios;
 
import java.io.Serializable;

/**
 * Usuario.java
 * Clase correspondiente a un usuario.
 * @author Daniel Mateo
 * @author Franccy del Piero Sambrano
 * @author Miguel Manzano
 */

import java.util.ArrayList;
 
@SuppressWarnings("serial")
public class Usuario implements Serializable{
    private String nombre;
    private String contrasenia;
    private int repTotalesExternas;
    private ArrayList<Notificaciones> notificaciones;
 
    /**
    * Metodo constructor de un Usuario.
    * @param nombre Nombre del usuario.
    * @param contrasenia Contrasenia del usuario.
    * @param repTotalesExternas Reproducciones totales realizadas por el usuario.
    */
    public Usuario(String nombre, String contrasenia, int repTotalesExternas) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.repTotalesExternas = repTotalesExternas;
        this.notificaciones = new ArrayList<>();
    }
     
    /**
     * Obtenemos el nombre del usuario
     * @return nombre nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }
     
    /**
     * Obtenemos la contraseña del usuario
     * @return contraseña contraseña del usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }
 
    /**
     * Obtenemos las reproducciones totales mensuales de un usuario.
     * @return repTotalesExternas 
     */
    public int getRepTotalesExternas() {
        return repTotalesExternas;
    }
    
    /**
     * Obtenemos la lista de notificaciones de un usuario.
     * @return notificaciones Lista de notificaciones.
     */
    public ArrayList<Notificaciones> getNotificaciones() {
        return notificaciones;
    }
	
	/**
	 * Modifica las reproducciones totales realizadas por un usuario.
	 * @param repTotalesExternas Nuevas reproducciones totales.
	 */
	public void modificarRepTotalesExternas(int repTotalesExternas) {
		this.repTotalesExternas = repTotalesExternas;
	}

	/**
	 * Devuelve la informacion de un usuario.
	 * @return informacion Info de un usuario.
	 */
	@Override
	public String toString() {
		return "[ Usuario =" + nombre + ", contrasenia =" + contrasenia + ", repTotalesExternas="
				+ repTotalesExternas + " notificaciones=" + notificaciones + " ]";
	}
	
}
