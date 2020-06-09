package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import Sistema.Sistema;

public class Controlador_MisAlbumes implements ActionListener, WindowListener  {
	private Albumes vista;
	private Sistema sistema;
	
	public Controlador_MisAlbumes(Albumes vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean logout;
		
		if (e.getActionCommand().equals("ATRAS")) {
			if(sistema.getUsuarioConectado().getNombre().equals("admin")) {
				Admin_principal admin = new Admin_principal("ADMINISTRADOR");
				admin.setVisible(true);
				vista.setVisible(false);
				Controlador_Administrador controlador_admin = new Controlador_Administrador(admin,sistema);
				controlador_admin.getVista().setControladorAdministrador(controlador_admin);
			}
			else {
				Inicio ini = new Inicio("Bienvenido");
				ini.setVisible(true);
				vista.setVisible(false);
				Controlador_Bienvenido controlador_bienv = new Controlador_Bienvenido(ini,sistema);
				controlador_bienv.getVista().setControladorBienvenido(controlador_bienv);
			}
		}
		else if(e.getActionCommand().equals("LOGOUT")) {
			if(sistema.getUsuarioConectado().getNombre().equals("admin")) {
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
		else {
			
		}
			
	}

	public Albumes getVista() {
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

