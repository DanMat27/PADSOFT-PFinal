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

class Seguir extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel nombreAplicacion;
	private JLabel espacios;
	private JLabel opciones;
	private JButton volver;
	private JButton cerrarSesion;
	private JLabel textoIntroducir;
	private JLabel textoUsuario;
	private JTextField user1;
	private JButton botonSeguir;
	private JButton volverSeguir;
	public Seguir(String text) {
	super(text);
	JPanel  panelNorte =  new JPanel();
	JPanel  panelCentro = new JPanel();
	 JPanel panelOeste =  new JPanel();
	 
	 this.add(panelNorte,BorderLayout.NORTH);
		//ventana.add(panelOeste,BorderLayout.WEST);
		//ventana.add(panelEste,BorderLayout.EAST);
		this.add(panelCentro,BorderLayout.CENTER);
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
		 * PANEL OESTE
		 */
panelOeste.setBackground(new Color(63,136,143));
		
		JPanel panelNorte4 = new JPanel();
		panelOeste.add(panelNorte4, BorderLayout.NORTH);
		panelNorte4.setPreferredSize(new Dimension(10, 10));
		panelNorte4.setBackground(new Color(63,136,143));
		
		espacios = new JLabel("<html><body><br></body></html>");
		
		JPanel panelCentro4 = new JPanel();
		panelOeste.add(panelCentro4, BorderLayout.SOUTH);
		panelCentro4.setLayout(new BoxLayout(panelCentro4, BoxLayout.Y_AXIS));
		panelCentro4.setBackground(new Color(63,136,143));
		
		opciones = new JLabel("<html><body><br><u>Opciones:</u></body></html>");
		opciones.setForeground(Color.BLACK);
		Font auxFont5 = opciones.getFont();
		opciones.setFont(new Font(auxFont5.getFontName(), Font.HANGING_BASELINE, 10));
		
		volver = new JButton("Menu Usuario");
		volver.setForeground(Color.BLUE);
		Font auxFont3 = nombreAplicacion.getFont();
		volver.setFont(new Font(auxFont3.getFontName(), Font.ITALIC, 10));
		
		cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setForeground(Color.BLUE);
		Font auxFont4 = cerrarSesion.getFont();
		cerrarSesion.setFont(new Font(auxFont4.getFontName(), Font.ITALIC, 10));
		
		volverSeguir = new JButton("Volver");
		volverSeguir.setForeground(Color.BLUE);
		Font auxFont6 = volverSeguir.getFont();
		volverSeguir.setFont(new Font(auxFont6.getFontName(), Font.ITALIC, 10));
		
		panelCentro4.add(opciones);
		panelCentro4.add(espacios);
		panelCentro4.add(volver);
		panelCentro4.add(cerrarSesion);
		panelCentro4.add(volverSeguir);
		
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
		textoIntroducir = new JLabel("Introduce el autor a seguir");
		
		textoUsuario = new JLabel("Nickame Usuario: ");
		user1 = new JTextField(8);
		
		botonSeguir = new JButton("Seguir Usuario");
		
		panelextra.setBackground(new Color(129,216,208));
		panelextra1.setBackground(new Color(129,216,208));
		panelextra2.setBackground(new Color(129,216,208));
		panelextra3.setBackground(new Color(129,216,208));
		panelextra4.setBackground(new Color(129,216,208));
		panelextra5.setBackground(new Color(129,216,208));
		panelextra6.setBackground(new Color(129,216,208));
		panelextra7.setBackground(new Color(129,216,208));
		
		panelextra2.add(textoIntroducir);
		
		panelextra.add(textoUsuario);
		panelextra.add(user1);
		
		panelextra1.add(botonSeguir);
		
		panelCentro.add(panelextra2);
		panelCentro.add(panelextra);
		panelCentro.add(panelextra1);
		panelCentro.add(panelextra4);
		panelCentro.add(panelextra5);
		panelCentro.add(panelextra3);
		panelCentro.add(panelextra6);
		panelCentro.add(panelextra7);
		
		this.volver.setActionCommand("vuelve");
		this.cerrarSesion.setActionCommand("CerrarSesioon");
		this.botonSeguir.setActionCommand("SEGUIRAPERSONA");
		this.volverSeguir.setActionCommand("VOLVER");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(401,401);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void setControladorSeguirPersonas(ActionListener c) {
		cerrarSesion.addActionListener(c);
		volver.addActionListener(c);
		botonSeguir.addActionListener(c);
		volverSeguir.addActionListener(c);
		this.addWindowListener((WindowListener)c);
	}
	public String getNombreAutor() {
		return user1.getText();
	}
}

/**
public class SeguirPersonas {
    public static void main(String [] args) {
        Runnable runner = new Runnable() {
            public void run() {
            	String[][] prueba = {{"0", "Pepe", "Hola Mundo"}, {"1", "Miguel",}, {"2", "Mateo"}, {"3", "Franccy"}};
            	@SuppressWarnings("unused")
                final Seguir ventana = new Seguir ("Pagina Principal", false, prueba);
            }
        };
        SwingUtilities.invokeLater(runner);     
    }
}*/
