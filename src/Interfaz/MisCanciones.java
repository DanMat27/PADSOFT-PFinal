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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;


	
class Canciones extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel nombreAplicacion;
	private JButton cerrarSesion;
	private JLabel usuario;
	private JLabel espacios2;
	private JButton atras;
	private JLabel titulo;
	private JTable tabla;
	private JScrollPane scroll;
	private JLabel reproducciones;
	private JButton modificar;
	private JLabel premium;
	
	public Canciones(String text, String[][] filas, int numReproducciones, int prem) {
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
		//panelNorte2.setBackground(new Color(133, 193, 233));
		
		titulo = new JLabel("<html><body><br>Lista de tus canciones:</body></html>");
		titulo.setForeground(Color.WHITE);
		Font font2 = titulo.getFont();
		titulo.setFont(new Font(font2.getFontName(), Font.HANGING_BASELINE, 18));
		panelNorte2.add(titulo);
		
		JPanel panelCentro2 = new JPanel();
		panelCentro.add(panelCentro2, BorderLayout.CENTER);
		//panelCentro2.setPreferredSize(new Dimension(200, 65));
		panelCentro2.setBackground(new Color(138,149,151));
		
		String[] tablas = {"Cancion", "Estado", "Reproducciones"};		
		tabla = new JTable(filas, tablas);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setPreferredScrollableViewportSize(new Dimension(680, 470));
	    DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.setBackground(new Color(133, 193, 233));
		tabla.getColumnModel().getColumn(0).setCellRenderer(alinearCentro);
		tabla.getColumnModel().getColumn(1).setCellRenderer(alinearCentro);
		tabla.getColumnModel().getColumn(2).setCellRenderer(alinearCentro);
		scroll = new JScrollPane(tabla);
		panelCentro2.add(scroll);
		
		JPanel panelSur2 = new JPanel();
		panelCentro.add(panelSur2, BorderLayout.SOUTH);
		panelSur2.setLayout(new BoxLayout(panelSur2, BoxLayout.X_AXIS));
		panelSur2.setBackground(new Color(138,149,151));
		
		modificar = new JButton("Modificar Cancion");
		modificar.setForeground(Color.BLUE);
		Font auxFont5 = modificar.getFont();
		modificar.setFont(new Font(auxFont5.getFontName(), Font.ITALIC, 10));
		
		reproducciones = new JLabel("     Reproducciones totales: " + numReproducciones + "                    ");
		
		premium = new JLabel("          Reproducciones necesarias para ser premium: "+ prem);
		/*reproducciones = new JLabel("                                                 Reproducciones totales: " + numReproducciones);
		*/
		panelSur2.add(reproducciones);
		panelSur2.add(modificar);
		panelSur2.add(premium);
		
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
		Font auxFont2 = usuario.getFont();
		usuario.setFont(new Font(auxFont2.getFontName(), Font.HANGING_BASELINE, 10));
		
		
		
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
		
		cerrarSesion.setActionCommand("LOGOUT");
		atras.setActionCommand("ATRAS");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void setControladorCanciones(ActionListener c) {
		cerrarSesion.addActionListener(c);
		atras.addActionListener(c);
		this.addWindowListener((WindowListener)c);
	}
		
}
