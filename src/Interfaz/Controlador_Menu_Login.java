package Interfaz;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import Excepciones.UsuarioInvalido;
import Sistema.*;
import Usuarios.Autor;
import Usuarios.Usuario;

public class Controlador_Menu_Login implements ActionListener, WindowListener {
	private ClasePrincipal vista;
	private Sistema sistema;
	
	
	public Controlador_Menu_Login(ClasePrincipal vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean login;
		
		if(e.getActionCommand().equals("LOGIN")) {
			
			if (vista.getUsuario().equals("")) {
				 JOptionPane.showMessageDialog(vista, "Debe introducir su nombre de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}	
			
			if (vista.getContrasenia().equals("")) {
				 JOptionPane.showMessageDialog(vista, "Debe introducir su password.", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}	
			
			try {
				if (vista.getUsuario().equals(sistema.getAdministrador().getNombre()) && vista.getContrasenia().equals(sistema.getAdministrador().getContrasenia())) {
					login = sistema.accederAdministrador(vista.getContrasenia());
					if (login) {
						Admin_principal admin = new Admin_principal("ADMINISTRADOR");
						admin.setVisible(true);
						vista.setVisible(false);
						Controlador_Administrador controlador_admin = new Controlador_Administrador(admin,sistema);
						controlador_admin.getVista().setControladorAdministrador(controlador_admin);
					}
				}
				else {
					login = sistema.login(vista.getUsuario(),vista.getContrasenia());
					if (login) {
						Inicio paginaPrincipal = new Inicio("MDFTUNES");
						for (Autor u: sistema.getListaUsuarios()) {
							if (u.getNickname().equals(vista.getUsuario())) {
								if (u.isPremium()) {
									paginaPrincipal.getPanelCambio();
								}
							}
						}
						paginaPrincipal.setVisible(true);
						vista.setVisible(false);
						Controlador_Bienvenido controlador_bienv = new Controlador_Bienvenido(paginaPrincipal,sistema);
						controlador_bienv.getVista().setControladorBienvenido(controlador_bienv);
					}
					else {
						JOptionPane.showMessageDialog(vista, "Nombre o Password erroneos.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
					
			} catch (UsuarioInvalido e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("REG")) {
			Registro reg = new Registro("Registrate");
			reg.setVisible(true);
			vista.setVisible(false);
			Controlador_Menu_Registrarse controlador_reg = new Controlador_Menu_Registrarse(reg, sistema);
			controlador_reg.getVista().setControladorRegistro(controlador_reg);
		}
		else if (e.getActionCommand().equals("ANOM")){
			Anonymous anom = new Anonymous("Anonimo");
			sistema.accederAnonimo();
			anom.setVisible(true);
			vista.setVisible(false);
			Controlador_Anonimo controlador_anom = new Controlador_Anonimo(anom, sistema);
			controlador_anom.getVista().setControladorAnonimo(controlador_anom);
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
