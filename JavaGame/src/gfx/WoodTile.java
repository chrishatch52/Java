/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class WoodTile extends ATile {

	private static WoodTile _woodTile = null;
	/**
	 * @param img
	 */
	private WoodTile(Image img) {
		set_img(img);
	}
	
	public static void getTile(Image img) {
		
		if(_woodTile == null)
		{
			_woodTile = new WoodTile(img);
		}
		
	}

	public static WoodTile flyWeightWoodTile()
	{
		if(_woodTile == null)
			throw new IllegalArgumentException();
		
		return _woodTile;
	}
}
