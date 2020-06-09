package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Sistema.Sistema;

public class Controlador_Anonimo implements ActionListener {
	private Anonymous vista;
	private Sistema sistema;
	
	
	public Controlador_Anonimo (Anonymous vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Cerrar Sesion")) {
			sistema.salirAnonimo();
			ClasePrincipal ventana_menu = new ClasePrincipal ("MDFTUNES");
			ventana_menu.setVisible(true);
			this.vista.setVisible(false);
			Controlador_Menu_Login controlador_menu_login = new Controlador_Menu_Login(ventana_menu, sistema);
			ventana_menu.setControladorMenuPrincipal(controlador_menu_login);
		}
		if(e.getActionCommand().equals("Registrarse")) {
			Registro pag = new Registro("Registrarse");
			pag.setVisible(true);
			vista.setVisible(false);
			Controlador_Menu_Registrarse control_registrarse = new Controlador_Menu_Registrarse(pag,sistema);
			control_registrarse.getVista().setControladorRegistro(control_registrarse);
			
		}
		
	}
	public Anonymous getVista() {
		return vista;
	}

	public Sistema getSistema() {
		return sistema;
	}
}