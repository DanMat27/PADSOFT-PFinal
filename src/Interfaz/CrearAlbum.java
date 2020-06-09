package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.*;

class AlbumCrear extends JFrame{
	private JLabel nombreAplicacion;
	private JTextField album1;
	private JLabel texto1;
	private JLabel texto2;
	private JButton crear;
	private JButton volver;
	public AlbumCrear(String text) {

		super(text);
		 JPanel panelNorte = new JPanel();
		 JPanel panelCentro = new JPanel();
		/**
		 * Introducimos nuestros paneles en el contenedor
		 */
		this.add(panelNorte,BorderLayout.NORTH);
		//ventana.add(panelOeste,BorderLayout.WEST);
		//ventana.add(panelEste,BorderLayout.EAST);
		this.add(panelCentro,BorderLayout.CENTER);
		/**
		 **********************PANEL NORTE***************
		 */
		
		nombreAplicacion = new JLabel("MDFTUNES");
		nombreAplicacion.setForeground(Color.WHITE);
		Font auxFont = nombreAplicacion.getFont();
		nombreAplicacion.setFont(new Font(auxFont.getFontName(), Font.HANGING_BASELINE, 40));
		panelNorte.setBackground(new Color(51,60,136));
		//panelNorte.setBackground(new Color(255,0,127));
		panelNorte.add(nombreAplicacion);

		/**
		 * *****************PANEL CENTRAL********************************
		 */
		 
		panelCentro.setBackground(new Color(63, 136, 143));
			
			 JPanel panelextra = new JPanel();
			 JPanel panelextra1 = new JPanel();
			 JPanel panelextra2 = new JPanel();
			 JPanel panelextra3 = new JPanel();
			 JPanel panelextra4 = new JPanel();
			 JPanel panelextra5 = new JPanel();
			 JPanel panelextra6 = new JPanel();
			 JPanel panelextra7 = new JPanel();
			 
			panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
			texto1 = new JLabel("Como llamaras a tu nuevo album: ");
			
			texto2 = new JLabel("Nombre Album: ");
			album1 = new JTextField(15);
			
			crear = new JButton("Crear Album");
			volver = new JButton("Inicio");
			panelextra.setBackground(new Color(129,216,208));
			panelextra1.setBackground(new Color(129,216,208));
			panelextra2.setBackground(new Color(129,216,208));
			panelextra3.setBackground(new Color(129,216,208));
			panelextra4.setBackground(new Color(129,216,208));
			panelextra5.setBackground(new Color(129,216,208));
			panelextra6.setBackground(new Color(129,216,208));
			panelextra7.setBackground(new Color(129,216,208));
			
			
			panelextra2.add(texto1);
			panelextra.add(texto2);
			panelextra1.add(album1);
			panelextra4.add(crear);
			panelextra4.add(volver);
			
			panelCentro.add(panelextra2);
			panelCentro.add(panelextra);
			panelCentro.add(panelextra1);
			panelCentro.add(panelextra4);
			panelCentro.add(panelextra5);
			panelCentro.add(panelextra3);
			panelCentro.add(panelextra6);
			panelCentro.add(panelextra7);
			
			this.crear.setActionCommand("CREOALBUM");
			this.volver.setActionCommand("vuelve");
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(400,400);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
	}
	
	public String nombreAlbum() {
		return album1.getText();
	}
	
	public void setControladorAlbum(ActionListener c) {
		this.crear.addActionListener(c);
		this.volver.addActionListener(c);
		this.addWindowListener((WindowListener)c);
	}
	
	
}



public class CrearAlbum {

}
