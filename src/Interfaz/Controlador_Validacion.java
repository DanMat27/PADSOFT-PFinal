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
import pads.musicPlayer.exceptions.Mp3PlayerException;

public class Controlador_Validacion implements ActionListener, WindowListener {
	private Val_pagina vista;
	private Sistema sistema;
	
	public Controlador_Validacion(Val_pagina vista, Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getActionCommand().equals("ATRAS")) {
			
			Admin_principal admin = new Admin_principal("ADMINISTRADOR");
			admin.setVisible(true);
			vista.setVisible(false);
			Controlador_Administrador controlador_admin = new Controlador_Administrador(admin,sistema);
			controlador_admin.getVista().setControladorAdministrador(controlador_admin);
			
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
		else if(e.getActionCommand().equals("VAL")) {
			String Id;
			
			Id = vista.getValorTupla();
			if(Id!=null) {
				try {
					sistema.validarCancion(sistema.getListaCanciones().get(Integer.valueOf(Id)), true);
					Val_pagina ventana_val = new Val_pagina("Validacion", sistema.ListaCancionesAStringAdmin((ArrayList<Cancion>)sistema.getListaCanciones()));
					ventana_val.setVisible(true);
					this.vista.setVisible(false);
					Controlador_Validacion controlador_val = new Controlador_Validacion(ventana_val, sistema);
					ventana_val.setControladorVal(controlador_val);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (Mp3PlayerException e1) {
					e1.printStackTrace();
				} catch (UsuarioInvalido e1) {
					e1.printStackTrace();
				}
			}
			else {
				 JOptionPane.showMessageDialog(vista, "Pulse sobre el indice de la cancion elegida", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}

		}
		else if(e.getActionCommand().equals("NOVAL")) {
			String Id;
			
			Id = vista.getValorTupla();
			if(Id!=null) {
				try {
					sistema.validarCancion(sistema.getListaCanciones().get(Integer.valueOf(Id)), false);
					Val_pagina ventana_val = new Val_pagina("Validacion", sistema.ListaCancionesAStringAdmin((ArrayList<Cancion>)sistema.getListaCanciones()));
					ventana_val.setVisible(true);
					this.vista.setVisible(false);
					Controlador_Validacion controlador_val = new Controlador_Validacion(ventana_val, sistema);
					ventana_val.setControladorVal(controlador_val);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (Mp3PlayerException e1) {
					e1.printStackTrace();
				} catch (UsuarioInvalido e1) {
					e1.printStackTrace();
				}
			}
			else {
				 JOptionPane.showMessageDialog(vista, "Pulse sobre el indice de la cancion elegida", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
		}
		else if(e.getActionCommand().equals("EXP")) {
			String Id;
			Boolean exp;
			
			Id = vista.getValorTupla();
			if(Id!=null) {
				try {
					exp = sistema.comprobarExplicito(sistema.getListaCanciones().get(Integer.valueOf(Id)));
					if(exp) {
						Val_pagina ventana_val = new Val_pagina("Validacion", sistema.ListaCancionesAStringAdmin((ArrayList<Cancion>)sistema.getListaCanciones()));
						ventana_val.setVisible(true);
						this.vista.setVisible(false);
						Controlador_Validacion controlador_val = new Controlador_Validacion(ventana_val, sistema);
						ventana_val.setControladorVal(controlador_val);
					}
					else {
						 JOptionPane.showMessageDialog(vista, "Solo puede ser explicita una cancion en estado VALIDADA", "Error", JOptionPane.ERROR_MESSAGE);
						 return;
					}

				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (UsuarioInvalido e1) {
					e1.printStackTrace();
				}
			}
			else {
				 JOptionPane.showMessageDialog(vista, "Pulse sobre el indice de la cancion elegida", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
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
