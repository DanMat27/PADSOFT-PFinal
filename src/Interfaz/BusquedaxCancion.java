package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

class BuscarxCancion extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel nombreAplicacion;
	private JLabel usuario;
	private JLabel anonimo;
	private JLabel admin;
	private JButton volver;
	private JButton cerrarSesion;
	private JLabel eleccion;
	private JRadioButton opcion1;
	private JRadioButton opcion2;
	private JTextField escribir;
	private JLabel buscar;
	private JButton botonbuscar;
	private JLabel espacios;
	private JLabel Busqueda;
	private JButton busquedaxautor;
	private JTable tabla;
	private JScrollPane scroll;
	JPanel panelCentro1;
	JPanel panelCentro;
	JPanel panelauxiliar;
	JPanel panelauxiliar2;
	public BuscarxCancion(String text, int opc, String[][] filas) {
		super(text);
		JPanel panelNorte = new JPanel();
		  panelCentro = new JPanel();
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
		 * ******************** PANEL CENTRO ************************
		 */
		panelCentro.setBackground(new Color(138,149,151));
		panelCentro.setLayout(new BorderLayout());
		JPanel panelCentroNorte = new JPanel();
		JPanel panelCentroNorte1 = new JPanel();
		JPanel panelCentroNorte2 = new JPanel();
		panelCentro1 = new JPanel();
		panelCentroNorte.setLayout(new BorderLayout());
		//panelCentroNorte.setPreferredSize(new Dimension(30, 10));
		eleccion = new JLabel("Elige una opcion: ");
		opcion1 = new JRadioButton("Buscar por cancion");
		opcion2 = new JRadioButton("Buscar por album");
		opcion1.setSelected(true);
		buscar = new JLabel("Realizar busqueda: ");
		botonbuscar = new JButton("Buscar");
		ButtonGroup asociar = new ButtonGroup();
		escribir = new JTextField(7);
		asociar.add(opcion1);
		asociar.add(opcion2);
		
		JPanel ppalbutton = new JPanel(new GridLayout(1,2)); 
		ppalbutton.add(opcion1);
		ppalbutton.add(opcion2);
		
		panelCentroNorte1.add(buscar);
		panelCentroNorte1.add(escribir);
		panelCentroNorte1.add(botonbuscar);
		panelCentroNorte2.add(eleccion);
		panelCentroNorte2.add(ppalbutton);
		panelCentroNorte.add(panelCentroNorte1,BorderLayout.NORTH);
		panelCentroNorte.add(panelCentroNorte2,BorderLayout.CENTER);
		panelCentro.add(panelCentroNorte,BorderLayout.NORTH);
		panelCentro.add(panelCentro1,BorderLayout.CENTER);

		panelCentroNorte.setBackground(Color.RED);
		panelCentro1.setBackground(Color.BLACK);
		
		
		String[] tablas = {"Autor", "Cancion"};		
		tabla = new JTable(filas, tablas);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setPreferredScrollableViewportSize(new Dimension(680, 470));
	    DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.setBackground(new Color(133, 193, 233));
		tabla.getColumnModel().getColumn(0).setCellRenderer(alinearCentro);
		tabla.getColumnModel().getColumn(1).setCellRenderer(alinearCentro);
		//tabla.getColumnModel().getColumn(2).setCellRenderer(alinearCentro);
		scroll = new JScrollPane(tabla);
		panelCentro1.add(scroll);
		
		
		
		
		/**
		 *  ******************* PANEL ESTE **************************
		 */
		panelEste.setBackground(new Color(63,136,143));
		
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
		panelSur3.setPreferredSize(new Dimension(70, 400));
		panelSur3.setBackground(new Color(63,136,143));
		
		/*JPanel panelPrueba2 = new JPanel();
		panelPrueba2.setLayout(new GridLayout(1,1));
		panelEste.add(panelPrueba2, BorderLayout.CENTER);*/
		
		usuario = new JLabel("<html><body><br><u>Usuario:</u></body></html>");
		usuario.setForeground(Color.BLACK);
		Font auxFont2 = usuario.getFont();
		usuario.setFont(new Font(auxFont2.getFontName(), Font.HANGING_BASELINE, 10));
		
		admin = new JLabel("<html><body><br><u>Administrador:</u></body></html>");
		admin.setForeground(Color.BLACK);
		Font auxFont7 = admin.getFont();
		admin.setFont(new Font(auxFont7.getFontName(), Font.HANGING_BASELINE, 10));
		
		anonimo = new JLabel("<html><body><br><u>Anonimo:</u></body></html>");
		anonimo.setForeground(Color.BLACK);
		Font auxFont8 = anonimo.getFont();
		anonimo.setFont(new Font(auxFont8.getFontName(), Font.HANGING_BASELINE, 10));
		
		
		JLabel espacios2 = new JLabel("<html><body><br></body></html>");
		
		volver = new JButton("Menu Usuario");
		volver.setForeground(Color.BLUE);
		Font auxFont3 = nombreAplicacion.getFont();
		volver.setFont(new Font(auxFont3.getFontName(), Font.ITALIC, 10));
		
		cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setForeground(Color.BLUE);
		Font auxFont4 = cerrarSesion.getFont();
		cerrarSesion.setFont(new Font(auxFont4.getFontName(), Font.ITALIC, 10));		
		
		ImagenUsuario user = new ImagenUsuario("usuario.png");
		
		panelCentro3.add(user);
		if(opc==0) {
			panelCentro3.add(usuario);
		}
		else if(opc==1){
			panelCentro3.add(admin);
		}
		else if(opc==2){
			panelCentro3.add(anonimo);
		}
		panelCentro3.add(espacios2);
		panelCentro3.add(volver);
		panelCentro3.add(cerrarSesion);
		
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
		
		Busqueda = new JLabel("<html><body><br><u>Busqueda:</u></body></html>");
		Busqueda.setForeground(Color.BLACK);
		Font auxFont5 = Busqueda.getFont();
		Busqueda.setFont(new Font(auxFont5.getFontName(), Font.HANGING_BASELINE, 10));
		
		busquedaxautor = new JButton("Por Autor    ");
		busquedaxautor.setForeground(Color.BLUE);
		Font auxFont9 = busquedaxautor.getFont();
		busquedaxautor.setFont(new Font(auxFont9.getFontName(), Font.ITALIC, 10));
		
		
		panelCentro4.add(Busqueda);
		panelCentro4.add(espacios);
		panelCentro4.add(busquedaxautor);
		
		
		this.volver.setActionCommand("vuelve");
		this.cerrarSesion.setActionCommand("CerrarSesioon");
		this.opcion1.setActionCommand("BUSCACANCION");
		this.botonbuscar.setActionCommand("BUSCAR");
		this.opcion2.setActionCommand("BUSCAAUTOR");
		this.busquedaxautor.setActionCommand("CAMBIOPANTALLA");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	public void setControladorBusquedaCancion(ActionListener c) {
		cerrarSesion.addActionListener(c);
		volver.addActionListener(c);
		opcion1.addActionListener(c);
		botonbuscar.addActionListener(c);
		opcion2.addActionListener(c);
		busquedaxautor.addActionListener(c);
		this.addWindowListener((WindowListener)c);
	}
	public String getBusqueda() {
		return escribir.getText();
	}
	public boolean opcion1elegida() {
		if (opcion1.isSelected()) {
			return true;
		}
		return false;
	}
	
	public boolean opcion2elegida() {
		if (opcion2.isSelected()) {
			return true;
		}
		return false;
	}
	
	public void CambiarPanelCentral(String[][] filas) {
		String[] tablas = {"Autor", "Cancion"};
		panelCentro1.setVisible(false);
		panelauxiliar = new JPanel();
		panelauxiliar.setVisible(false);
		tabla = new JTable(filas, tablas);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setPreferredScrollableViewportSize(new Dimension(680, 470));
	    DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.setBackground(new Color(133, 193, 233));
		tabla.getColumnModel().getColumn(0).setCellRenderer(alinearCentro);
		tabla.getColumnModel().getColumn(1).setCellRenderer(alinearCentro);
		//tabla.getColumnModel().getColumn(2).setCellRenderer(alinearCentro);
		scroll = new JScrollPane(tabla);
		panelCentro.add(panelauxiliar,BorderLayout.CENTER);
		panelauxiliar.setVisible(true);
		panelauxiliar.add(scroll);
	}
	public void CambiarPanelCentral2(String[][]filas) {
		String[] tablas = {"Autor", "Album"};
		panelCentro1.setVisible(false);
		panelauxiliar2 = new JPanel();
		panelauxiliar2.setVisible(false);
		tabla = new JTable(filas, tablas);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setPreferredScrollableViewportSize(new Dimension(680, 470));
	    DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.setBackground(new Color(133, 193, 233));
		tabla.getColumnModel().getColumn(0).setCellRenderer(alinearCentro);
		tabla.getColumnModel().getColumn(1).setCellRenderer(alinearCentro);
		//tabla.getColumnModel().getColumn(2).setCellRenderer(alinearCentro);
		scroll = new JScrollPane(tabla);
		panelCentro.add(panelauxiliar2,BorderLayout.CENTER);
		panelauxiliar2.setVisible(true);
		panelauxiliar2.add(scroll);
	}
}

/**public class BusquedaxCancion {
    public static void main(String [] args) {
        Runnable runner = new Runnable() {
            public void run() {
            	String[][] prueba = {{"0", "Pepe", "Hola Mundo"}, {"1", "Miguel",}, {"2", "Mateo"}, {"3", "Franccy"}};
            	@SuppressWarnings("unused")
                final BuscarxCancion ventana = new BuscarxCancion ("Pagina Principal", false, prueba);
            }
        };
        SwingUtilities.invokeLater(runner);     
    }
}*/
