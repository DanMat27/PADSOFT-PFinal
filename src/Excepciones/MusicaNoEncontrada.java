package Excepciones;

/**
 * MusicaNoEncontrada.java
 * Clase correspondiente a la excepcion cuando se realiza una busqueda y no se encuentra nada.
 * @author Daniel Mateo
 * @author Franccy del Piero Sambrano
 * @author Miguel Manzano
 */

public class MusicaNoEncontrada extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepcion MusicaNoEncontrada.
	 */
	public MusicaNoEncontrada() {
		
	}

	/**
	 * Metodo toString que muestra la informacion de error de la excepcion.
	 */
	@Override
	public String toString() {
		return "NO HAN HABIDO RESULTADOS EN LA BUSQUEDA.";
	}
}
