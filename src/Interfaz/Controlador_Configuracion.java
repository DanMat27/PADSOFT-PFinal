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

public class Controlador_Configuracion implements ActionListener, WindowListener {
	private Config vista;
	private Sistema sistema;
	
	public Controlador_Configuracion(Config vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean c;

		if (e.getActionCommand().equals("LRA")) {
			
			if (vista.getLRA().equals("")) {
				 JOptionPane.showMessageDialog(vista, "No ha introducido un valor al que cambiar", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}	
			try {
				c = sistema.cambiarConfiguracion(Integer.valueOf(vista.getLRA()), 0, 0, 0);
				Config ventana_config = new Config("Configuracion", sistema.getLimiteRepAnonimo(), sistema.getLimiteRepNormal(), sistema.getTopeSerPremium(), sistema.getCostePremium());
				ventana_config.setVisible(true);
				vista.setVisible(false);
				Controlador_Configuracion controlador_config = new Controlador_Configuracion(ventana_config, sistema);
				ventana_config.setControladorConfiguracion(controlador_config);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (UsuarioInvalido e1) {
				e1.printStackTrace();
			}
			
		}
		else if (e.getActionCommand().equals("LRN")) {
			
			if (vista.getLRN().equals("")) {
				 JOptionPane.showMessageDialog(vista, "No ha introducido un valor al que cambiar", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}	
			try {
				c = sistema.cambiarConfiguracion(0, Integer.valueOf(vista.getLRN()), 0, 0);
				Config ventana_config = new Config("Configuracion", sistema.getLimiteRepAnonimo(), sistema.getLimiteRepNormal(), sistema.getTopeSerPremium(), sistema.getCostePremium());
				ventana_config.setVisible(true);
				vista.setVisible(false);
				Controlador_Configuracion controlador_config = new Controlador_Configuracion(ventana_config, sistema);
				ventana_config.setControladorConfiguracion(controlador_config);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (UsuarioInvalido e1) {
				e1.printStackTrace();
			}
			
		}
		else if (e.getActionCommand().equals("TP")) {
			
			if (vista.getTP().equals("")) {
				 JOptionPane.showMessageDialog(vista, "No ha introducido un valor al que cambiar", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}	
			try {
				c = sistema.cambiarConfiguracion(0, 0, Integer.valueOf(vista.getTP()), 0);
				Config ventana_config = new Config("Configuracion", sistema.getLimiteRepAnonimo(), sistema.getLimiteRepNormal(), sistema.getTopeSerPremium(), sistema.getCostePremium());
				ventana_config.setVisible(true);
				vista.setVisible(false);
				Controlador_Configuracion controlador_config = new Controlador_Configuracion(ventana_config, sistema);
				ventana_config.setControladorConfiguracion(controlador_config);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (UsuarioInvalido e1) {
				e1.printStackTrace();
			}
			
		}
		else if (e.getActionCommand().equals("CP")) {
			
			if (vista.getCP().equals("")) {
				 JOptionPane.showMessageDialog(vista, "No ha introducido un valor al que cambiar", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}	
			try {
				c = sistema.cambiarConfiguracion(0, 0, 0, Double.valueOf(vista.getCP()));
				Config ventana_config = new Config("Configuracion", sistema.getLimiteRepAnonimo(), sistema.getLimiteRepNormal(), sistema.getTopeSerPremium(), sistema.getCostePremium());
				ventana_config.setVisible(true);
				vista.setVisible(false);
				Controlador_Configuracion controlador_config = new Controlador_Configuracion(ventana_config, sistema);
				ventana_config.setControladorConfiguracion(controlador_config);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (UsuarioInvalido e1) {
				e1.printStackTrace();
			}
			
		}
		else if(e.getActionCommand().equals("ATRAS")) {
			
			Admin_principal admin = new Admin_principal("ADMINISTRADOR");
			admin.setVisible(true);
			vista.setVisible(false);
			Controlador_Administrador controlador_admin = new Controlador_Administrador(admin,sistema);
			controlador_admin.getVista().setControladorAdministrador(controlador_admin);
			
		}
		else if(e.getActionCommand().equals("LOGOUT")) {
			
			Boolean logout = sistema.salirAdministrador();
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

	public Config getVista() {
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
