package Interfaz;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagenMDFTunes extends JPanel {
	 
	    ImageIcon imagen;
	     
	    public ImagenMDFTunes(String name) {
	         
	        imagen = new ImageIcon(getClass().getResource(name));
	         
	        setSize(imagen.getIconWidth(), imagen.getIconHeight());
	 
	    }
	     
	    protected void paintComponent(Graphics g) {
	        Dimension d = getSize();
	        g.drawImage(imagen.getImage(), 130, 0, 300, 300, this);
	        setOpaque(false);
	        super.paintComponent(g);
	         
	    }
	     
	 
}

