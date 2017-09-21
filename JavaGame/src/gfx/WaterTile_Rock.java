/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class WaterTile_Rock extends ATile {

	public static WaterTile_Rock _waterTile_Rock;
	/**
	 * 
	 */
	private WaterTile_Rock(Image img) {
		set_img(img);
	}
	
	public static void getTile(Image img) {
		
		if(_waterTile_Rock == null)
		{
			_waterTile_Rock = new WaterTile_Rock(img);
		}
		
	}	
	
	public static WaterTile_Rock getFlyWeightWtsTile()
	{
		return _waterTile_Rock;
	}

}
