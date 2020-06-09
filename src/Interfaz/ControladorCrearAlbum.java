package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import Excepciones.UsuarioInvalido;
import Sistema.Sistema;

public class ControladorCrearAlbum implements ActionListener, WindowListener {
	private AlbumCrear vista;
	private Sistema sistema;
	
	
	public ControladorCrearAlbum (AlbumCrear vista, Sistema sistema) {
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
		else if (e.getActionCommand().equals("CREOALBUM")) {
			
			if(vista.nombreAlbum().equals("")) {
				 JOptionPane.showMessageDialog(vista, "Debe introducir el nombre del album.", "Error", JOptionPane.WARNING_MESSAGE);
				 return;
			}
			try {
				if (sistema.crearAlbum(vista.nombreAlbum()) == true) {
					JOptionPane.showMessageDialog(null,"El album "+vista.nombreAlbum()+" se creo correctamente");
					return;
				}
				else {
					 JOptionPane.showMessageDialog(vista, "No se creo el album.", "Error", JOptionPane.WARNING_MESSAGE);

				}
			} catch (UsuarioInvalido e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
}

	
	public AlbumCrear getVista() {
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
