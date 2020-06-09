package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Excepciones.UsuarioInvalido;
import Musica.Cancion;
import Sistema.Sistema;

public class Controlador_Plagio implements ActionListener, WindowListener{
	private Plagio_pagina vista;
	private Sistema sistema;
	
	
	public Controlador_Plagio(Plagio_pagina vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("LOGOUT")) {
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
		else if(e.getActionCommand().equals("ATRAS")) {
			
			Admin_principal admin = new Admin_principal("ADMINISTRADOR");
			admin.setVisible(true);
			vista.setVisible(false);
			Controlador_Administrador controlador_admin = new Controlador_Administrador(admin,sistema);
			controlador_admin.getVista().setControladorAdministrador(controlador_admin);
			
		}
		else if(e.getActionCommand().equals("PLAGIO")) {
			
			if (vista.getId().equals("")) {
				 JOptionPane.showMessageDialog(vista, "No ha introducido el ID de la notificacion del reporte", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}	
			else {
				Boolean bloqueo;
				String ids = vista.getValorTupla();
				int id = Integer.valueOf(vista.getId());
				Cancion c = sistema.getListaCanciones().get(Integer.valueOf(ids));
				try {
					bloqueo = sistema.revisarPlagio(c, true, id);
					if(bloqueo) {
						Plagio_pagina plagio = new Plagio_pagina("Plagio", sistema.ListaCancionesAStringAdmin((ArrayList<Cancion>)sistema.getListaCanciones()));
						plagio.setVisible(true);
						vista.setVisible(false);
						Controlador_Plagio controlador_plagio = new Controlador_Plagio(plagio,sistema);
						plagio.setControladorPlagio(controlador_plagio);
					}
					else {
						 JOptionPane.showMessageDialog(vista, "No se pudo bloquear al autor de la cancion seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
						 return;
					}

				} catch (UsuarioInvalido e1) {
					e1.printStackTrace();
				}
			}
			
		}
		else if(e.getActionCommand().equals("NOPLAGIO")) {
			
			if (vista.getId().equals("")) {
				 JOptionPane.showMessageDialog(vista, "No ha introducido el ID de la notificacion del reporte", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}	
			else {
				Boolean bloqueo;
				String ids = vista.getValorTupla();
				int id = Integer.valueOf(vista.getId());
				Cancion c = sistema.getListaCanciones().get(Integer.valueOf(ids));
				try {
					bloqueo = sistema.revisarPlagio(c, false, id);
					if(bloqueo) {
						Plagio_pagina plagio = new Plagio_pagina("Plagio", sistema.ListaCancionesAStringAdmin((ArrayList<Cancion>)sistema.getListaCanciones()));
						plagio.setVisible(true);
						vista.setVisible(false);
						Controlador_Plagio controlador_plagio = new Controlador_Plagio(plagio,sistema);
						plagio.setControladorPlagio(controlador_plagio);
					}
					else {
						 JOptionPane.showMessageDialog(vista, "No se pudo bloquear al autor que hizo el reporte", "Error", JOptionPane.ERROR_MESSAGE);
						 return;
					}

				} catch (UsuarioInvalido e1) {
					e1.printStackTrace();
				}
			}
			
		}
		else {
			
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
	public void windowClosing(WindowEvent arg0) {
		try {
			sistema.guardarDatos();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}	
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
