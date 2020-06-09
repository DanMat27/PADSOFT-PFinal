package Interfaz;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagenUsuario extends JPanel {
	 
	    ImageIcon imagen;
	     
	    public ImagenUsuario(String name) {
	         
	        imagen = new ImageIcon(getClass().getResource(name));
	         
	        setSize(imagen.getIconWidth(), imagen.getIconHeight());
	 
	    }
	     
	    protected void paintComponent(Graphics g) {
	        Dimension d = getSize();
	        g.drawImage(imagen.getImage(), 30, 0, 50, 50, this);
	        setOpaque(false);
	        super.paintComponent(g);
	         
	    }
	     
	 
}