package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import Excepciones.UsuarioInvalido;
import Sistema.Sistema;
import Usuarios.Autor;
import pads.musicPlayer.exceptions.Mp3PlayerException;

public class Controlador_Subida implements ActionListener, WindowListener {
	private Subida_pagina vista;
	private Sistema sistema;
	
	public Controlador_Subida(Subida_pagina vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("ATRAS")) {
				Autor autor = (Autor) sistema.getUsuarioConectado();
			
				Inicio paginaPrincipal = new Inicio("MDFTUNES");
				if (autor.isPremium()) {
					paginaPrincipal.getPanelCambio();
				}
				paginaPrincipal.setVisible(true);
				vista.setVisible(false);
				Controlador_Bienvenido controlador_bienv = new Controlador_Bienvenido(paginaPrincipal,sistema);
				controlador_bienv.getVista().setControladorBienvenido(controlador_bienv);
			
		}
		else if(e.getActionCommand().equals("LOGOUT")) {
			
			Boolean logout = sistema.logout();
			if (logout) {
				ClasePrincipal ventana_menu = new ClasePrincipal ("MDFTUNES");
				ventana_menu.setVisible(true);
				this.vista.setVisible(false);
				Controlador_Menu_Login controlador_menu_login = new Controlador_Menu_Login(ventana_menu, sistema);
				ventana_menu.setControladorMenuPrincipal(controlador_menu_login);
			}
			
		}
		else if (e.getActionCommand().equals("SUBIR")){
			Boolean subida;
			 
			if (vista.getMP3().equals("")) {
				 JOptionPane.showMessageDialog(vista, "No ha introducido el nombre del archivo MP3.", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			if (vista.getCancion().equals("")) {
				 JOptionPane.showMessageDialog(vista, "No ha introducido el nombre de la cancion.", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}	
			
			try {
				subida = sistema.subirCancion(vista.getCancion(), vista.getMP3());
				if(subida) {
					JOptionPane.showMessageDialog(vista, "Se ha subido correctamente la cancion. En espera de la validacion del administrador para que sea publicada.", "Ok", JOptionPane.INFORMATION_MESSAGE);
					Subida_pagina ventana_s = new Subida_pagina("Subida");
					ventana_s.setVisible(true);
					this.vista.setVisible(false);
					Controlador_Subida controlador_s = new Controlador_Subida(ventana_s, sistema);
					ventana_s.setControladorSubida(controlador_s);
				}
				else {
					 JOptionPane.showMessageDialog(vista, "No se ha podido subir la cancion.", "Error", JOptionPane.ERROR_MESSAGE);
					 return;
				}

			} catch (FileNotFoundException e1) {
				 JOptionPane.showMessageDialog(vista, "Archivo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
				 e1.printStackTrace();
			} catch (Mp3PlayerException e1) {
				e1.printStackTrace();
			} catch (UsuarioInvalido e1) {
				e1.printStackTrace();
			}
				

			 
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
