package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Sistema.Sistema;
import Usuarios.Autor;

public class ControladorSeguirPersonas implements ActionListener,WindowListener {

	private Seguir vista;
	private Sistema sistema;
	
	
	public ControladorSeguirPersonas (Seguir vista, Sistema sistema) {
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
		else if (e.getActionCommand().equals("VOLVER")) {
			AutorSiguea aut = new AutorSiguea("Seguidores",false,sistema.ListaAutorAString((ArrayList<Autor>)sistema.seguidores()));
			aut.setVisible(true);
			this.vista.setVisible(false);
			Controlador_AutoresSeguidos control_seguidores = new Controlador_AutoresSeguidos(aut,sistema);
			aut.setControladorAutoresSeguidos(control_seguidores);
			
		}
		else if (e.getActionCommand().equals("SEGUIRAPERSONA")) {
			boolean seguir;
			if (this.vista.getNombreAutor().equals("")) {
				 JOptionPane.showMessageDialog(vista, "Debe introducir el nombre del autor.", "Warning", JOptionPane.WARNING_MESSAGE);
				 return;
			}
			seguir = sistema.seguirA(vista.getNombreAutor());
			 if (seguir) {
				 JOptionPane.showMessageDialog(null,"El usuario ha realizado el seguimiento");
			 }
			
		}
}
	public Seguir getVista() {
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
		// TODO Auto-generated method stub
		
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
