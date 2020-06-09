package Interfaz;

	import java.awt.*;

	import java.awt.event.*;

	import javax.swing.*;

	import java.awt.event.ActionEvent;
	import java.io.File;

	@SuppressWarnings("unused")
	class ClasePrincipal extends JFrame{
		private JLabel nombreAplicacion;
		private JLabel texto1;
		private JLabel texto2;
		private JLabel eslogan;
		private JLabel texto3;
		private JLabel texto4;
		private JLabel texto5;
		private JLabel texto6;
		private JLabel texto7;
		private JLabel texto8;
		private JTextField user1;
		private JTextField contra1;
		private JButton reg;
		private JButton anom;
		private JButton login;
		private static final long serialVersionUID = 1L;
		
		public ClasePrincipal(String text) {
		super(text);
		JPanel panelNorte = new JPanel();
		//JPanel panelOeste = new JPanel();
		JPanel panelEste = new JPanel();
		JPanel panelCentro = new JPanel();
		/**
		 * Introducimos nuestros paneles en el contenedor
		 */
		this.add(panelNorte,BorderLayout.NORTH);
		//this.add(panelOeste,BorderLayout.WEST);
		this.add(panelEste,BorderLayout.EAST);
		this.add(panelCentro,BorderLayout.CENTER);
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
		 * *******************PANEL OESTE*******************************
		 */
		//ImagenMDFTunes logo = new ImagenMDFTunes("txt" + File.separator + "MDFTunes_logo.jpg");
		//logo.setSize(2000, 1000);
		
		//panelOeste.setBackground(new Color(127,255,212));
		//panelOeste.setSize(400, 350);
		//panelOeste.repaint();
		//panelOeste.add(logo);

		/**
		 * *****************PANEL CENTRAL********************************
		 */
		
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
		
		texto3 = new JLabel ("<html><body><br>Bienvenido a la aplicacion oficial de MDFTunes,aquí podrás adentrarte"
				+ " en un mundo de música increible,<br>en el que podrás navegar por una amplia red de canciones"
				+ " y podrás descubrir nuevos autores y sus nuevos éxitos.<br>Esto no es todo, aun te queda muchas"
				+ " novedades por descubrir....<br>"
				+ " ¿A que esperas?<br><br><br></body></html>");
		panelCentro.add(texto1);
		panelCentro.add(texto2);
		panelCentro.add(eslogan);
		panelCentro.add(texto3);
		panelCentro.add(logo);
	
		/**
		 * ***************PANEL ESTE******************************************
		 */
		panelEste.setBackground(new Color(63,136,143));
		
		 JPanel panelextra = new JPanel();
		 JPanel panelextra1 = new JPanel();
		 JPanel panelextra2 = new JPanel();
		 JPanel panelextra3 = new JPanel();
		 JPanel panelextra4 = new JPanel();
		 JPanel panelextra5 = new JPanel();
		 JPanel panelextra6 = new JPanel();
		 JPanel panelextra7 = new JPanel();
		 
		panelEste.setLayout(new BoxLayout(panelEste, BoxLayout.Y_AXIS));
		texto8 = new JLabel("De que forma quieres acceder?");
		
		texto4 = new JLabel("Nombre Usuario: ");
		user1 = new JTextField(5);
		
		texto5 = new JLabel("Contraseña:"+"         ");
		contra1 = new JPasswordField(5);
		
		texto6 = new JLabel("<html><body><br><br>Aun no te has registrado?</body></html>");
		reg = new JButton("Registrate");
		
		texto7 = new JLabel("<html><body><br><br>Acceder sin registrarse:</body></html>");
		anom = new JButton("Acceder como anonimo");
		
		
		login = new JButton("Acceder");
		
		Color pintar = new Color(63,136,143);
		
		panelextra.setBackground(pintar);
		panelextra1.setBackground(pintar);
		panelextra2.setBackground(pintar);
		panelextra3.setBackground(pintar);
		panelextra4.setBackground(pintar);
		panelextra5.setBackground(pintar);
		panelextra6.setBackground(pintar);
		panelextra7.setBackground(pintar);
		
		Font auxFont3 = nombreAplicacion.getFont();
		texto8.setFont(new Font(auxFont3.getFontName(), Font.HANGING_BASELINE, 13));
		panelextra2.add(texto8);
		
		panelextra.add(texto4);
		panelextra.add(user1);
		
		panelextra1.add(texto5);
		panelextra1.add(contra1);
		
		panelextra4.add(texto6);
		panelextra5.add(reg);
		
		panelextra3.add(texto7);
		panelextra6.add(anom);
		
		panelextra7.add(login);
		
		panelEste.add(panelextra2);
		panelEste.add(panelextra);
		panelEste.add(panelextra1);
		panelEste.add(panelextra7);
		panelEste.add(panelextra4);
		panelEste.add(panelextra5);
		panelEste.add(panelextra3);
		panelEste.add(panelextra6);

		login.setActionCommand("LOGIN");
		reg.setActionCommand("REG");
		anom.setActionCommand("ANOM");
		
		// mostrar ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);	
		
		}
		
		public String getUsuario() {
			return user1.getText();
		}

		public String getContrasenia() {
			return contra1.getText();
		}

		public void setControladorMenuPrincipal(ActionListener c) {
			login.addActionListener(c);
			reg.addActionListener(c);
			anom.addActionListener(c);
			this.addWindowListener((WindowListener)c);
		}
		
	}

