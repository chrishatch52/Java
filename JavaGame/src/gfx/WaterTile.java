/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class WaterTile extends ATile {

	private static WaterTile _waterTile = null;
	/**
	 * 
	 * @param img
	 * @param rect
	 */
	private WaterTile(Image img) {
		set_img(img);
	}

	public static void getTile(Image img) {
		// TODO Auto-generated method stub
		if(_waterTile == null)
		{
			_waterTile = new WaterTile(img);
		}
		
	}
	
	public static WaterTile flyWeightWaterTile()
	{
		if(_waterTile == null)
			throw new IllegalArgumentException();
		
		return _waterTile;
	}

}
