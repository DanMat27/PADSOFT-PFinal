package Interfaz;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Excepciones.MusicaNoEncontrada;
import Musica.Album;
import Musica.Cancion;
import Sistema.Sistema;

public class ControladorBusquedaxAutor implements ActionListener,WindowListener {
	private BuscarxAutor vista;
	private Sistema sistema;
	
	
	public ControladorBusquedaxAutor (BuscarxAutor vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("vuelve")) {
			if(sistema.getUsuarioConectado().getNombre().equals("admin")) {
				Admin_principal admin = new Admin_principal("ADMINISTRADOR");
				admin.setVisible(true);
				vista.setVisible(false);
				Controlador_Administrador controlador_admin = new Controlador_Administrador(admin,sistema);
				controlador_admin.getVista().setControladorAdministrador(controlador_admin);
			}
			else if(sistema.getUsuarioConectado().getNombre().equals("anonimo")) {
				Anonymous anonimo = new Anonymous("ANONIMO");
				anonimo.setVisible(true);
				vista.setVisible(false);
				Controlador_Anonimo controlador_anonimo = new Controlador_Anonimo(anonimo,sistema);
				anonimo.setControladorAnonimo(controlador_anonimo);
			}
			else {
				Inicio ini = new Inicio("Bienvenido");
				ini.setVisible(true);
				this.vista.setVisible(false);
				Controlador_Bienvenido controlador_bienv = new Controlador_Bienvenido(ini,sistema);
				controlador_bienv.getVista().setControladorBienvenido(controlador_bienv);
			}
		}
		else if (e.getActionCommand().equals("CerrarSesioon")) {
			boolean logout;
			if(sistema.getUsuarioConectado().getNombre().equals("admin")) {
				logout = sistema.salirAdministrador();
				if(logout) {
					ClasePrincipal ventana_menu = new ClasePrincipal ("MDFTUNES");
					ventana_menu.setVisible(true);
					this.vista.setVisible(false);
					Controlador_Menu_Login controlador_menu_login = new Controlador_Menu_Login(ventana_menu, sistema);
					ventana_menu.setControladorMenuPrincipal(controlador_menu_login);
				}
			}
			else {
				logout = sistema.logout();
				if (logout) {
					ClasePrincipal ventana_menu = new ClasePrincipal ("MDFTUNES");
					ventana_menu.setVisible(true);
					this.vista.setVisible(false);
					Controlador_Menu_Login controlador_menu_login = new Controlador_Menu_Login(ventana_menu, sistema);
					ventana_menu.setControladorMenuPrincipal(controlador_menu_login);	
			    }
 
		    }
		}
		else if(e.getActionCommand().equals("CAMBIOPANTALLA")) {
			if(sistema.getUsuarioConectado().getNombre().equals("admin")) {
				ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
				BuscarxCancion busca_cancion = new BuscarxCancion("Buscar por cancion",1,sistema.ListaCancionesAString(listaCanciones));
				busca_cancion.setVisible(true);
				this.vista.setVisible(false);
				ControladorBusquedaxCancion  control_cancion = new ControladorBusquedaxCancion(busca_cancion,sistema);
				busca_cancion.setControladorBusquedaCancion(control_cancion);
			}
			else if(sistema.getUsuarioConectado().getNombre().equals("anonimo")) {
				ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
				BuscarxCancion busca_cancion = new BuscarxCancion("Buscar por cancion",2,sistema.ListaCancionesAString(listaCanciones));
				busca_cancion.setVisible(true);
				this.vista.setVisible(false);
				ControladorBusquedaxCancion  control_cancion = new ControladorBusquedaxCancion(busca_cancion,sistema);
				busca_cancion.setControladorBusquedaCancion(control_cancion);
			}
			else {
				ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
				BuscarxCancion busca_cancion = new BuscarxCancion("Buscar por cancion",0,sistema.ListaCancionesAString(listaCanciones));
				busca_cancion.setVisible(true);
				this.vista.setVisible(false);
				ControladorBusquedaxCancion  control_cancion = new ControladorBusquedaxCancion(busca_cancion,sistema);
				busca_cancion.setControladorBusquedaCancion(control_cancion);
			}

		}
		
		else if (vista.opcion1elegida()) {
			if (e.getActionCommand().equals("BUSCAR")) {
				if (vista.getBusqueda().equals("")) {
					JOptionPane.showMessageDialog(vista, "Debe introducir el nombre del autor.", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
				else {

						try {
							vista.CambiarPanelCentral(sistema.ListaCancionesAString((ArrayList<Cancion>) sistema.buscarCancionesAutor(vista.getBusqueda())));
						} catch (MusicaNoEncontrada e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		else if (vista.opcion2elegida()) {
			if (e.getActionCommand().equals("BUSCAR")) {
				if (vista.getBusqueda().equals("")) {
					JOptionPane.showMessageDialog(vista, "Debe introducir el album.", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
				else {

						try {
							vista.CambiarPanelCentral2(sistema.ListaAlbumAString((ArrayList<Album>)sistema.buscarAlbumesAutor(vista.getBusqueda())));
						} catch (MusicaNoEncontrada e1) {
							e1.printStackTrace();
						}
					}
				}
			}

		
		}
		
	
	public BuscarxAutor getVista() {
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