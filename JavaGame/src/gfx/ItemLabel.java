/**
 * 
 */
package gfx;

import game.AItem;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author chris
 *
 */
public class ItemLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemLabel(AItem item) {
		// TODO Auto-generated constructor stub
		 try {
 		    BufferedImage img = ImageIO.read(getClass().getResource(item.getImgString()));
 		    BufferedImage bimg = img.getSubimage(item.getImgX(), item.getImgY(),32,32);
 		    setIcon(new ImageIcon(bimg));
 		    setText(item.get_itemname());
 		  } catch (IOException ex) {
 		  }
	}

}
