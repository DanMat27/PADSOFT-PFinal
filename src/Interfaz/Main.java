package Interfaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import Excepciones.UsuarioInvalido;
import FechaSimulada.FechaSimulada;
import Sistema.Sistema;
import Usuarios.*;

public class Main {

	public static void main(String[] args) {
	    File fichero = new File("txt" + File.separator + "mdftunes.txt");
		
		Sistema sistema = new Sistema(5, 50, 100, 27, new Usuario("admin", "admin", 0), new Usuario("anonimo", "anonimo", 0));
		sistema.registrarse("miguel", "miguel", FechaSimulada.fijarFecha(27, 6, 1999), "miguel");
		ClasePrincipal ventana_menu = new ClasePrincipal ("MDFTUNES");
		
		try {
			if (fichero.length()!=0) {
				sistema.cargarDatos();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Controlador_Menu_Login controlador_menu_login = new Controlador_Menu_Login(ventana_menu, sistema);
		ventana_menu.setControladorMenuPrincipal(controlador_menu_login);
		
	}
	
}
