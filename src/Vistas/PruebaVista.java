package Vistas;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class PruebaVista extends JPanel {
	 private JTextField nombreTarea;
	 private JButton botonAceptar;

	 
	 public PruebaVista() {
		 // crear ventana
		 JFrame ventana = new JFrame("Mi GUI");
		 
		 // crear contenedor
		 Container contenedor = ventana.getContentPane();
		 
		 // crear pantalla
		 JPanel p = new JPanel();
		 JPanel p2 = new JPanel();
		 p.setLayout(new BorderLayout());
	     contenedor.add(p);
	     
		 
		 // crear componentes
		 JLabel etiqueta = new JLabel("Nombre de la tarea: ");
		 nombreTarea = new JTextField("Nombre", 10);
		 botonAceptar = new JButton("Aceptar");
		 
		 // añadir componentes al panel
		 p.add(etiqueta, BorderLayout.CENTER);
		 p.add(nombreTarea, BorderLayout.CENTER);
		 p.add(botonAceptar, BorderLayout.CENTER);
		 
		 ventana.setSize(500, 500);
		 ventana.setLocationRelativeTo(null); // centra la ventana 
		 ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 ventana.setVisible(true);
	 }
	 
	 // método para asignar un controlador al botón
	 public void setControlador(ActionListener c) {
		 botonAceptar.addActionListener(c);
	 }
	 
	 // método que devuelve el nombre de una tarea (contenido del campo JTextField)
	 public String getNombreTarea () {
		 return nombreTarea.getText();
	 }
	 
}
