/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class StoneTile extends ATile {

	private static StoneTile _stoneTile = null;
	/**
	 * @param img
	 */
	private StoneTile(Image img) {
		set_img(img);
	}
	
	public static void getTile(Image img) {
		
		if(_stoneTile == null)
		{
			_stoneTile = new StoneTile(img);
		}
		
	}
	
	public static StoneTile flyWeightStoneTile()
	{
		if(_stoneTile == null)
			throw new IllegalArgumentException();
		
		return _stoneTile;
	}

}
