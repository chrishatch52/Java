/**
 * 
 */
package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author chris
 *
 */
public class MapSpriteSheet {

private BufferedImage image = null;
	
	public MapSpriteSheet(){
		try {
			image = ImageIO.read(MapSpriteSheet.class.getResourceAsStream("tile_sheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(image==null){
			return;
		}
	}
	
	public BufferedImage getSprite(int x, int y, int width, int height){
		return image.getSubimage(x, y, width, height);
	}
}
