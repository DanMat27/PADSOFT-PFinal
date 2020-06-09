package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.*;

class PasarelaPago extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel textoPasarela;
	private JTextField creditCard;
	private JButton aceptarPago;
	private JButton volver;
	
	public PasarelaPago(String text) {
		super(text);
		JPanel panelNorte = new JPanel();
		JPanel panelCentro = new JPanel();
		
		this.add(panelNorte,BorderLayout.NORTH);
		this.add(panelCentro,BorderLayout.CENTER);
		
		/**
		 **********************PANEL NORTE***************
		 */
		JLabel nombreAplicacion = new JLabel("MDFTUNES");
		nombreAplicacion.setForeground(Color.WHITE);
		Font auxFont = nombreAplicacion.getFont();
		nombreAplicacion.setFont(new Font(auxFont.getFontName(), Font.HANGING_BASELINE, 40));
		panelNorte.setBackground(new Color(51,60,136));
		panelNorte.add(nombreAplicacion);
		
		/**
		 * *****************PANEL CENTRAL********************************
		 */
		 JPanel panelextra = new JPanel();
		 JPanel panelextra1 = new JPanel();
		 JPanel panelextra2 = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro,BoxLayout.Y_AXIS));
		panelCentro.setBackground(new Color(63, 136, 143));
		textoPasarela = new JLabel("Introduce tu tarjeta de credito");
		textoPasarela.setForeground(Color.WHITE);
		creditCard = new JTextField(10);
		aceptarPago = new JButton("Aceptar");
		volver = new JButton("Inicio");
		panelextra.setBackground(new Color(129,216,208));
		panelextra1.setBackground(new Color(129,216,208));
		panelextra2.setBackground(new Color(129,216,208));
		
		panelextra.add(textoPasarela);
		panelCentro.add(panelextra);
		panelextra1.add(creditCard);
		panelCentro.add(panelextra1);
		panelextra2.add(aceptarPago);
		panelextra2.add(volver);
		panelCentro.add(panelextra2);
		
		aceptarPago.setActionCommand("PAGO");
		volver.setActionCommand("VUELVE");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void setControladorPasarela(ActionListener c) {
		aceptarPago.addActionListener(c);
		volver.addActionListener(c);
		this.addWindowListener((WindowListener)c);
	}
	
	public String getTarjeta() {
		return creditCard.getText();
	}
	
}
