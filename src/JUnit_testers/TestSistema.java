package JUnit_testers;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import FechaSimulada.FechaSimulada;
import Musica.Album;
import Musica.Cancion;
import Musica.EstadosCancion;
import Musica.ListaReproduccion;
import Sistema.Sistema;
import Usuarios.*;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import pads.musicPlayer.exceptions.Mp3PlayerException;

public class TestSistema {

	/**
	 * Funcion que prueba si el usuario anonimo accede correctamente al sistema
	 */
	@Test
	public void testAccederAnonimo() {
		Usuario usuarioconect = new Usuario("anonimo","anonimo",0);
		
		 Sistema s = new Sistema(0, 30, 15, 27,null,usuarioconect);
		 
		 assertTrue(s.accederAnonimo());
		 
	}
	/**
	 * Funcion que prueba si el usuario anonimo sale correctamente del sistema
	 */
	@Test
	public void testSalirAnonimo() {
		Usuario usuarioconect = new Usuario("anonimo","anonimo",0);
		
		 Sistema s = new Sistema(0, 30, 15, 27,null,usuarioconect);
		 
		s.accederAnonimo();
		assertTrue(s.salirAnonimo());
	}
	/**
	 * Funcion que prueba si el administrador entra al sistema
	 */
	@Test
	public void testAccederAdministrador() {
		Usuario usuarioconect = new Usuario("admin","admin",0);
		
		 Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		 
		 assertTrue(s.accederAdministrador(usuarioconect.getContrasenia()));
	}
	/**
	 *Funcion que prueba si el administrador sale correctamente del sistema
	 */
	@Test
	public void testSalirAdministrador() {
		Usuario usuarioconect = new Usuario("admin","admin",0);
		
		 Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		 
		 s.accederAdministrador(usuarioconect.getContrasenia());
		 
		 assertTrue(s.salirAdministrador());
	}
	/**
	 * Funcion que comprueba que el usuario registrado ha hecho login 
	 */
	@Test
	public void testLogin() {
		 LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		 Sistema s = new Sistema(0, 30, 15, 27,null,null);
		 s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		 
		 assertTrue(s.login(autor.getNickname(), autor.getContrasenia() ));
		 
	}
	/**
	 * Funcion que hace que el usuario cierre sesion
	 */
	@Test
	public void testLogout() {
		 LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
			Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
			 Sistema s = new Sistema(0, 30, 15, 27,null,null);
			 s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
			 
			 s.login(autor.getNickname(), autor.getContrasenia());
			 
			 assertTrue(s.logout());
	}
	/**
	 * Funcion que comprueba si el autor esta registrado
	 */
	@Test
	public void testRegistrarse() {
		 LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
			Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
			 Sistema s = new Sistema(0, 30, 15, 27,null,null);
			 assertTrue(s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname()));
			 
	}
	
	/**
	 * Funcion que sirve para desbloquear el usuario bloqueado anteriormente
	 */
	@Test
	public void testDesbloquearUsuario() {
			 LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
			 LocalDate fecha2 = FechaSimulada.fijarFecha(1, 2, 2019);
			Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
			Usuario usuarioconect = new Usuario("admin","admin",0);
			Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
			
			s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
			s.login(autor.getNickname(), autor.getContrasenia() );
			s.logout();
			s.accederAdministrador(usuarioconect.getContrasenia());
			s.bloquearUsuario(autor);
			autor.setFechaBloqueado(fecha2);
			assertTrue(s.desbloquearUsuario(autor));
	}
	/**
	 * Funcion que sirve para comprobar si se sube la cancion
	 * @throws Mp3PlayerException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSubirCancion() throws FileNotFoundException, Mp3PlayerException {
		 LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
	s.login(autor.getNickname(), autor.getContrasenia());
		assertTrue(s.subirCancion("Pop","chicle3.mp3"));
		
	}
	/**
	 * Funcion que sirve para comprobar si se crea una lista de reproduccion
	 */
	@Test
	public void testCrearListaRep() {
		LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Sistema s = new Sistema(0, 30, 15, 27,null,null);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		assertTrue(s.crearListaRep("Hoy"));
	}
	/**
	 * Funcion que comprueba si el album se creo correctamente
	 */
	@Test
	public void testCrearAlbum() {
		LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Sistema s = new Sistema(0, 30, 15, 27,null,null);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		assertTrue(s.crearAlbum("Ayer"));
	}
	/**
	 * Funcion que revisa si el administrados a la hora de revisar plagio lo hace correctamente
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testRevisarPlagio() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
	      Autor autor2 = new Autor("Mateo","MateoMor", 0, fecha1, "mateo", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion aux = null;
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"chicle3.mp3",autor);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.subirCancion(c.getName(),c.getMP3());
		s.logout();
		s.registrarse(autor2.getNombre(), autor2.getContrasenia(), autor2.getFechaDeNacimiento(), autor2.getNickname());
		s.login(autor2.getNickname(), autor2.getContrasenia());
		for(Cancion caux: s.getListaCanciones()) {
			if(caux.getName() == c.getName()) {
				aux = caux;
			}
			
		}
		s.reportarPlagio(aux,"Plagio a Disney");
		s.logout();
		
		s.accederAdministrador(usuarioconect.getContrasenia());
		assertTrue(s.revisarPlagio(aux, true, 0));
		
	}
	
	/**
	 * Funcion que bloquea el usuario siendo administrador
	 */
	@Test
	public void testBloquearUsuario() {
		 LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
			Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
			Usuario usuarioconect = new Usuario("admin","admin",0);
			Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
			
			s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
			s.login(autor.getNickname(), autor.getContrasenia() );
			s.logout();
			s.accederAdministrador(usuarioconect.getContrasenia());
			assertTrue(s.bloquearUsuario(autor));
			
	}
   /**
    * Funcion que cambia la configuracion, esta funcion la realiza el administrador
    */
	@Test
	public void testCambiarConfiguracion() {
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		s.accederAdministrador(usuarioconect.getContrasenia());
		assertTrue(s.cambiarConfiguracion(0, 1000, 50, 25));
	}
	/**
	 * Funcion que comprueba si el administrador bloquea la cancion correctamente
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testBloquearCancion() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"Canciones" + File.separator + "chicle3.mp3",autor);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.logout();
		
		s.accederAdministrador(usuarioconect.getContrasenia());
		assertTrue(s.bloquearCancion(c));
		
		
	}
	/**
	 * Funcion que comprueba si a un usuario se le ha vencido su supcripcion premium
	 * @throws InvalidCardNumberException
	 * @throws FailedInternetConnectionException
	 * @throws OrderRejectedException
	 */
	@Test
	public void testVencimientoPremium() throws InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Sistema s = new Sistema(0, 30, 15, 27,null,null);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.convertirsePremium("4913184279588768");
		LocalDate fecha2 = FechaSimulada.fijarFecha(1, 2, 2019);
		autor.setFechainicio(fecha2);
		
		for (Autor aux: s.getListaUsuarios()) {
			if(autor.getNombre() == aux.getNombre()) {
				aux.setFechainicio(fecha2);
			}
			
		}
		
		assertTrue(s.vencimientoPremium());
	}
	/**
	 * Funcion que comprueba si un administrador que quiere cambiar una cancion a explicito lo hace correctamente
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testComprobarExplicito() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"chicle3.mp3",autor);
		Cancion aux = null;
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.subirCancion(c.getName(),c.getMP3());
		s.logout();
		s.accederAdministrador(usuarioconect.getContrasenia());
		for (Cancion caux: s.getListaCanciones()) {
			if(c.getName() == caux.getName()) {
				aux = caux;
			}
			
		}

		assertTrue(s.comprobarExplicito(aux));
		
	}
	
	/**
	 * Funcion que comprueba si el usuario registrado se desvincula de la aplicacion correctamente 
	 */
	@Test
	public void testCancelarRegistro() {
		LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		assertTrue(s.cancelarRegistro());
		
	}
	/**
	 * Funcion que se encarga de ver si se reporta plagio
	 * @throws Mp3PlayerException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testReportarPlagio() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"chicle3.mp3",autor);
		Cancion aux = null;
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.subirCancion(c.getName(),c.getMP3());
		for (Cancion caux: s.getListaCanciones()) {
			if(c.getName() == caux.getName()) {
				aux = caux;
			}
			
		}
		assertTrue(s.reportarPlagio(aux,"Su cancion tiene plagio"));
		
	}
	/**
	 * Funcion que verifica si la cancion se ha modificado correctamente
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testModificarCancion() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		LocalDate fecha2 = FechaSimulada.fijarFecha(30, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.NO_VALIDADA,"chicle3.mp3",autor);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		c.modificarFechaNV(fecha2);
		assertTrue(s.modificarCancion(c, autor));
		
	}
	
	
	/**
	 * Funcion que comprueba si el usuario se convierte correctamente a premium
	 * @throws InvalidCardNumberException
	 * @throws FailedInternetConnectionException
	 * @throws OrderRejectedException
	 */
	@Test
	public void testConvertirsePremium() throws InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Sistema s = new Sistema(0, 30, 15, 27,null,null);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		assertTrue(s.convertirsePremium("4913184279588768"));
	}
	/**
	 * Funcion para reproducir la cancion esperada
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testReproducirCancion() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.VALIDADA,"Canciones" + File.separator + "chicle3.mp3",autor);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		assertNotNull(s.reproducirCancion(c));
		
	}
	/**
	 * Funcion que busca canciones por el nombre del autor
	 * 	@throws Mp3PlayerException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testBuscarCancionesNombre() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"chicle3.mp3",autor);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.subirCancion(c.getName(),c.getMP3());
		assertNotNull(s.buscarCancionesNombre(c.getName()));
	}
	
	/**
	 * Funcion que busca canciones por autor
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testBuscarCancionesAutor() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"chicle3.mp3",autor);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.subirCancion(c.getName(),c.getMP3());
		assertNotNull(s.buscarAlbumesAutor(autor.getNombre()));
	}
	/**
	 * Funcion que busca canciones con el filtro de tus propias canciones
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testBuscarCancionesMisCanciones() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"chicle3.mp3",autor);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.subirCancion(c.getName(),c.getMP3());
		assertNotNull(s.buscarCancionesMisCanciones(c.getName()));
	}
	/**
	 * Funcion que busca canciones por el nombre del album
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testBuscarAlbumesNombre() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"chicle3.mp3",autor);
		ArrayList<Cancion> listacanciones = new ArrayList<Cancion>();
		Album a  = new Album(0,"Cumbia",listacanciones, autor, 0);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.subirCancion(c.getName(),c.getMP3());
		a.añadirCancion(c);
		assertNotNull(s.buscarAlbumesNombre(a.getNameLista()));	
	}
	/**
	 * Funcion que busca el nombre del autor en el album
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testBuscarAlbumesAutor() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"chicle3.mp3",autor);
		ArrayList<Cancion> listacanciones = new ArrayList<Cancion>();
		Album a  = new Album(0,"Cumbia",listacanciones, autor, 0);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.subirCancion(c.getName(),c.getMP3());
		a.añadirCancion(c);
		assertNotNull(s.buscarAlbumesNombre(a.getAutor().getNombre()));	
	}
	/**
	 * Funcion que busca un album entre tus albumes
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testBuscarAlbumesMisAlbumes() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"chicle3.mp3",autor);
		ArrayList<Cancion> listacanciones = new ArrayList<Cancion>();
		Album a  = new Album(0,"Cumbia",listacanciones, autor, 0);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.subirCancion(c.getName(),c.getMP3());
		a.añadirCancion(c);
		assertNotNull(s.buscarAlbumesMisAlbumes(a.getAutor().getNombre()));
	}
	/**
	 * Funcion que comprueba que busca listas dentro de una lista de reproduccion
	 * @throws FileNotFoundException
	 * @throws Mp3PlayerException
	 */
	@Test
	public void testBuscarListasRepMisListasRep() throws FileNotFoundException, Mp3PlayerException {
		LocalDate fecha1 = FechaSimulada.fijarFecha(2, 3, 2019);
		Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
		Usuario usuarioconect = new Usuario("admin","admin",0);
		Sistema s = new Sistema(0, 30, 15, 27,usuarioconect,null);
		Cancion c = new Cancion(0,"chicle3",autor.getListacancion().size(),EstadosCancion.EN_ESPERA,"chicle3.mp3",autor);
		ArrayList<Cancion> listacanciones = new ArrayList<Cancion>();
		ListaReproduccion l = new ListaReproduccion(0,"Pop", listacanciones, autor, 0);
		s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname());
		s.login(autor.getNickname(), autor.getContrasenia());
		s.subirCancion(c.getName(),c.getMP3());
		l.añadirCancion(c);
		assertNotNull(s.buscarListasRepMisListasRep(l.getAutor().getNombre()));
	}

	

}
