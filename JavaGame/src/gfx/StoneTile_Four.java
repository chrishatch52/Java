/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class StoneTile_Four extends ATile {

	private static StoneTile_Four _stoneTile_Four = null;
	/**
	 * @param img
	 */
	private StoneTile_Four(Image img) {
		set_img(img);
	}
	
	public static void getTile(Image img) {
		
		if(_stoneTile_Four == null)
		{
			_stoneTile_Four = new StoneTile_Four(img);
		}
		
	}
	
	public static StoneTile_Four flyWeightStoneTile()
	{
		if(_stoneTile_Four == null)
			throw new IllegalArgumentException();
		
		return _stoneTile_Four;
	}

}
