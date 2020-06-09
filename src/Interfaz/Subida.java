package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Subida_pagina extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel nombreAplicacion;
	private JButton cerrarSesion;
	private JLabel usuario;
	private JLabel espacios2;
	private JButton atras;
	private JLabel titulo;
	private JLabel titulo2;
	private JLabel titulo3;
	private JLabel espacios3;
	private JTextField cancion;
	private JTextField mp3;
	private JLabel espacios4;
	private JLabel espacios5;
	private JLabel espacios6;
	private JLabel espacios7;
	private JLabel espacios8;
	private JLabel espacios9;
	private JLabel espacios10;
	private JButton subir;
	private JLabel titulo4;
	
	public Subida_pagina(String text) {
		super(text);
		
		JPanel panelNorte = new JPanel();
		JPanel panelCentro = new JPanel();
		JPanel panelEste = new JPanel();
		
		this.add(panelNorte,BorderLayout.NORTH);
		this.add(panelCentro,BorderLayout.CENTER);
		this.add(panelEste,BorderLayout.EAST);
		
		/**
		 **********************PANEL NORTE***************************
		 */
		nombreAplicacion = new JLabel("MDFTUNES");
		nombreAplicacion.setForeground(Color.WHITE);
		Font auxFont = nombreAplicacion.getFont();
		nombreAplicacion.setFont(new Font(auxFont.getFontName(), Font.HANGING_BASELINE, 40));
		panelNorte.setBackground(new Color(51,60,136));
		panelNorte.add(nombreAplicacion);
		
		
		/**
		 * *****************PANEL CENTRAL********************************
		 */
		panelCentro.setBackground(new Color(138,149,151));
		panelCentro.setLayout(new BorderLayout());
		
		JPanel panelNorte2 = new JPanel();
		panelCentro.add(panelNorte2, BorderLayout.NORTH);
		panelNorte2.setPreferredSize(new Dimension(50, 60));
		panelNorte2.setBackground(new Color(63, 136, 143));
		
		titulo = new JLabel("<html><body><br>Subida de canciones</body></html>");
		titulo.setForeground(Color.WHITE);
		Font font2 = titulo.getFont();
		titulo.setFont(new Font(font2.getFontName(), Font.HANGING_BASELINE, 20));
		panelNorte2.add(titulo);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		panelCentro.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setBackground(new Color(138,149,151));
		
		
		JPanel panelCentro4 = new JPanel();
		panelCentral.add(panelCentro4);
		panelCentro4.setBackground(new Color(138,149,151));
		
		espacios3 = new JLabel("<html><body><br></body></html>");
		panelCentro4.add(espacios3);
		
		JPanel panelCentro5 = new JPanel();
		panelCentro5.setLayout(new BoxLayout(panelCentro5, BoxLayout.X_AXIS));
		panelCentral.add(panelCentro5);
		panelCentro5.setBackground(new Color(138,149,151));

		espacios4 = new JLabel("            ");
		panelCentro5.add(espacios4);
		
		titulo2 = new JLabel("       Introduce el nombre de la cancion:                                 ");
		titulo2.setForeground(Color.BLACK);
		Font font4 = titulo2.getFont(); 
		titulo2.setFont(new Font(font4.getFontName(), Font.HANGING_BASELINE, 14));
		panelCentro5.add(titulo2);
		
		cancion = new JTextField(20);
		panelCentro5.add(cancion);
		
		espacios5 = new JLabel("  ");
		panelCentro5.add(espacios5);
		
		JPanel panelCentro7 = new JPanel();
		panelCentral.add(panelCentro7);
		panelCentro7.setBackground(new Color(138,149,151));
		
		espacios6 = new JLabel("<html><body><br><br></body></html>");
		panelCentro7.add(espacios6);
		
		JPanel panelCentro6 = new JPanel();
		panelCentro6.setLayout(new BoxLayout(panelCentro6, BoxLayout.X_AXIS));
		panelCentral.add(panelCentro6);
		panelCentro6.setBackground(new Color(138,149,151));
		
		espacios7 = new JLabel("              ");
		panelCentro6.add(espacios7);
		
		titulo3 = new JLabel("     Introduce el nombre del archivo .MP3 de la carpeta Canciones:   ");
		titulo3.setForeground(Color.BLACK);
		Font font5 = titulo3.getFont(); 
		titulo3.setFont(new Font(font5.getFontName(), Font.HANGING_BASELINE, 14));
		panelCentro6.add(titulo3);
		
		mp3 = new JTextField(20);
		panelCentro6.add(mp3);
		
		espacios8 = new JLabel("  ");
		panelCentro6.add(espacios8);
		
		JPanel panelCentro9 = new JPanel();
		panelCentral.add(panelCentro9);
		panelCentro9.setBackground(new Color(138,149,151));
		
		espacios9 = new JLabel("<html><body></body></html>");
		panelCentro9.add(espacios9);
		
		JPanel panelCentro8 = new JPanel();
		panelCentro8.setLayout(new BoxLayout(panelCentro8, BoxLayout.X_AXIS));
		panelCentral.add(panelCentro8);
		panelCentro8.setBackground(new Color(138,149,151));
		
		titulo4 = new JLabel("     Subir:   ");
		titulo4.setForeground(Color.BLACK);
		Font font6 = titulo3.getFont(); 
		titulo4.setFont(new Font(font6.getFontName(), Font.HANGING_BASELINE, 14));
		panelCentro8.add(titulo4);
		
		subir = new JButton("  ");
		javax.swing.ImageIcon imagen = new javax.swing.ImageIcon(getClass().getResource("subida.png"));
		subir.setIcon(imagen);
		subir.setOpaque(false);
		subir.setContentAreaFilled(false);
		subir.setBorderPainted(false);
		panelCentro8.add(subir);
		
		JPanel panelSur = new JPanel();
		panelCentro.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.Y_AXIS));
		panelSur.setBackground(new Color(138,149,151));
		panelSur.setPreferredSize(new Dimension(100,300));
		
		JPanel panelCentro10 = new JPanel();
		panelCentro10.setLayout(new BoxLayout(panelCentro10, BoxLayout.X_AXIS));
		panelSur.add(panelCentro10);
		panelCentro10.setBackground(new Color(138,149,151));
		
		espacios10 = new JLabel("                        ");
		panelCentro10.add(espacios10);
		
		ImagenMDFTunes logo = new ImagenMDFTunes("MDFTunes_logo.jpg");
		panelCentro10.add(logo);
		
		
		/**
		 * *****************PANEL ESTE********************************
		 */
		panelEste.setBackground(new Color(63, 136, 143));
		panelEste.setLayout(new BorderLayout());
		
		JPanel panelNorte3 = new JPanel();
		panelEste.add(panelNorte3, BorderLayout.NORTH);
		panelNorte3.setPreferredSize(new Dimension(70, 10));
		panelNorte3.setBackground(new Color(63,136,143));
		
		JPanel panelCentro3 = new JPanel();
		panelEste.add(panelCentro3, BorderLayout.CENTER);
		panelCentro3.setLayout(new BoxLayout(panelCentro3, BoxLayout.Y_AXIS));
		panelCentro3.setBackground(new Color(63,136,143));
		
		JPanel panelSur3 = new JPanel();
		panelEste.add(panelSur3, BorderLayout.SOUTH);
		panelSur3.setPreferredSize(new Dimension(115, 400));
		panelSur3.setBackground(new Color(63,136,143));
		
		usuario = new JLabel("<html><body><br><u>Usuario:</u></body></html>");
		usuario.setForeground(Color.BLACK);
		Font font3 = usuario.getFont();
		usuario.setFont(new Font(font3.getFontName(), Font.HANGING_BASELINE, 10));
		
		espacios2 = new JLabel("<html><body><br></body></html>");
		
		cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setForeground(Color.BLUE);
		Font auxFont4 = cerrarSesion.getFont();
		cerrarSesion.setFont(new Font(auxFont4.getFontName(), Font.ITALIC, 10));

		atras = new JButton("       Atras       ");
		atras.setForeground(Color.BLUE);
		atras.setFont(new Font(auxFont4.getFontName(), Font.ITALIC, 10));
		
		ImagenUsuario user = new ImagenUsuario("usuario.png");
		
		panelCentro3.add(user);
		panelCentro3.add(usuario);
		panelCentro3.add(espacios2);
		panelCentro3.add(atras);
		panelCentro3.add(cerrarSesion);
		
		
		atras.setActionCommand("ATRAS");
		cerrarSesion.setActionCommand("LOGOUT");
		subir.setActionCommand("SUBIR");
		
		//mostrar ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void setControladorSubida(ActionListener c) {
		atras.addActionListener(c);
		cerrarSesion.addActionListener(c);
		subir.addActionListener(c);
		this.addWindowListener((WindowListener)c);
	}
	
	public String getCancion() {
		return cancion.getText();
	}
	
	public String getMP3() {
		return mp3.getText();
	}

}


public class Subida {
    public static void main(String [] args) {
        Runnable runner = new Runnable() {
            public void run() {
            	@SuppressWarnings("unused")
                final Subida_pagina ventana = new Subida_pagina("Subida");
            }
        };
        SwingUtilities.invokeLater(runner);     
    }
}
