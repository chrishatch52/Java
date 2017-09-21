package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * Non-monochromatic spritesheet
 */
public class CharacterSpriteSheet {
	private BufferedImage image = null;
	
	public CharacterSpriteSheet(String path){
		try {
			//System.out.println(path);
			image = ImageIO.read(CharacterSpriteSheet.class.getResourceAsStream(path));
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

