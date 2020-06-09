package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Musica.Album;
import Musica.Cancion;
import Musica.Listas;
import Sistema.Sistema;
import Usuarios.Autor;

public class Controlador_Bienvenido implements ActionListener, WindowListener {
	private Inicio vista;
	private Sistema sistema;
	
	
	public Controlador_Bienvenido (Inicio vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("CerrarSesion")) {
			boolean logout;
			logout = sistema.logout();
			if (logout) {
				ClasePrincipal ventana_menu = new ClasePrincipal ("MDFTUNES");
				ventana_menu.setVisible(true);
				this.vista.setVisible(false);
				Controlador_Menu_Login controlador_menu_login = new Controlador_Menu_Login(ventana_menu, sistema);
				ventana_menu.setControladorMenuPrincipal(controlador_menu_login);
			}
		}			
		else if(e.getActionCommand().equals("Prem")) {
			PasarelaPago pag = new PasarelaPago("Premium");
			
			pag.setVisible(true);
			vista.setVisible(false);
			ControladorPago control_pago = new ControladorPago(pag,sistema);
			control_pago.getVista().setControladorPasarela(control_pago);
		
		}
		else if(e.getActionCommand().equals("NOTIF")) {
			 Notif_pagina ventana_notif = new Notif_pagina ("Notificaciones", false, sistema.ListaNotificacionesAString(sistema.notificar()));
			 ventana_notif.setVisible(true);
			 this.vista.setVisible(false);
			 Controlador_Notificaciones controlador_notif = new Controlador_Notificaciones(ventana_notif, sistema);
			 ventana_notif.setControladorNotif(controlador_notif);
		}
		else if (e.getActionCommand().equals("BusquedaxAutor")) {
			ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
			if(sistema.getUsuarioConectado().getNombre().equals("admin")) {
				BuscarxAutor busca_autor = new BuscarxAutor("Buscar por autor",1,sistema.ListaCancionesAString(listaCanciones));
				busca_autor.setVisible(true);
				this.vista.setVisible(false);
				ControladorBusquedaxAutor control_autor = new ControladorBusquedaxAutor(busca_autor,sistema);
				busca_autor.setControladorBusquedaAutor(control_autor);
			}
			else if(sistema.getUsuarioConectado().getNombre().equals("anonimo")) {
				BuscarxAutor busca_autor = new BuscarxAutor("Buscar por autor",2,sistema.ListaCancionesAString(listaCanciones));
				busca_autor.setVisible(true);
				this.vista.setVisible(false);
				ControladorBusquedaxAutor control_autor = new ControladorBusquedaxAutor(busca_autor,sistema);
				busca_autor.setControladorBusquedaAutor(control_autor);
			}
			else {
				BuscarxAutor busca_autor = new BuscarxAutor("Buscar por autor",0,sistema.ListaCancionesAString(listaCanciones));
				busca_autor.setVisible(true);
				this.vista.setVisible(false);
				ControladorBusquedaxAutor control_autor = new ControladorBusquedaxAutor(busca_autor,sistema);
				busca_autor.setControladorBusquedaAutor(control_autor);
			}

		}
		else if (e.getActionCommand().equals("BusquedaxCancion")){
			ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
			if(sistema.getUsuarioConectado().getNombre().equals("admin")) {
				BuscarxCancion busca_cancion = new BuscarxCancion("Buscar por cancion",1,sistema.ListaCancionesAString(listaCanciones));
				busca_cancion.setVisible(true);
				this.vista.setVisible(false);
				ControladorBusquedaxCancion  control_cancion = new ControladorBusquedaxCancion(busca_cancion,sistema);
				busca_cancion.setControladorBusquedaCancion(control_cancion);
			}
			else if(sistema.getUsuarioConectado().getNombre().equals("anonimo")) {
				BuscarxCancion busca_cancion = new BuscarxCancion("Buscar por cancion",2,sistema.ListaCancionesAString(listaCanciones));
				busca_cancion.setVisible(true);
				this.vista.setVisible(false);
				ControladorBusquedaxCancion  control_cancion = new ControladorBusquedaxCancion(busca_cancion,sistema);
				busca_cancion.setControladorBusquedaCancion(control_cancion);
			}
			else {
				BuscarxCancion busca_cancion = new BuscarxCancion("Buscar por cancion",0,sistema.ListaCancionesAString(listaCanciones));
				busca_cancion.setVisible(true);
				this.vista.setVisible(false);
				ControladorBusquedaxCancion  control_cancion = new ControladorBusquedaxCancion(busca_cancion,sistema);
				busca_cancion.setControladorBusquedaCancion(control_cancion);
			}
		}
		else if (e.getActionCommand().equals("AutoresSeguidos")) {
			AutorSiguea autor = new AutorSiguea("Seguidores",false,sistema.ListaAutorAString((ArrayList<Autor>) sistema.seguidores()));
			autor.setVisible(true);
			this.vista.setVisible(false);
			Controlador_AutoresSeguidos control_autores = new Controlador_AutoresSeguidos(autor,sistema);
			autor.setControladorAutoresSeguidos(control_autores);
		}
		else if (e.getActionCommand().equals("album")) {
			AlbumCrear alb = new AlbumCrear("Crear_Album");
			alb.setVisible(true);
			this.vista.setVisible(false);
			ControladorCrearAlbum control_album = new ControladorCrearAlbum(alb,sistema);
			alb.setControladorAlbum(control_album);
				
		}
		else if (e.getActionCommand().equals("SUBIR")) {
			 Subida_pagina ventana_s = new Subida_pagina("Subida");
			 ventana_s.setVisible(true);
			 this.vista.setVisible(false);
			 Controlador_Subida controlador_s = new Controlador_Subida(ventana_s, sistema);
			 ventana_s.setControladorSubida(controlador_s);
		}
		else if (e.getActionCommand().equals("MisCanciones")) {
			 Autor aux = (Autor)sistema.getUsuarioConectado();
			 Canciones ventana_canciones = new Canciones("Canciones", sistema.ListaCanciones(aux.getListacancion()), aux.getRepTotalesExternas(), sistema.getTopeSerPremium());
			 ventana_canciones.setVisible(true);
			 this.vista.setVisible(false);
			 Controlador_MisCanciones controlador_MisC = new Controlador_MisCanciones(ventana_canciones, sistema);
			 ventana_canciones.setControladorCanciones(controlador_MisC);
		}
		else if (e.getActionCommand().equals("MisAlbumes")) {
			 Autor aux = (Autor)sistema.getUsuarioConectado();
			 ArrayList<Album> Lista = new ArrayList<Album>();
			 for(Listas a : aux.getListaListas()) {
				 if(a.isAlbum()) {
					 Lista.add((Album)a);
				 }
			 }
			 Albumes ventana_albumes = new Albumes("Albumes", sistema.ListaAlbumes(Lista));
			 ventana_albumes.setVisible(true);
			 this.vista.setVisible(false);
			 Controlador_MisAlbumes controlador_MisA = new Controlador_MisAlbumes(ventana_albumes, sistema);
			 ventana_albumes.setControladorAlbumes(controlador_MisA);
		}
		else if (e.getActionCommand().equals("MisListas")) {
			 Autor aux = (Autor)sistema.getUsuarioConectado();
			 ArrayList<Listas> Lista = new ArrayList<Listas>();
			 for(Listas a : aux.getListaListas()) {
				 if(a.isLista()) {
					 Lista.add(a);
				 }
			 }
			 MisListas ventana_listas = new MisListas("Listas", sistema.ListaListas(Lista));
			 ventana_listas.setVisible(true);
			 this.vista.setVisible(false);
			 Controlador_MisListas controlador_MisL = new Controlador_MisListas(ventana_listas, sistema);
			 ventana_listas.setControladorListas(controlador_MisL);
		}
		else {
			
		}
		
	}
	
	public Inicio getVista() {
		return vista;
	}

	public Sistema getSistema() {
		return sistema;
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		try {
			sistema.guardarDatos();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
