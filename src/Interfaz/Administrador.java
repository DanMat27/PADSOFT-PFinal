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
import javax.swing.SwingUtilities;

	class Admin_principal extends JFrame{
		
		private JLabel nombreAplicacion;
		
		private JButton validar;
		private JButton plagio;
		private JButton config;
		private JLabel admin;
		private JButton misNotificaciones;
		private JButton cerrarSesion;
		private JButton autores;
		private JLabel espacios;
		private JLabel Busqueda;
		private JButton busquedaxautor;
		private JButton busquedaxcancion;
		private JLabel espacios3; 
		private JLabel espacios4;
		private JLabel espacios5;
		
		public Admin_principal(String text) {
			super(text);
			JPanel panelNorte = new JPanel();
			JPanel panelCentro = new JPanel();
			JPanel panelEste = new JPanel();
			JPanel panelOeste = new JPanel();
			
			/**
			 * Introducimos nuestros paneles en el contenedor
			 */
			this.add(panelNorte,BorderLayout.NORTH);
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
			panelNorte.add(nombreAplicacion);
			
			/**
			 * *****************PANEL CENTRAL********************************
			 */
			panelCentro.setBackground(new Color(138,149,151));
			
			panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
			
			JPanel panelCentro1 = new JPanel();
			JPanel panelCentro2 = new JPanel();
			JPanel panelCentro3 = new JPanel();
			
			espacios3 = new JLabel("<html><body><br><br><br><br><br><br><br></body></html>");
			espacios4 = new JLabel("<html><body><br><br><br><br><br><br><br><br></body></html>");
			espacios5 = new JLabel("<html><body><br><br><br><br><br><br><br></body></html>");
			
			validar = new JButton("Validar Cancion");
			validar.setPreferredSize(new Dimension(200, 50));
			//validar.setBackground(new Color(23, 59, 238));
			validar.setForeground(new Color(23, 59, 238));
			plagio = new JButton("Revisar Plagio");
			plagio.setPreferredSize(new Dimension(200, 50));
			//plagio.setBackground(new Color(33, 30, 200));
			plagio.setForeground(new Color(23, 59, 238));
			config = new JButton("Cambiar Configuracion");
			config.setPreferredSize(new Dimension(200, 50));
			//config.setBackground(new Color(65, 241, 252));
			config.setForeground(new Color(23, 59, 238));
			
			panelCentro1.add(espacios3);
			panelCentro1.add(validar);
			panelCentro2.add(espacios4);
			panelCentro2.add(plagio);
			panelCentro3.add(espacios5);
			panelCentro3.add(config);
			
			panelCentro1.setBackground(new Color(138,149,151));
			panelCentro2.setBackground(new Color(138,149,151));
			panelCentro3.setBackground(new Color(138,149,151));
			panelCentro.add(panelCentro1);
			panelCentro.add(panelCentro2);
			panelCentro.add(panelCentro3);
			
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
			
			
			panelCentro4.add(Busqueda);
			panelCentro4.add(espacios);
			panelCentro4.add(busquedaxautor);
			panelCentro4.add(busquedaxcancion);
			
			
			/**
			 *  ******************* PANEL ESTE **************************
			 */
			panelEste.setBackground(new Color(63,136,143));
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
			panelSur3.setPreferredSize(new Dimension(70, 235));
			panelSur3.setBackground(new Color(63,136,143));
			
			
			admin = new JLabel("<html><body><br><u>Administrador:</u></body></html>");
			admin.setForeground(Color.BLACK);
			Font auxFont2 = admin.getFont();
			admin.setFont(new Font(auxFont2.getFontName(), Font.HANGING_BASELINE, 10));
			
			
			JLabel espacios2 = new JLabel("<html><body><br></body></html>");
			

			misNotificaciones = new JButton("Notificaciones");
			misNotificaciones.setForeground(Color.BLUE);
			Font auxFont9 = misNotificaciones.getFont();
			misNotificaciones.setFont(new Font(auxFont9.getFontName(), Font.ITALIC, 10));
			
			cerrarSesion = new JButton("Cerrar Sesion");
			cerrarSesion.setForeground(Color.BLUE);
			Font auxFont4 = cerrarSesion.getFont();
			cerrarSesion.setFont(new Font(auxFont4.getFontName(), Font.ITALIC, 10));
			
			autores = new JButton("     Autores     ");
			autores.setForeground(Color.BLUE);
			Font auxFont10 = autores.getFont();
			autores.setFont(new Font(auxFont10.getFontName(), Font.ITALIC, 10));
			
			ImagenUsuario user = new ImagenUsuario("usuario.png");
			 
			panelCentro7.add(user);
			panelCentro7.add(admin);
			panelCentro7.add(espacios2);
			panelCentro7.add(autores);
			panelCentro7.add(misNotificaciones);
			panelCentro7.add(cerrarSesion);
			
	
			this.cerrarSesion.setActionCommand("LOGOUT");
			this.validar.setActionCommand("VALIDAR");
			this.plagio.setActionCommand("PLAGIO");
			this.config.setActionCommand("CONFIG");
			this.autores.setActionCommand("AUTOR");
			this.misNotificaciones.setActionCommand("NOTIF");
			this.busquedaxautor.setActionCommand("BXA");
			this.busquedaxcancion.setActionCommand("BXC");
			
			//mostrar ventana
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(600,500);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
		}
		
		public void setControladorAdministrador(ActionListener c) {
			validar.addActionListener(c);
			plagio.addActionListener(c);
			config.addActionListener(c);
			cerrarSesion.addActionListener(c);
			misNotificaciones.addActionListener(c);
			autores.addActionListener(c);
			busquedaxautor.addActionListener(c);
			busquedaxcancion.addActionListener(c);
			this.addWindowListener((WindowListener)c);
		}
		
		
	}

