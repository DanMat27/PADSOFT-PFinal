package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import Sistema.Sistema;


public class Controlador_AutoresSeguidos implements ActionListener, WindowListener {
	private AutorSiguea vista;
	private Sistema sistema;
	
	
	public Controlador_AutoresSeguidos (AutorSiguea vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("vuelve")) {
			Inicio ini = new Inicio("Bienvenido");
			ini.setVisible(true);
			this.vista.setVisible(false);
			Controlador_Bienvenido controlador_bienv = new Controlador_Bienvenido(ini,sistema);
			controlador_bienv.getVista().setControladorBienvenido(controlador_bienv);
		}
		else if (e.getActionCommand().equals("CerrarSesioon")) {
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
		else if (e.getActionCommand().equals("SEGUIR")) {
			Seguir seguirpersonas = new Seguir("Seguir");
			seguirpersonas.setVisible(true);
			this.vista.setVisible(false);
			ControladorSeguirPersonas control_seguir = new ControladorSeguirPersonas(seguirpersonas,sistema);
			seguirpersonas.setControladorSeguirPersonas(control_seguir);
		}
		
		
		
		
}


	public AutorSiguea getVista() {
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
