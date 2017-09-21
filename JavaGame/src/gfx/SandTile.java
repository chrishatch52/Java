/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class SandTile extends ATile {

	private static SandTile _sandTile = null;
	/**
	 * @param img
	 * @param rect
	 * @param blocked
	 */
	private SandTile(Image img) {
		set_img(img);
	}

	public static void getTile(Image img) {
		// TODO Auto-generated method stub
		if(_sandTile == null)
		{
			_sandTile = new SandTile(img);
		}

	}

	public static SandTile flyWeightSandTile()
	{
		if(_sandTile == null)
			throw new IllegalArgumentException();
		
		return _sandTile;
	}
}
