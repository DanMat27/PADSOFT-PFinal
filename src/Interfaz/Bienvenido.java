package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;


class Inicio extends JFrame{
	private JLabel nombreAplicacion;
	private JButton canciones;
	private JButton autores;
	private JButton albumes;
	private JButton listas;
	private JLabel espacios;
	private JLabel Busqueda;
	private JButton busquedaxautor;
	private JButton busquedaxcancion;
	private JButton busquedaxMiscanciones;
	private JLabel usuario;
	private JButton misNotificaciones;
	private JButton cerrarSesion;
	private JButton premium;
	private JPanel panelSur2;
	private JPanel panelCentro;
	private JButton subirCancion;
	private JButton crearalbum;
	private static final long serialVersionUID = 1L;

	public Inicio(String text) {
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
		 * *****************PANEL CENTRAL********************************
		 */
		 
		panelCentro.setBackground(new Color(138,149,151));
		
		
		/*JLabel BienvenidaUsuario = new JLabel("<html><body>Bienvenido #USUARIO#<br><br><br<<br></body></html>");
		BienvenidaUsuario.setForeground(Color.WHITE);
		Font font = BienvenidaUsuario.getFont();
		BienvenidaUsuario.setFont(new Font(font.getFontName(), Font.ROMAN_BASELINE, 70));
		*/
		
		panelCentro.setLayout(new BorderLayout());
		
		JPanel panelNorte2 = new JPanel();
		panelCentro.add(panelNorte2, BorderLayout.NORTH);
		panelNorte2.setPreferredSize(new Dimension(30, 30));
		panelNorte2.setBackground(new Color(138,149,151));
		
		JPanel panelEste2 = new JPanel();
		panelCentro.add(panelEste2, BorderLayout.EAST);
		panelEste2.setPreferredSize(new Dimension(30, 30));
		panelEste2.setBackground(new Color(138,149,151));
		
		JPanel panelOeste2 = new JPanel();
		panelCentro.add(panelOeste2, BorderLayout.WEST);
		panelOeste2.setPreferredSize(new Dimension(30, 30));
		panelOeste2.setBackground(new Color(138,149,151));
		
		panelSur2 = new JPanel();
		panelCentro.add(panelSur2, BorderLayout.SOUTH);
		panelSur2.setPreferredSize(new Dimension(30, 30));
		premium = new JButton("¡¡¡Hazte Premium!!!");
		premium.setBackground(Color.YELLOW);
		premium.setPreferredSize(new Dimension(220,15));
		panelSur2.add(premium);
		panelSur2.setBackground(new Color(138,149,151));
		
		JPanel panelPrueba = new JPanel();
		panelCentro.add(panelPrueba, BorderLayout.CENTER);
		panelPrueba.setLayout(new GridLayout(2, 2));
		
		
		canciones = new JButton("<html><center><font color=#FFFFFF>Lista de Canciones</font></body></html>");
		canciones.setBackground(new Color(133, 193, 233));
		canciones.setPreferredSize(new Dimension(120,120));
		
		autores = new JButton("<html><center><font color=#FFFFFF>Autores Seguidos</font></body></html>");
		autores.setBackground(new Color(40, 116, 166));
		autores.setPreferredSize(new Dimension(120,120));
		
		albumes = new JButton("<html><center><font color=#FFFFFF>Albumes</font></body></html>");
		albumes.setBackground(new Color(0, 0, 128));
		albumes.setPreferredSize(new Dimension(120,120));
		
		listas = new JButton("<html><center><font color=#FFFFFF>Lista de Reproduccion</font></body></html>");
		listas.setBackground(Color.BLUE);
		listas.setPreferredSize(new Dimension(120,120));
		
		/*panelCentro.add(BienvenidaUsuario);*/
		
		panelPrueba.add(canciones);
		panelPrueba.add(autores);
		panelPrueba.add(albumes);
		panelPrueba.add(listas);
		
		/**
		 * ***************** PANEL OESTE *******************
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
		
		Busqueda = new JLabel("<html><body><br><u>Busqueda:</u></body></html>");
		Busqueda.setForeground(Color.BLACK);
		Font auxFont5 = Busqueda.getFont();
		Busqueda.setFont(new Font(auxFont5.getFontName(), Font.HANGING_BASELINE, 10));
		
		busquedaxautor = new JButton("Por Autor        ");
		busquedaxautor.setForeground(Color.BLUE);
		Font auxFont6 = busquedaxautor.getFont();
		busquedaxautor.setFont(new Font(auxFont6.getFontName(), Font.ITALIC, 10));
		
		busquedaxcancion = new JButton("Por Cancion    ");
		busquedaxcancion.setForeground(Color.BLUE);
		Font auxFont7 = busquedaxcancion.getFont();
		busquedaxcancion.setFont(new Font(auxFont7.getFontName(), Font.ITALIC, 10));
		
		busquedaxMiscanciones = new JButton("Mis Canciones");
		busquedaxMiscanciones.setForeground(Color.BLUE);
		Font auxFont8 = busquedaxMiscanciones.getFont();
		busquedaxMiscanciones.setFont(new Font(auxFont8.getFontName(), Font.ITALIC, 10));
		
		panelCentro4.add(Busqueda);
		panelCentro4.add(espacios);
		panelCentro4.add(busquedaxautor);
		panelCentro4.add(busquedaxcancion);
		panelCentro4.add(busquedaxMiscanciones);
		
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
		panelSur3.setPreferredSize(new Dimension(70, 210));
		panelSur3.setBackground(new Color(63,136,143));
		
		
		usuario = new JLabel("<html><body><br><u>Usuario:</u></body></html>");
		usuario.setForeground(Color.BLACK);
		Font auxFont2 = usuario.getFont();
		usuario.setFont(new Font(auxFont2.getFontName(), Font.HANGING_BASELINE, 10));
		

		
		JLabel espacios2 = new JLabel("<html><body><br></body></html>");
		
		subirCancion = new JButton("Subir Cancion");
		subirCancion.setForeground(Color.BLUE);
		Font auxFont10 = subirCancion.getFont();
		subirCancion.setFont(new Font(auxFont10.getFontName(), Font.ITALIC, 10));
		
		misNotificaciones = new JButton("Notificaciones");
		misNotificaciones.setForeground(Color.BLUE);
		Font auxFont9 = misNotificaciones.getFont();
		misNotificaciones.setFont(new Font(auxFont9.getFontName(), Font.ITALIC, 10));
		
		cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setForeground(Color.BLUE);
		Font auxFont4 = cerrarSesion.getFont();
		cerrarSesion.setFont(new Font(auxFont4.getFontName(), Font.ITALIC, 10));
		
		crearalbum = new JButton("Crear Album   ");
		crearalbum.setForeground(Color.BLUE);
		Font auxFont11 = crearalbum.getFont();
		crearalbum.setFont(new Font(auxFont11.getFontName(), Font.ITALIC, 10));
		
		ImagenUsuario user = new ImagenUsuario("usuario.png");
		
		panelCentro3.add(user);
		/*panelCentro3.add(comboopciones);*/
		panelCentro3.add(usuario);
		panelCentro3.add(espacios2);
		panelCentro3.add(subirCancion);
		panelCentro3.add(misNotificaciones);
		panelCentro3.add(crearalbum);
		panelCentro3.add(cerrarSesion);
		
		this.autores.setActionCommand("AutoresSeguidos");
		this.canciones.setActionCommand("ListaDeCanciones");
		this.albumes.setActionCommand("Albumes");
		this.listas.setActionCommand("ListaDeReproduccion");
		this.busquedaxautor.setActionCommand("BusquedaxAutor");
		this.busquedaxcancion.setActionCommand("BusquedaxCancion");
		this.busquedaxMiscanciones.setActionCommand("BusquedaxMisCanciones");
		this.misNotificaciones.setActionCommand("NOTIF");
		this.cerrarSesion.setActionCommand("CerrarSesion");
		this.premium.setActionCommand("Prem");
		this.subirCancion.setActionCommand("SUBIR");
		this.crearalbum.setActionCommand("album");
		this.canciones.setActionCommand("MisCanciones");
		this.albumes.setActionCommand("MisAlbumes");
		this.listas.setActionCommand("MisListas");
		
		//mostrar ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void getPanelCambio() {
		this.panelSur2.setVisible(false);
		JPanel pan = new JPanel();
		pan.setPreferredSize(new Dimension(30, 30));
		pan.setBackground(new Color(138,149,151));
		this.panelCentro.add(pan,BorderLayout.SOUTH);
	}


	public void setControladorBienvenido(ActionListener c) {
		cerrarSesion.addActionListener(c);
		premium.addActionListener(c);
		misNotificaciones.addActionListener(c);
		subirCancion.addActionListener(c);
		busquedaxautor.addActionListener(c);
		busquedaxcancion.addActionListener(c);
		autores.addActionListener(c);
		crearalbum.addActionListener(c);
		canciones.addActionListener(c);
		albumes.addActionListener(c);
		listas.addActionListener(c);
		this.addWindowListener((WindowListener)c);
	}


}
