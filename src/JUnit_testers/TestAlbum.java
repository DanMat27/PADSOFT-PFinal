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
import Usuarios.Autor;
import pads.musicPlayer.Mp3Player;
import pads.musicPlayer.exceptions.Mp3PlayerException;

public class TestAlbum {

	/**
	 * Comprueba si la cancion se ha anyadido correctamente
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testAñadirCancion() throws FileNotFoundException, Mp3PlayerException {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		 ArrayList<Cancion> array = new ArrayList<Cancion>();
		Album alb = new Album(0,"Pop",array,a, 0);
		Cancion c = new Cancion(0,"chicle3",a.getListacancion().size(),EstadosCancion.EN_ESPERA,"Canciones" + File.separator + "chicle3.mp3",a);
		c.modificarEstado(EstadosCancion.VALIDADA);
		assertTrue(alb.añadirCancion(c));
		
	}
	/**
	 * Comprueba si la cancion se ha borrado correctamente 
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testBorrarCancion() throws FileNotFoundException, Mp3PlayerException {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		Cancion c = new Cancion(0,"chicle3",a.getListacancion().size(),EstadosCancion.EN_ESPERA,"Canciones" + File.separator + "chicle3.mp3",a);
		 ArrayList<Cancion> array = new ArrayList<Cancion>();
		Album alb = new Album(0,"Pop",array,a, 0);
		c.modificarEstado(EstadosCancion.VALIDADA);
		alb.añadirCancion(c);
		assertTrue(alb.borrarCancion(c));
		

	}
	/**
	 * Comprueba si calcula bien la duracion
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testCalculaDuracion() throws FileNotFoundException, Mp3PlayerException {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		Cancion c = new Cancion(0,"chicle3",a.getListacancion().size(),EstadosCancion.EN_ESPERA,"Canciones" + File.separator + "chicle3.mp3",a);
		 ArrayList<Cancion> array = new ArrayList<Cancion>();
		Album alb = new Album(0,"Pop",array,a, 0);
		c.modificarEstado(EstadosCancion.VALIDADA);
		alb.añadirCancion(c);
		Mp3Player m = new Mp3Player();
		@SuppressWarnings("static-access")
		double auxtempo = m.getDuration("Canciones" + File.separator + "chicle3.mp3");
		double aux = alb.calculaDuracion();
		assertEquals(auxtempo,aux,0);
	}

	/**
	 * Comprueba si es un album
	 */
	@Test
	public void testIsAlbum()  {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		 ArrayList<Cancion> array = new ArrayList<Cancion>();
		Album alb = new Album(0,"Pop",array,a, 0);
		assertTrue(alb.isAlbum());
		
	}
}
