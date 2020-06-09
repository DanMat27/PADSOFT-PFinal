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
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;

public class ControladorPago implements ActionListener, WindowListener {
	private PasarelaPago vista;
	private Sistema sistema;
	
	public ControladorPago(PasarelaPago vista,Sistema sistema) {
		this.vista = vista;
		this.sistema = sistema;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean prem;
		if (e.getActionCommand().equals("PAGO")) {
			if (vista.getTarjeta().equals("")) {
				JOptionPane.showMessageDialog(vista,"Campo Obligatorio","ERROR",JOptionPane.WARNING_MESSAGE);
				return;
			}
			try {
				prem = sistema.convertirsePremium(vista.getTarjeta());
				if(prem) {
					JOptionPane.showMessageDialog(null,"Se ha registrado corectamente");
					Inicio ini = new Inicio("Bienvenido");
					ini.getPanelCambio();
					ini.setVisible(true);
					vista.setVisible(false);
					Controlador_Bienvenido controlador_bienv = new Controlador_Bienvenido(ini,sistema);
					controlador_bienv.getVista().setControladorBienvenido(controlador_bienv);
				
				}
				else {
					JOptionPane.showMessageDialog(vista,"El usuario ya es premium","Cuidado",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
			} catch (InvalidCardNumberException e1) {
				JOptionPane.showMessageDialog(vista,"Error al introducir la tarjeta","ERROR",JOptionPane.ERROR_MESSAGE);
				//e1.printStackTrace();
			} catch (FailedInternetConnectionException e1) {
				//e1.printStackTrace();
			} catch (OrderRejectedException e1) {
				//e1.printStackTrace();
			} catch (UsuarioInvalido e1) {
				//e1.printStackTrace();
			}
		}
		else if (e.getActionCommand().equals("VUELVE")) {
			Inicio ini = new Inicio("Bienvenido");
			ini.setVisible(true);
			vista.setVisible(false);
			Controlador_Bienvenido controlador_bienv = new Controlador_Bienvenido(ini,sistema);
			controlador_bienv.getVista().setControladorBienvenido(controlador_bienv);
		
		}
		else {
			
		}
		
	}
	
	public PasarelaPago getVista() {
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
