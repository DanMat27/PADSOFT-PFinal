package JUnit_testers;

import static org.junit.Assert.*;

import org.junit.Test;

import FechaSimulada.FechaSimulada;
import Usuarios.Autor;

public class TestAutor {
	/**
	 * Comprueba si el usuario es premium
	 */
	@Test
	public void testIsPremium() {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		assertFalse(a.isPremium());
	}

	/**
	 * Comprueba si el usuario esta bloqueado
	 */
	@Test
	public void testIsBloqueado() {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		a.setBloqueado(true);
		assertTrue(a.isBloqueado());
	}
	/**
	 * Comprueba si el usuario ha seguido al autor
	 */
	@Test
	public void testSeguirAutor() {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		Autor b = new Autor("Aitor","EPS", 0,FechaSimulada.fijarFecha(3, 1, 1998),"Aitor2",false);
		assertTrue(a.SeguirAutor(b));
	}
	
	/**
	 * Comprueba si el usuario ha dejado de seguir al autor
	 */
	@Test
	public void testDejarDeSeguirAutor() {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		Autor b = new Autor("Aitor","EPS", 0,FechaSimulada.fijarFecha(3, 1, 1998),"Aitor2",false);
		//assertFalse(a.DejarDeSeguirAutor(b));
		
		a.SeguirAutor(b);
		assertTrue(a.DejarDeSeguirAutor(b));
		
	}
	
	/**
	 * Comprueba si el usuario es mayor de edad
	 */
	@Test
	public void testMayorEdad() {
		Autor a = new Autor("Miguel","EPS", 0,FechaSimulada.fijarFecha(5, 1, 1998),"Maikel",false);
		FechaSimulada.restablecerHoyReal();
		assertTrue(a.mayorEdad(FechaSimulada.getHoy()));
		
	}
	
}
