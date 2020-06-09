package JUnit_testers;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import FechaSimulada.FechaSimulada;
import Musica.Album;
import Musica.Cancion;
import Musica.EstadosCancion;
import Musica.ListaReproduccion;
import Usuarios.Autor;
import pads.musicPlayer.Mp3Player;
import pads.musicPlayer.exceptions.Mp3PlayerException;

public class TestListaReproduccion {
	/**
	 * Comprueba si la cancion se ha anyadido correctamente la lista
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testAñadirCancion() throws FileNotFoundException, Mp3PlayerException {
		 ArrayList<Cancion> array = new ArrayList<Cancion>();
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		ListaReproduccion lista  = new ListaReproduccion(0.0,"Lista_Cumbia",array,a, 0);
		Cancion c = new Cancion(0,"chicle3",a.getListacancion().size(),EstadosCancion.EN_ESPERA,"Canciones" + File.separator + "chicle3.mp3",a);
		c.modificarEstado(EstadosCancion.VALIDADA);
		assertTrue(lista.añadirCancion(c));
		
	}
	/**
	 * Comprueba si la cancion se borro correctamente de la lista
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testBorrarCancion() throws FileNotFoundException, Mp3PlayerException {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		Cancion c = new Cancion(0,"chicle3",a.getListacancion().size(),EstadosCancion.EN_ESPERA,"Canciones" + File.separator + "chicle3.mp3",a);
		 ArrayList<Cancion> array = new ArrayList<Cancion>();
			ListaReproduccion lista  = new ListaReproduccion(0.0,"Lista_Cumbia",array,a, 0);
		c.modificarEstado(EstadosCancion.VALIDADA);
		lista.añadirCancion(c);
		assertTrue(lista.borrarCancion(c));
		
	}
	/**
	 * Comprueba si se aniadio correctamente una lista a una lista
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testañadirLista() throws FileNotFoundException, Mp3PlayerException {
		 ArrayList<Cancion> array = new ArrayList<Cancion>();
			Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
			ListaReproduccion lista  = new ListaReproduccion(0.0,"Lista_Cumbia",array,a, 0);
			Autor b = new Autor("Daniel","EPS", 0,FechaSimulada.fijarFecha(8, 2, 1998),"Mate0",false);
			 ArrayList<Cancion> array1 = new ArrayList<Cancion>();
				ListaReproduccion lista1  = new ListaReproduccion(0.0,"Lista_Salsa",array1,b, 1);
				assertTrue(lista.añadirLista(lista1));
		
	}
	/**
	 * Comprueba si la lista se borro corectamente del conjunto de listas
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testborrarLista() throws FileNotFoundException, Mp3PlayerException {
		 ArrayList<Cancion> array = new ArrayList<Cancion>();
			Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
			ListaReproduccion lista  = new ListaReproduccion(0.0,"Lista_Cumbia",array,a, 0);
			Autor b = new Autor("Daniel","EPS", 0,FechaSimulada.fijarFecha(8, 2, 1998),"Mate0",false);
			 ArrayList<Cancion> array1 = new ArrayList<Cancion>();
				ListaReproduccion lista1  = new ListaReproduccion(0.0,"Lista_Salsa",array1,b, 1);
				lista.añadirLista(lista1);
				assertTrue(lista.borrarLista(lista1));
	}
	/**
	 * Comprueba si el album se aniadio correctamente a la lista de reproduccion
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testañadirAlbum() throws FileNotFoundException, Mp3PlayerException {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		Autor b = new Autor("Daniel","EPS", 0,FechaSimulada.fijarFecha(8, 2, 1998),"Mate0",false);
		 ArrayList<Cancion> array = new ArrayList<Cancion>();
		Album alb = new Album(0,"Pop",array,a, 0);
		ListaReproduccion lista  = new ListaReproduccion(0.0,"Lista_Cumbia",array,b, 1);
		assertTrue(lista.añadirAlbum(alb));
		
	}
	/**
	 * Comprueba si se borro correctamente un album de la lista de la reproduccion
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testborrarAlbum() throws FileNotFoundException, Mp3PlayerException {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		Autor b = new Autor("Daniel","EPS", 0,FechaSimulada.fijarFecha(8, 2, 1998),"Mate0",false);
		 ArrayList<Cancion> array = new ArrayList<Cancion>();
		Album alb = new Album(0,"Pop",array,a, 0);
		ListaReproduccion lista  = new ListaReproduccion(0.0,"Lista_Cumbia",array,b, 1);
		lista.añadirAlbum(alb);
		assertTrue(lista.borrarAlbum(alb));
	}
	/**
	 * Comprueba si la duracion del te
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testCalculaDuracion() throws FileNotFoundException, Mp3PlayerException {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		Cancion c = new Cancion(0,"chicle3",a.getListacancion().size(),EstadosCancion.EN_ESPERA,"Canciones" + File.separator + "chicle3.mp3",a);
		ArrayList<Cancion> array = new ArrayList<Cancion>();
		ListaReproduccion lista  = new ListaReproduccion(0.0,"Lista_Cumbia",array,a, 0);
		c.modificarEstado(EstadosCancion.VALIDADA);
		lista.añadirCancion(c);
		Mp3Player m = new Mp3Player();
		@SuppressWarnings("static-access")
		double auxtempo = m.getDuration("Canciones" + File.separator + "chicle3.mp3");
		double aux = lista.calculaDuracion();
		assertEquals(auxtempo,aux,0);
	}
	/**
	 * Comprueba si la lista es una lista de reproduccion
	 */
	@Test
	public void testisLista() {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		ArrayList<Cancion> array = new ArrayList<Cancion>();
		ListaReproduccion lista  = new ListaReproduccion(0.0,"Lista_Cumbia",array,a, 0);
		assertTrue(lista.isLista());
	}
	
}
