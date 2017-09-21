/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class GrassTile extends ATile {

	private static GrassTile _grassTile = null;
	/**
	 * @param east
	 * @param north
	 * @param south
	 * @param west
	 * @param img
	 * @param blocked
	 */
	public GrassTile(Image img) {
		set_img(img);
		// TODO Auto-generated constructor stub
	}

	public static void getTile(Image img) {
		// TODO Auto-generated method stub
		if(_grassTile == null)
		{
			_grassTile = new GrassTile(img);
		}
		
	}
	public static GrassTile flyWeightGrassTile()
	{
		if(_grassTile == null)
			throw new IllegalArgumentException();
		
		return _grassTile;
	}

}
