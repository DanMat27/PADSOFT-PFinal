package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import Sistema.Sistema;

public class Controlador_Autores implements ActionListener, WindowListener  {
	private Autores_pagina vista;
	private Sistema sistema;
	
	public Controlador_Autores(Autores_pagina vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean logout;
		
		if (e.getActionCommand().equals("ATRAS")) {
			
				Admin_principal admin = new Admin_principal("ADMINISTRADOR");
				admin.setVisible(true);
				vista.setVisible(false);
				Controlador_Administrador controlador_admin = new Controlador_Administrador(admin,sistema);
				controlador_admin.getVista().setControladorAdministrador(controlador_admin);
				
		}
		else if(e.getActionCommand().equals("LOGOUT")) {
			
				logout = sistema.salirAdministrador();
				if (logout) {
					ClasePrincipal ventana_menu = new ClasePrincipal ("MDFTUNES");
					ventana_menu.setVisible(true);
					this.vista.setVisible(false);
					Controlador_Menu_Login controlador_menu_login = new Controlador_Menu_Login(ventana_menu, sistema);
					ventana_menu.setControladorMenuPrincipal(controlador_menu_login);
				}

		}
		else {
			
		}
		
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
