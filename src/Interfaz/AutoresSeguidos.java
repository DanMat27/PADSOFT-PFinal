package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;


class AutorSiguea extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel nombreAplicacion;
	private JLabel espacios;
	private JButton seguidores;
	private JPanel panelCentral1;
	private JTable tabla;
	private JScrollPane scroll;
	private JButton volver;
	private JButton cerrarSesion;
	private JButton dejarSeguir;
	public AutorSiguea(String text, boolean admin, String[][] filas) {
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
		 **********************PANEL OESTE****************
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


		seguidores = new JButton("Buscar Personas");
		seguidores.setForeground(Color.BLUE);
		Font auxFont7 = seguidores.getFont();
		seguidores.setFont(new Font(auxFont7.getFontName(), Font.ITALIC, 10));
		
		
		volver = new JButton("Menu Usuario      ");
		volver.setForeground(Color.BLUE);
		Font auxFont3 = volver.getFont();
		volver.setFont(new Font(auxFont3.getFontName(), Font.ITALIC, 10));
		
		cerrarSesion = new JButton("Cerrar Sesion      ");
		cerrarSesion.setForeground(Color.BLUE);
		Font auxFont4 = cerrarSesion.getFont();
		cerrarSesion.setFont(new Font(auxFont4.getFontName(), Font.ITALIC, 10));
		
		dejarSeguir = new JButton("Dejar de Seguir    ");
		dejarSeguir.setForeground(Color.BLUE);
		Font auxFont5 = dejarSeguir.getFont();
		dejarSeguir.setFont(new Font(auxFont5.getFontName(), Font.ITALIC, 10));
		
		panelCentro4.add(espacios);
		panelCentro4.add(seguidores);
		panelCentro4.add(volver);
		panelCentro4.add(cerrarSesion);
		panelCentro4.add(dejarSeguir);
		/**
		 * PANEL CENTRO
		 */

		panelCentro.setBackground(new Color(138,149,151));

		panelCentral1 = new JPanel();
		String[] tablas = {"Nickname del Usuario"};		
		tabla = new JTable(filas, tablas);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setPreferredScrollableViewportSize(new Dimension(680, 470));
	    DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.setBackground(new Color(133, 193, 233));
		tabla.getColumnModel().getColumn(0).setCellRenderer(alinearCentro);
		//tabla.getColumnModel().getColumn(1).setCellRenderer(alinearCentro);
		scroll = new JScrollPane(tabla);
		panelCentral1.add(scroll);
		
		panelCentro.add(panelCentral1);


		this.seguidores.setActionCommand("SEGUIR");
		this.volver.setActionCommand("vuelve");
		this.cerrarSesion.setActionCommand("CerrarSesioon");
		this.dejarSeguir.setActionCommand("DEJAR");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

	}
	public void setControladorAutoresSeguidos(ActionListener c) {
		seguidores.addActionListener(c);
		volver.addActionListener(c);
		cerrarSesion.addActionListener(c);
		dejarSeguir.addActionListener(c);
		this.addWindowListener((WindowListener)c);
	}
}
/**
public class AutoresSeguidos {
	public static void main(String [] args) {
		Runnable runner = new Runnable() {
			public void run() {
				String[][] prueba = {{"Pepe"}, {"Miguel",}, {"Mateo"}, {"Franccy"}};
				@SuppressWarnings("unused")
				final AutorSiguea ventana = new AutorSiguea ("Pagina Principal", false, prueba);
			}
		};
		SwingUtilities.invokeLater(runner);     
	}
}*/
