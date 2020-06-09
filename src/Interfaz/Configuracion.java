package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Config extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel nombreAplicacion;
	private JLabel titulo;
	private JLabel limiteRepAnonimo;
	private JLabel lra; 
	private JTextField cambiarLRA;
	private JLabel hueco;
	private JButton botonLRA;
	private JLabel limiteRepNormal;
	private JLabel lrn;
	private JTextField cambiarLRN;
	private JLabel hueco2;
	private JButton botonLRN;
	private JLabel topePremium;
	private JLabel tp;
	private JTextField cambiarTP;
	private JLabel hueco3;
	private JButton botonTP;
	private JLabel costePremium;
	private JLabel cp;
	private JTextField cambiarCP;
	private JLabel hueco4;
	private JButton botonCP;
	private JLabel admin;
	private JButton atras;
	private JButton cerrarSesion;
	
	public Config(String text, int LRA, int LRN, int TP, double CP) {
		super(text);
		
		JPanel panelNorte = new JPanel();
		JPanel panelCentro = new JPanel();
		JPanel panelEste = new JPanel();
		
		/**
		 * Introducimos nuestros paneles en el contenedor
		 */
		this.add(panelNorte,BorderLayout.NORTH);
		this.add(panelCentro,BorderLayout.CENTER);
		this.add(panelEste,BorderLayout.EAST);
		
		/**
		 **********************PANEL NORTE***************
		 */
		nombreAplicacion = new JLabel("MDFTUNES");
		nombreAplicacion.setForeground(Color.WHITE);
		Font auxFont = nombreAplicacion.getFont();
		nombreAplicacion.setFont(new Font(auxFont.getFontName(), Font.HANGING_BASELINE, 40));
		panelNorte.setBackground(new Color(51,60,136));
		panelNorte.add(nombreAplicacion);
		
		
		/**
		 **********************PANEL NORTE***************
		 */
		panelCentro.setBackground(new Color(138,149,151));
		
		panelCentro.setLayout(new BorderLayout());
		
		JPanel panelNorte2 = new JPanel();
		panelCentro.add(panelNorte2, BorderLayout.NORTH);
		panelNorte2.setPreferredSize(new Dimension(50, 60));
		panelNorte2.setBackground(new Color(63, 136, 143));
		
		
		titulo = new JLabel("<html><body><br>Configuracion:</body></html>");
		titulo.setForeground(Color.WHITE);
		Font font2 = titulo.getFont();
		titulo.setFont(new Font(font2.getFontName(), Font.ROMAN_BASELINE, 20));
		panelNorte2.add(titulo);
		
		JPanel panelCentro2 = new JPanel();
		panelCentro2.setLayout(new BoxLayout(panelCentro2, BoxLayout.Y_AXIS));
		panelCentro.add(panelCentro2, BorderLayout.CENTER);
		panelCentro2.setBackground(new Color(138,149,151));
		
		
		JPanel panelExtra = new JPanel();
		panelExtra.setBackground(new Color(138,149,151));

		limiteRepAnonimo = new JLabel("<html><body><br>Limite actual de reproducciones de un anonimo: " + LRA + "</body></html>");
		limiteRepAnonimo.setForeground(Color.WHITE);
		Font font3 = limiteRepAnonimo.getFont();
		limiteRepAnonimo.setFont(new Font(font3.getFontName(), Font.HANGING_BASELINE, 14));
		panelExtra.add(limiteRepAnonimo);
		
		
		JPanel panelExtra2 = new JPanel();
		panelExtra2.setLayout(new BoxLayout(panelExtra2, BoxLayout.X_AXIS));
		panelExtra2.setBackground(new Color(138,149,151));
		 
		lra = new JLabel("                  Modificar limite de reproducciones de anonimo:                   ");
		lra.setForeground(Color.BLACK);
		panelExtra2.add(lra);
		cambiarLRA = new JTextField(4);
		cambiarLRA.setPreferredSize(new Dimension(10, 10));
		panelExtra2.add(cambiarLRA);
		hueco = new JLabel("  ");
		panelExtra2.add(hueco);
		botonLRA = new JButton("  ");
		javax.swing.ImageIcon imagen = new javax.swing.ImageIcon(getClass().getResource("ok.png"));
		botonLRA.setIcon(imagen);
		botonLRA.setOpaque(false);
		botonLRA.setContentAreaFilled(false);
        botonLRA.setBorderPainted(false);
		panelExtra2.add(botonLRA);
		
		
		JPanel panelExtra4 = new JPanel();
		panelExtra4.setBackground(new Color(138,149,151));

		limiteRepNormal = new JLabel("<html><body><br>Limite actual de reproducciones de un usuario normal: " + LRN + "</body></html>");
		limiteRepNormal.setForeground(Color.WHITE);
		Font font4 = limiteRepAnonimo.getFont();
		limiteRepNormal.setFont(new Font(font4.getFontName(), Font.HANGING_BASELINE, 14));
		panelExtra4.add(limiteRepNormal);
		
		
		JPanel panelExtra3 = new JPanel();
		panelExtra3.setLayout(new BoxLayout(panelExtra3, BoxLayout.X_AXIS));
		panelExtra3.setBackground(new Color(138,149,151));
		 
		lrn = new JLabel("                  Modificar limite de reproducciones de usuario normal:       ");
		lrn.setForeground(Color.BLACK);
		panelExtra3.add(lrn);
		cambiarLRN = new JTextField(5);
		cambiarLRN.setPreferredSize(new Dimension(10, 10));
		panelExtra3.add(cambiarLRN);
		hueco2 = new JLabel("  ");
		panelExtra3.add(hueco2);
		botonLRN = new JButton("  ");
		botonLRN.setIcon(imagen);
		botonLRN.setOpaque(false);
		botonLRN.setContentAreaFilled(false);
        botonLRN.setBorderPainted(false);
		panelExtra3.add(botonLRN);
		
		
		JPanel panelExtra5 = new JPanel();
		panelExtra5.setBackground(new Color(138,149,151));

		topePremium = new JLabel("<html><body><br>Tope actual de reproducciones para ser premium: " + TP + "</body></html>");
		topePremium.setForeground(Color.WHITE);
		Font font5 = topePremium.getFont();
		topePremium.setFont(new Font(font5.getFontName(), Font.HANGING_BASELINE, 14));
		panelExtra5.add(topePremium);
		
		
		JPanel panelExtra6 = new JPanel();
		panelExtra6.setLayout(new BoxLayout(panelExtra6, BoxLayout.X_AXIS));
		panelExtra6.setBackground(new Color(138,149,151));
		 
		tp = new JLabel("                  Modificar tope de reproducciones para premium:                ");
		tp.setForeground(Color.BLACK);
		panelExtra6.add(tp);
		cambiarTP = new JTextField(4);
		cambiarTP.setPreferredSize(new Dimension(10, 10));
		panelExtra6.add(cambiarTP);
		hueco3 = new JLabel("  ");
		panelExtra6.add(hueco3);
		botonTP = new JButton("  ");
		botonTP.setIcon(imagen);
		botonTP.setOpaque(false);
		botonTP.setContentAreaFilled(false);
        botonTP.setBorderPainted(false);
		panelExtra6.add(botonTP);
		
		
		JPanel panelExtra7 = new JPanel();
		panelExtra7.setBackground(new Color(138,149,151));

		costePremium = new JLabel("<html><body><br>Coste actual de la suscripcion premium: " + (int)CP + "</body></html>");
		costePremium.setForeground(Color.WHITE);
		Font font6 = costePremium.getFont();
		costePremium.setFont(new Font(font6.getFontName(), Font.HANGING_BASELINE, 14));
		panelExtra7.add(costePremium);
		
		
		JPanel panelExtra8 = new JPanel();
		panelExtra8.setLayout(new BoxLayout(panelExtra8, BoxLayout.X_AXIS));
		panelExtra8.setBackground(new Color(138,149,151));
		 
		cp = new JLabel("                  Modificar coste para suscripcion premium:                           ");
		cp.setForeground(Color.BLACK);
		panelExtra8.add(cp);
		cambiarCP = new JTextField(4);
		cambiarCP.setPreferredSize(new Dimension(10, 10));
		panelExtra8.add(cambiarCP);
		hueco4 = new JLabel("  ");
		panelExtra8.add(hueco4);
		botonCP = new JButton("  ");
		botonCP.setIcon(imagen);
		botonCP.setOpaque(false);
		botonCP.setContentAreaFilled(false);
        botonCP.setBorderPainted(false);
		panelExtra8.add(botonCP);
		
		
		panelCentro2.add(panelExtra);
		panelCentro2.add(panelExtra2);
		panelCentro2.add(panelExtra4);
		panelCentro2.add(panelExtra3);
		panelCentro2.add(panelExtra5);
		panelCentro2.add(panelExtra6);
		panelCentro2.add(panelExtra7);
		panelCentro2.add(panelExtra8);
		
		JPanel panelSur2 = new JPanel();
		panelCentro.add(panelSur2, BorderLayout.SOUTH);
		panelSur2.setPreferredSize(new Dimension(50, 40));
		panelSur2.setBackground(new Color(138,149,151));
		
		
		/**
		 *  ******************* PANEL ESTE **************************
		 */
		panelEste.setBackground(new Color(63,136,143));
		
		panelEste.setLayout(new BorderLayout());
		
		JPanel panelNorte3 = new JPanel();
		panelEste.add(panelNorte3, BorderLayout.NORTH);
		panelNorte3.setPreferredSize(new Dimension(70, 10));
		panelNorte3.setBackground(new Color(63,136,143));
		
		JPanel panelCentro7 = new JPanel();
		panelEste.add(panelCentro7, BorderLayout.CENTER);
		panelCentro7.setLayout(new BoxLayout(panelCentro7, BoxLayout.Y_AXIS));
		panelCentro7.setBackground(new Color(63,136,143));
		
		JPanel panelSur3 = new JPanel();
		panelEste.add(panelSur3, BorderLayout.SOUTH);
		panelSur3.setPreferredSize(new Dimension(70, 255));
		panelSur3.setBackground(new Color(63,136,143));
		
		
		admin = new JLabel("<html><body><br><u>Administrador:</u></body></html>");
		admin.setForeground(Color.BLACK);
		Font auxFont2 = admin.getFont();
		admin.setFont(new Font(auxFont2.getFontName(), Font.HANGING_BASELINE, 10));
		
		
		JLabel espacios2 = new JLabel("<html><body><br></body></html>");
		

		atras = new JButton("       Atras       ");
		atras.setForeground(Color.BLUE);
		Font auxFont9 = atras.getFont();
		atras.setFont(new Font(auxFont9.getFontName(), Font.ITALIC, 10));
		
		cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setForeground(Color.BLUE);
		Font auxFont4 = cerrarSesion.getFont();
		cerrarSesion.setFont(new Font(auxFont4.getFontName(), Font.ITALIC, 10));
		
		ImagenUsuario user = new ImagenUsuario("usuario.png");
		
		panelCentro7.add(user);
		panelCentro7.add(admin);
		panelCentro7.add(espacios2);
		panelCentro7.add(atras);
		panelCentro7.add(cerrarSesion);
		
		
		botonLRA.setActionCommand("LRA");
		botonLRN.setActionCommand("LRN");
		botonTP.setActionCommand("TP");
		botonCP.setActionCommand("CP");
		atras.setActionCommand("ATRAS");
		cerrarSesion.setActionCommand("LOGOUT");
		
		
		//mostrar ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	public void setControladorConfiguracion(ActionListener c) {
		botonLRA.addActionListener(c);
		botonLRN.addActionListener(c);
		botonCP.addActionListener(c);
		botonTP.addActionListener(c);
		atras.addActionListener(c);
		cerrarSesion.addActionListener(c);
		this.addWindowListener((WindowListener)c);
	}
	
	public String getLRA() {
		return cambiarLRA.getText();
	}
	
	public String getLRN() {
		return cambiarLRN.getText();
	}
	
	public String getTP() {
		return cambiarTP.getText();
	}
	
	public String getCP() {
		return cambiarCP.getText();
	}
	
}

public class Configuracion {
    public static void main(String [] args) {
        Runnable runner = new Runnable() {
            public void run() {
            	@SuppressWarnings("unused")
                final Config ventana = new Config ("Configuracion", 10, 50, 100, 27);
            }
        };
        SwingUtilities.invokeLater(runner);     
    }
}
