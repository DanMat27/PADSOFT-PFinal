package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Musica.Cancion;
import Sistema.Sistema;
import Usuarios.Autor;

public class Controlador_Administrador implements ActionListener, WindowListener  {
	private Admin_principal vista;
	private Sistema sistema;
	
	
	public Controlador_Administrador(Admin_principal vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("LOGOUT")) {
			boolean logout;
			logout = sistema.salirAdministrador();
			if (logout) {
				ClasePrincipal ventana_menu = new ClasePrincipal ("MDFTUNES");
				ventana_menu.setVisible(true);
				this.vista.setVisible(false);
				Controlador_Menu_Login controlador_menu_login = new Controlador_Menu_Login(ventana_menu, sistema);
				ventana_menu.setControladorMenuPrincipal(controlador_menu_login);
			}
		}
		else if(e.getActionCommand().equals("NOTIF")) {
			 Notif_pagina ventana_notif = new Notif_pagina ("Notificaciones", true, sistema.ListaNotificacionesAString(sistema.notificar()));
			 ventana_notif.setVisible(true);
			 this.vista.setVisible(false);
			 Controlador_Notificaciones controlador_notif = new Controlador_Notificaciones(ventana_notif, sistema);
			 ventana_notif.setControladorNotif(controlador_notif);
		}
		else if(e.getActionCommand().equals("CONFIG")) {
			Config ventana_config = new Config("Configuracion", sistema.getLimiteRepAnonimo(), sistema.getLimiteRepNormal(), sistema.getTopeSerPremium(), sistema.getCostePremium());
			ventana_config.setVisible(true);
			vista.setVisible(false);
			Controlador_Configuracion controlador_config = new Controlador_Configuracion(ventana_config, sistema);
			ventana_config.setControladorConfiguracion(controlador_config);
		}
		else if (e.getActionCommand().equals("VALIDAR")) {
			Val_pagina ventana_val = new Val_pagina("Validacion", sistema.ListaCancionesAStringAdmin((ArrayList<Cancion>)sistema.getListaCanciones()));
			ventana_val.setVisible(true);
			vista.setVisible(false);
			Controlador_Validacion controlador_val = new Controlador_Validacion(ventana_val, sistema);
			ventana_val.setControladorVal(controlador_val);
		}
		else if (e.getActionCommand().equals("PLAGIO")) {
			Plagio_pagina plagio = new Plagio_pagina("Plagio", sistema.ListaCancionesAStringAdmin((ArrayList<Cancion>)sistema.getListaCanciones()));
			plagio.setVisible(true);
			vista.setVisible(false);
			Controlador_Plagio controlador_plagio = new Controlador_Plagio(plagio,sistema);
			plagio.setControladorPlagio(controlador_plagio);
		}
		else if(e.getActionCommand().equals("AUTOR")){
			Autores_pagina a = new Autores_pagina("Autores", sistema.ListaAutoresAStringAdmin((ArrayList<Autor>)sistema.getListaUsuarios()));
			a.setVisible(true);
			vista.setVisible(false);
			Controlador_Autores controlador_autores = new Controlador_Autores(a,sistema);
			a.setControladorAutores(controlador_autores);
		}
		else if(e.getActionCommand().equals("BXC")){
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
		else if(e.getActionCommand().equals("BXA")){
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
		else {
			
		}
	}

	public Admin_principal getVista() {
		return vista;
	}

	public Sistema getSistema() {
		return sistema;
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		try {
			sistema.guardarDatos();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}	
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
