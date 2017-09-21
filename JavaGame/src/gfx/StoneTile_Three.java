/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class StoneTile_Three extends ATile {

	private static StoneTile_Three _stoneTile_Three = null;
	/**
	 * @param img
	 */
	private StoneTile_Three(Image img) {
		set_img(img);
	}
	
	public static void getTile(Image img) {
		
		if(_stoneTile_Three == null)
		{
			_stoneTile_Three = new StoneTile_Three(img);
		}
		
	}
	
	public static StoneTile_Three flyWeightStoneTile()
	{
		if(_stoneTile_Three == null)
			throw new IllegalArgumentException();
		
		return _stoneTile_Three;
	}

}
