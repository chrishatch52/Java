/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class WaterTile_Stone extends ATile {

	public static WaterTile_Stone _waterTile_Stone;
	/**
	 * 
	 */
	private WaterTile_Stone(Image img) {
		set_img(img);
	}
	
	public static void getTile(Image img) {
		
		if(_waterTile_Stone == null)
		{
			_waterTile_Stone = new WaterTile_Stone(img);
		}
		
	}	
	
	public static WaterTile_Stone getFlyWeightWtsTile()
	{
		return _waterTile_Stone;
	}

}
