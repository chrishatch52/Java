/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class GrassTile_Rock extends ATile {

	public static GrassTile_Rock _grassTile_Rock;
	/**
	 * 
	 */
	private GrassTile_Rock(Image img) {
		set_img(img);
	}
	
	public static void getTile(Image img) {
		
		if(_grassTile_Rock == null)
		{
			_grassTile_Rock = new GrassTile_Rock(img);
		}
		
	}	
	
	public static GrassTile_Rock getFlyWeightWtsTile()
	{
		return _grassTile_Rock;
	}

}
