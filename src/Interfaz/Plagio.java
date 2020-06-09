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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;


class Plagio_pagina extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel nombreAplicacion;
	private JButton cerrarSesion;
	private JLabel administrador;
	private JLabel espacios2;
	private JButton atras;
	private JLabel titulo;
	private JTable tabla;
	private JScrollPane scroll;
	private JLabel titulo2;
	private JButton esPlagio;
	private JButton noPlagio;
	private JLabel tituloPlagio;
	private JLabel tituloNoplagio;
	private JLabel tituloId;
	private JTextField id;
	private JLabel espacios3;
	private JLabel espacios4;
	
	public Plagio_pagina(String text, String[][] filas) {
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
		
		titulo = new JLabel("<html><body><br>Revision de reportes por plagio </body></html>");
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
		
		titulo2 = new JLabel("<html><body>Selecciona el id de una cancion del sistema y elige:</body></html>");
		titulo2.setForeground(Color.WHITE);
		Font font4 = titulo2.getFont(); 
		titulo2.setFont(new Font(font4.getFontName(), Font.HANGING_BASELINE, 16));
		panelCentro4.add(titulo2);
		
		
		JPanel panelCentro5 = new JPanel();
		panelCentro5.setLayout(new BoxLayout(panelCentro5, BoxLayout.X_AXIS));
		panelCentral.add(panelCentro5);
		panelCentro5.setBackground(new Color(138,149,151));
		
		tituloPlagio = new JLabel("Es plagio: ");
		panelCentro5.add(tituloPlagio);
		
		esPlagio = new JButton("  ");
		javax.swing.ImageIcon imagen = new javax.swing.ImageIcon(getClass().getResource("ok.png"));
		esPlagio.setIcon(imagen);
		esPlagio.setOpaque(false);
		esPlagio.setContentAreaFilled(false);
		esPlagio.setBorderPainted(false);
		panelCentro5.add(esPlagio);
		
		tituloNoplagio = new JLabel("No es plagio: ");
		panelCentro5.add(tituloNoplagio);
		
		noPlagio = new JButton("  ");
		javax.swing.ImageIcon imagen3 = new javax.swing.ImageIcon(getClass().getResource("notok.png"));
		noPlagio.setIcon(imagen3);
		noPlagio.setOpaque(false);
		noPlagio.setContentAreaFilled(false);
		noPlagio.setBorderPainted(false);
		panelCentro5.add(noPlagio);
		
		
		JPanel panelCentro6 = new JPanel();
		panelCentro6.setLayout(new BoxLayout(panelCentro6, BoxLayout.X_AXIS));
		panelCentral.add(panelCentro6);
		panelCentro6.setBackground(new Color(138,149,151));
		
		espacios3 = new JLabel("                                       ");
		panelCentro6.add(espacios3);
		
		tituloId = new JLabel("Introduce el ID de la notificacion de reporte (OBLIGATORIO):     ");
		panelCentro6.add(tituloId);
		
		id = new JTextField(4);
		id.setPreferredSize(new Dimension(10, 10));
		panelCentro6.add(id);
		
		espacios4 = new JLabel("                                                            ");
		panelCentro6.add(espacios4);
		
		JPanel panelCentro2 = new JPanel();
		panelCentral.add(panelCentro2);
		panelCentro2.setBackground(new Color(138,149,151));
		
		String[] tablas = {"Id", "Autor", "Cancion", "Estado"};		
		tabla = new JTable(filas, tablas);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setPreferredScrollableViewportSize(new Dimension(680, 470));
	    DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.setBackground(new Color(133, 193, 233));
		tabla.getColumnModel().getColumn(0).setCellRenderer(alinearCentro);
		tabla.getColumnModel().getColumn(1).setCellRenderer(alinearCentro);
		tabla.getColumnModel().getColumn(2).setCellRenderer(alinearCentro);
		tabla.getColumnModel().getColumn(3).setCellRenderer(alinearCentro);
		scroll = new JScrollPane(tabla);
		panelCentro2.add(scroll);
		
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
		
		administrador = new JLabel("<html><body><br><u>Administrador:</u></body></html>");
		administrador.setForeground(Color.BLACK);
		Font font3 = administrador.getFont();
		administrador.setFont(new Font(font3.getFontName(), Font.HANGING_BASELINE, 10));
		
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
		panelCentro3.add(administrador);
		panelCentro3.add(espacios2);
		panelCentro3.add(atras);
		panelCentro3.add(cerrarSesion);
		
		esPlagio.setActionCommand("PLAGIO");
		noPlagio.setActionCommand("NOPLAGIO");
		atras.setActionCommand("ATRAS");
		cerrarSesion.setActionCommand("LOGOUT");
		
		//mostrar ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void setControladorPlagio(ActionListener c) {
		esPlagio.addActionListener(c);
		noPlagio.addActionListener(c);
		atras.addActionListener(c);
		cerrarSesion.addActionListener(c);
		this.addWindowListener((WindowListener)c);
	}
	
	public String getId() {
		return id.getText();
	}
		
	String getValorTupla() {
		int col = tabla.getSelectedColumn();
		int row = tabla.getSelectedRow();
		return (String) tabla.getValueAt(row, col);
	}
	
}

/**
public class Plagio {

    public static void main(String [] args) {
        Runnable runner = new Runnable() {
            public void run() {
            	String[][] prueba = {{"0", "Pepe", "Hola Mundo", "EN_ESPERA"}, {"1", "Miguel", "Hey", "H"}, {"2", "Mateo", "Sad", "H"}, {"3", "Franccy", "Activos", "H"}};
            	@SuppressWarnings("unused")
                final Plagio_pagina ventana = new Plagio_pagina("Validacion", prueba);
            }
        };
        SwingUtilities.invokeLater(runner);     
    }
	
}*/