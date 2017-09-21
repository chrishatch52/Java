/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class StoneTile_Two extends ATile {

	private static StoneTile_Two _stoneTile_Two = null;
	/**
	 * @param img
	 */
	private StoneTile_Two(Image img) {
		set_img(img);
	}
	
	public static void getTile(Image img) {
		
		if(_stoneTile_Two == null)
		{
			_stoneTile_Two = new StoneTile_Two(img);
		}
		
	}
	
	public static StoneTile_Two flyWeightStoneTile()
	{
		if(_stoneTile_Two == null)
			throw new IllegalArgumentException();
		
		return _stoneTile_Two;
	}

}
