package Testers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import Excepciones.UsuarioInvalido;
import FechaSimulada.FechaSimulada;
import Musica.*;
import Sistema.*;
import Usuarios.*;
import pads.musicPlayer.exceptions.Mp3PlayerException;

public class TesterSerializable {

	public static void main(String[] args) {
		 LocalDate fecha1 = FechaSimulada.fijarFecha(27, 6, 1999);
	     Usuario anonimo = new Usuario("anonimo", "anonimo", 0);
	     Usuario administrador = new Usuario("admin", "admin", 0);
	     
	     File fichero = new File("txt" + File.separator + "mdftunes.txt"); 
	     
	     Sistema s = new Sistema(5, 50, 100, 27, administrador, anonimo);
	     System.out.println("Sistema inical: " + s);
	     
	     
	     /* Si el fichero contiene datos anteriores, los carga en el sistema 
	      * Si no, modifica los valores del sitema, registra un usuario y aniade dos canciones */
	     if(fichero.length()!=0) {
	    	 /* * * * * * * * * * CARGAMOS DATOS * * * * * * * * * * */
	    	 try {
				s.cargarDatos();
			    System.out.println("Sistema tras cargar datos: " + s); 
			    
			    Cancion c1 = new Cancion(0,"chicle3", 01, EstadosCancion.VALIDADA, "chicle3.mp3", new Autor("Franccy", "SambranoGonz", 0, fecha1, "Franccy", false));
			    Cancion c2 = new Cancion(0,"hive", 01, EstadosCancion.VALIDADA, "hive.mp3", new Autor("Franccy", "SambranoGonz", 0, fecha1, "Loco", false));
			    Cancion c3 = new Cancion(0,"pirates", 01, EstadosCancion.VALIDADA, "pirates.mp3", new Autor("Franccy", "SambranoGonz", 0, fecha1, "Pirata", false));
			    ArrayList<Cancion> listaCan = new ArrayList<Cancion>();
			    ArrayList<String> listaStr1;
			    ArrayList<String> listaStr2;
			    listaCan.add(c1);
			    listaCan.add(c2);
			    listaCan.add(c3);
			    System.out.println(listaCan);
			    //listaStr1 = s.ListaCancionesAStringNombre(listaCan);
			    //listaStr2 = s.ListaCancionesAStringAutor(listaCan);
			   // System.out.println(listaStr1);
			   // System.out.println(listaStr2);

			    
			 } catch (FileNotFoundException e) {
			    System.out.println("Archivo no encontrado");
				e.printStackTrace();
			 } catch (ClassNotFoundException e) {
			    System.out.println("Clase no encontrada para instanciar");
				e.printStackTrace();
			 } catch (IOException e) {
			    System.out.println("Error de lectura");
				e.printStackTrace();
			 } catch (Mp3PlayerException e) {
				    System.out.println("Error de MP3");
					e.printStackTrace();
			 }
	    	 /* * * * * * * * * * * * * * * * * * * * * * * * * * * */
	     }
	     else {
	    	 /* * * * * * * * * * MODIFICAMOS DATOS * * * * * * * * * * */
	    	 s.accederAdministrador("admin");
	    	 try {
				s.cambiarConfiguracion(0, 0, 0, 0);
		    	s.salirAdministrador();
			 } catch (UsuarioInvalido e) {
				e.printStackTrace();
			 }
	    	 
	    	 s.registrarse("Mateo", "272727", fecha1, "ElOtaku27");
	    	 try {
				s.login("ElOtaku27", "272727");
			 } catch (UsuarioInvalido e) {
				e.printStackTrace();
			 }
	    	
			 try {
				s.subirCancion("hawaii", "Hawaii.mp3");
				s.subirCancion("chicle", "chicle3.mp3");
				s.crearAlbum("miguel");
				s.logout();
			 } catch (FileNotFoundException e) {
				e.printStackTrace();
			 } catch (Mp3PlayerException e) {
				e.printStackTrace();
			 } catch (UsuarioInvalido e) {
				e.printStackTrace();
			 }
			
		     System.out.println("Sistema despues de aniadir y modificar datos: " + s);
	    	 /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	     }
	    

	     /* Guardamos los datos del sistema en el fichero */
	     System.out.println("Tamanio del archivo mdftunes.txt antes de guardar datos: " + fichero.length());
    	 /* * * * * * * * * * * GUARDAMOS DATOS * * * * * * * * * * * * */
	     try {
			s.guardarDatos();
		 } catch (FileNotFoundException e) {
		     System.out.println("Archivo no encontrado");
			e.printStackTrace();
		 } catch (IOException e) {
		    System.out.println("Error de lectura");
			e.printStackTrace();
		 }
    	 /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	     
	     System.out.println("Tamanio del archivo mdftunes.txt tras guardar datos: " + fichero.length());
	}

}
