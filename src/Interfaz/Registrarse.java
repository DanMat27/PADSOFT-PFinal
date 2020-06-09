package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import FechaSimulada.FechaSimulada;


class Registro extends JFrame{
	private JLabel texto8;
	private JLabel texto4;
	private JTextField user1;
	private JLabel texto5;
	private JPasswordField contra1;
	private JLabel texto6;
	@SuppressWarnings("rawtypes")
	private JComboBox combodias;
	@SuppressWarnings("rawtypes")
	private JComboBox combomeses;
	@SuppressWarnings("rawtypes")
	private JComboBox comboanios;
	private JLabel texto7;
	private JTextField nick;
	private JButton inicio;
	private JButton acceder;
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Registro(String text) {
		super(text);
		 JPanel panelNorte = new JPanel();
		 JPanel panelCentro = new JPanel();
		/**
		 * Introducimos nuestros paneles en el contenedor
		 */
		this.add(panelNorte,BorderLayout.NORTH);
		//ventana.add(panelOeste,BorderLayout.WEST);
		//ventana.add(panelEste,BorderLayout.EAST);
		this.add(panelCentro,BorderLayout.CENTER);
		/**
		 **********************PANEL NORTE***************
		 */
		JLabel nombreAplicacion = new JLabel("MDFTUNES");
		nombreAplicacion.setForeground(Color.WHITE);
		Font auxFont = nombreAplicacion.getFont();
		nombreAplicacion.setFont(new Font(auxFont.getFontName(), Font.HANGING_BASELINE, 40));
		panelNorte.setBackground(new Color(51,60,136));
		panelNorte.add(nombreAplicacion);
		
		/**
		 * *****************PANEL CENTRAL********************************
		 */
		 
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
			texto8 = new JLabel("Introduce tus datos");
			
			texto4 = new JLabel("Nombre Usuario: ");
			user1 = new JTextField(5);
			
			texto5 = new JLabel("Contraseña:"+"         ");
			contra1 = new JPasswordField(5);
			
			texto6 = new JLabel("<html><body><br>Fecha de Nacimiento</body></html>");
			/*JTextField dia = new JTextField("<dia>",5);*/
			
			String[] dias = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
			combodias = new JComboBox(dias);
			
			String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
			combomeses = new JComboBox(meses);
			
			String[] anios = {"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969","1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979","1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989" , "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"};
			comboanios = new JComboBox(anios);
			
			/*JTextField mes = new JTextField("<mes>",5);*/
			/*JTextField anyo = new JTextField("<anyo>",5);*/
			
			
			
			 texto7 = new JLabel("<html><body><br>Nickname:</body></html>");
			 nick = new JTextField(15);
			
			inicio = new JButton("Inicio");
		    acceder = new JButton("Registrarse");
			
			panelextra.setBackground(new Color(129,216,208));
			panelextra1.setBackground(new Color(129,216,208));
			panelextra2.setBackground(new Color(129,216,208));
			panelextra3.setBackground(new Color(129,216,208));
			panelextra4.setBackground(new Color(129,216,208));
			panelextra5.setBackground(new Color(129,216,208));
			panelextra6.setBackground(new Color(129,216,208));
			panelextra7.setBackground(new Color(129,216,208));
			
			
			Font auxFont3 = nombreAplicacion.getFont();
			texto8.setFont(new Font(auxFont3.getFontName(), Font.HANGING_BASELINE, 13));
			panelextra2.add(texto8);
			
			panelextra.add(texto4);
			panelextra.add(user1);
			
			panelextra1.add(texto5);
			panelextra1.add(contra1);
			
			panelextra4.add(texto6);
			panelextra5.add(combodias);
			panelextra5.add(combomeses);
			panelextra5.add(comboanios);
			
			panelextra3.add(texto7);
			panelextra6.add(nick);
			
			panelextra7.add(inicio);
			panelextra7.add(acceder);
			
			panelCentro.add(panelextra2);
			panelCentro.add(panelextra);
			panelCentro.add(panelextra1);
			panelCentro.add(panelextra4);
			panelCentro.add(panelextra5);
			panelCentro.add(panelextra3);
			panelCentro.add(panelextra6);
			panelCentro.add(panelextra7);

			inicio.setActionCommand("INICIO");
			acceder.setActionCommand("ACCEDER");
		
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(400,400);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
	}
	

public String getUsuario() {
	return user1.getText();
}
@SuppressWarnings("deprecation")
public String getContrasenia() {
	return contra1.getText();
}

public LocalDate getFechaNac() {
	int auxdias = combodias.getSelectedIndex()+1;
	int auxmeses = combomeses.getSelectedIndex()+1;
	int auxanios = comboanios.getSelectedIndex()+1950;
	@SuppressWarnings("static-access")
	LocalDate fecharet = new FechaSimulada().fijarFecha(auxdias,auxmeses,auxanios);
	return fecharet;
}  

public String getNickname() {
	return nick.getText();
}

public void setControladorRegistro(ActionListener c) {
	inicio.addActionListener(c);
	acceder.addActionListener(c);
	this.addWindowListener((WindowListener)c);
}

}

	
