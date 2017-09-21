/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class FlowerTile extends ATile {

	private static FlowerTile _flowerTile;
	/**
	 * 
	 */
	private FlowerTile(Image img) 
	{
		set_img(img);
	}

	public static void getTile(Image img) {
		// TODO Auto-generated method stub
		if(_flowerTile == null)
		{
			_flowerTile = new FlowerTile(img);
		}
	}
	
	public static FlowerTile flyWeightFlowerTile()
	{
		if(_flowerTile == null)
			throw new IllegalArgumentException();
		
		return _flowerTile;
	}

}
