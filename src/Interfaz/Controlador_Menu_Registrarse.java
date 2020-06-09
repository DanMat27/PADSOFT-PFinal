package Interfaz;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import Sistema.Sistema;

public class Controlador_Menu_Registrarse  implements ActionListener, WindowListener {
	private Registro vista;
	private Sistema sistema;
	
	
	public Controlador_Menu_Registrarse (Registro vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean registro;
		if(e.getActionCommand().equals("ACCEDER")) {
			
			if (vista.getUsuario().equals("")) {
				 JOptionPane.showMessageDialog(vista, "Debe introducir su nombre de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}	
			
			if (vista.getContrasenia().equals("")) {
				 JOptionPane.showMessageDialog(vista, "Debe introducir su password.", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			if (vista.getNickname().equals("")) {
				JOptionPane.showMessageDialog(vista,"Debe introducir un nickname","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			registro = sistema.registrarse(vista.getUsuario(),vista.getContrasenia(),vista.getFechaNac(), vista.getNickname());
			if (registro) {
				if(sistema.getUsuarioConectado()==null) {
					ClasePrincipal ventana_menu = new ClasePrincipal ("MDFTUNES");
					ventana_menu.setVisible(true);
					this.vista.setVisible(false);
					Controlador_Menu_Login controlador_menu_login = new Controlador_Menu_Login(ventana_menu, sistema);
					ventana_menu.setControladorMenuPrincipal(controlador_menu_login);
				}
				else {
					Anonymous anonimo = new Anonymous("ANONIMO");
					anonimo.setVisible(true);
					vista.setVisible(false);
					Controlador_Anonimo controlador_anonimo = new Controlador_Anonimo(anonimo,sistema);
					anonimo.setControladorAnonimo(controlador_anonimo);
				}

			}
			else {
				JOptionPane.showMessageDialog(vista, "Algun campo es invalido.", "Error", JOptionPane.ERROR_MESSAGE);
			}	
		}
		else{
			if(sistema.getUsuarioConectado()==null) {
				ClasePrincipal ventana_menu = new ClasePrincipal ("MDFTUNES");
				ventana_menu.setVisible(true);
				this.vista.setVisible(false);
				Controlador_Menu_Login controlador_menu_login = new Controlador_Menu_Login(ventana_menu, sistema);
				ventana_menu.setControladorMenuPrincipal(controlador_menu_login);
			}
			else {
				Anonymous anonimo = new Anonymous("ANONIMO");
				anonimo.setVisible(true);
				vista.setVisible(false);
				Controlador_Anonimo controlador_anonimo = new Controlador_Anonimo(anonimo,sistema);
				anonimo.setControladorAnonimo(controlador_anonimo);
			}

		}
	}

	public Registro getVista() {
		return vista;
	}

	public Sistema getSistema() {
		return sistema;
	}


	@Override
	public void windowActivated(WindowEvent arg0) {
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
