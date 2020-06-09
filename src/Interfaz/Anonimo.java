package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


class Anonymous extends JFrame{
	
	private JLabel texto1;
	private JLabel nombreAplicacion;
	private JLabel texto2;
	private JLabel eslogan;
	private JLabel texto3;
	private JLabel texto4;
	private JLabel texto5;
	private JLabel texto6;
	private JLabel texto7;
	private JLabel espacios;
	private JLabel Busqueda;
	private JButton busquedaxautor;
	private JButton busquedaxcancion;
	private JButton cerrarSesion;
	private JButton registro;
	
	private static final long serialVersionUID = 1L;

	public Anonymous(String text) {
		super(text);
		 JPanel panelNorte = new JPanel();
		 JPanel panelCentro = new JPanel();
		 JPanel panelEste = new JPanel();
		 JPanel panelOeste = new JPanel();
		/**
		 * Introducimos nuestros paneles en el contenedor
		 */
		this.add(panelNorte,BorderLayout.NORTH);
		//ventana.add(panelOeste,BorderLayout.WEST);
		//ventana.add(panelEste,BorderLayout.EAST);
		this.add(panelCentro,BorderLayout.CENTER);
		this.add(panelEste,BorderLayout.EAST);
		this.add(panelOeste, BorderLayout.WEST);
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
		 
		panelCentro.setBackground(new Color(138,149,151));
		
		panelCentro.setBackground(new Color(138,149,151));
		texto1 = new JLabel("                         Bienvenido!");
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));

		Font auxFont1 = texto1.getFont();
		texto1.setFont(new Font(auxFont1.getFontName(), auxFont.getStyle(), 27));
		texto1.setHorizontalAlignment(JTextField.CENTER);
		texto2 = new JLabel("<html><body><br><br></body></html>");
		eslogan = new JLabel("                         			                    Musica como estilo de vida");
		Font auxFont2 = eslogan.getFont();
		
		ImagenMDFTunes logo = new ImagenMDFTunes("MDFTunes_logo.jpg");
		//logo.setSize(100, 100);
		
		eslogan.setFont(new Font(auxFont2.getFontName(),auxFont.getStyle(), 15));
		//panelCentro.putConstraint(BoxLayout.X_AXIS,texto1, 5, BoxLayout.X_AXIS,this);
		
		texto3 = new JLabel ("<html><body><br> Bienvenido a la aplicacion oficial de MDFTunes,aquí podrás adentrarte en un mundo de </body></html>");
		texto4 = new JLabel ("<html><body> de musica increible. Una vez registrado, podrás acceder a distintas funciones</body></html>");
		texto5 = new JLabel ("<html><body> como por ejemplo subir tus propias canciones o realizar búsquedas segun los criterios </body></html>");
		texto6 = new JLabel ("<html><body> de búsqueda que le asignes. No solo eso, también podrás seguir a otros autores </body></html>");
		texto7 = new JLabel ("<html><body> para estar al tanto de su actividad. ¿A qué esperas?, REGÍSTRATE YA!!!!! <br><br></body></html>");
		
		registro = new JButton("<html><body><center><font color=#FFFFFF><u>Registrarse</u></font></center></body><html>");
		registro.setBackground(new Color(147, 112, 219));
		registro.setPreferredSize(new Dimension(420,25));
		
		panelCentro.add(texto1);
		panelCentro.add(texto2);
		panelCentro.add(eslogan);
		panelCentro.add(texto3);
		panelCentro.add(texto4);
		panelCentro.add(texto5);
		panelCentro.add(texto6);
		panelCentro.add(texto7);
		panelCentro.add(logo);
		panelCentro.add(registro);
		
		/**
		 * ***************** PANEL OESTE *******************
		 */
		
		panelOeste.setBackground(new Color(63,136,143));
		
		panelEste.setLayout(new BorderLayout());
		
		JPanel panelNorte4 = new JPanel();
		panelOeste.add(panelNorte4, BorderLayout.NORTH);
		panelNorte4.setPreferredSize(new Dimension(10, 10));
		panelNorte4.setBackground(new Color(63,136,143));
		
		espacios = new JLabel("<html><body><br></body></html>");
		
		JPanel panelCentro4 = new JPanel();
		panelOeste.add(panelCentro4, BorderLayout.SOUTH);
		panelCentro4.setLayout(new BoxLayout(panelCentro4, BoxLayout.Y_AXIS));
		panelCentro4.setBackground(new Color(63,136,143));
		
		Busqueda = new JLabel("<html><body><br><u>Busqueda:</u></body></html>");
		Busqueda.setForeground(Color.BLACK);
		Font auxFont5 = Busqueda.getFont();
		Busqueda.setFont(new Font(auxFont5.getFontName(), Font.HANGING_BASELINE, 10));
		
		busquedaxautor = new JButton("Por Autor");
		busquedaxautor.setForeground(Color.BLUE);
		Font auxFont6 = busquedaxautor.getFont();
		busquedaxautor.setFont(new Font(auxFont6.getFontName(), Font.ITALIC, 10));
		
		busquedaxcancion = new JButton("Por Cancion");
		busquedaxcancion.setForeground(Color.BLUE);
		Font auxFont7 = busquedaxcancion.getFont();
		busquedaxcancion.setFont(new Font(auxFont7.getFontName(), Font.ITALIC, 10));
		
		panelCentro4.add(Busqueda);
		panelCentro4.add(espacios);
		panelCentro4.add(busquedaxautor);
		panelCentro4.add(busquedaxcancion);
		
		/**
		 *  ******************* PANEL ESTE **************************
		 */
		panelEste.setBackground(new Color(63,136,143));
		
		panelEste.setLayout(new BorderLayout());
		
		JPanel panelNorte3 = new JPanel();
		panelEste.add(panelNorte3, BorderLayout.NORTH);
		panelNorte3.setPreferredSize(new Dimension(100, 10));
		panelNorte3.setBackground(new Color(63,136,143));
		
		JPanel panelCentro3 = new JPanel();
		panelEste.add(panelCentro3, BorderLayout.CENTER);
		panelCentro3.setLayout(new BoxLayout(panelCentro3, BoxLayout.Y_AXIS));
		panelCentro3.setBackground(new Color(63,136,143));
		
		JPanel panelSur3 = new JPanel();
		panelEste.add(panelSur3, BorderLayout.SOUTH);
		panelSur3.setPreferredSize(new Dimension(100, 450));
		panelSur3.setBackground(new Color(63,136,143));
		
		JLabel usuario = new JLabel("<html><body><br><u>Anónimo:</u></body></html>");
		usuario.setForeground(Color.BLACK);
		Font auxFont3 = usuario.getFont();
		usuario.setFont(new Font(auxFont3.getFontName(), Font.HANGING_BASELINE, 10));
		
		cerrarSesion = new JButton("Inicio");
		cerrarSesion.setForeground(Color.BLUE);
		Font auxFont4 = cerrarSesion.getFont();
		cerrarSesion.setFont(new Font(auxFont4.getFontName(), Font.ITALIC, 10));
		
		
		ImagenUsuario user = new ImagenUsuario("usuario.png");
		
		panelCentro3.add(user);

		panelCentro3.add(usuario);

		panelCentro3.add(cerrarSesion);
		
		this.cerrarSesion.setActionCommand("Cerrar Sesion");
		this.registro.setActionCommand("Registrarse");
		this.busquedaxautor.setActionCommand("Busquedas por autor");
		this.busquedaxcancion.setActionCommand("Busquedas por cancion");
		
		//mostrar ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void setControladorAnonimo(ActionListener c) {
		cerrarSesion.addActionListener(c);
		registro.addActionListener(c);
	}
	
}


/*
public class Anonimo {

	public static void main(String [] args) {
			Runnable runner = new Runnable() {
				public void run() {
					// Ventana principal 
					@SuppressWarnings("unused")
					final Anonymous ventana = new Anonymous ("Anonimo");
				}
			};
			SwingUtilities.invokeLater(runner);		
		}
}*/