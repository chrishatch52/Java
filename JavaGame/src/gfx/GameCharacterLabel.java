package gfx;



import game.AGameCharacter;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameCharacterLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4082343878411853630L;

	public GameCharacterLabel(AGameCharacter charac) {
		// TODO Auto-generated constructor stub
		 try {
 		    BufferedImage img = ImageIO.read(getClass().getResource(charac.get_charType() + ".png"));
 		    BufferedImage bimg = null;
 		    if(charac.get_charType().compareTo("boss1") == 0)
 		    	bimg = img.getSubimage(0,0,64,64);
 		    else
 		    	bimg = img.getSubimage(0,0,32,32);
 		    setIcon(new ImageIcon(bimg));
 		    setText(charac.get_name());
 		  } catch (IOException ex) {
 		  }
	}

}
