/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class RoseTile extends ATile {

	private static RoseTile _roseTile;
	/**
	 * 
	 */
	private RoseTile(Image img) {
		set_img(img);
	}

	public static void getTile(Image img)
	{
		if(_roseTile == null)
		{
			_roseTile = new RoseTile(img);
		}
	}
	
	public static RoseTile flyWeightRoseTile()
	{
		if(_roseTile == null)
			throw new IllegalArgumentException();
		
		return _roseTile;
	}
}
