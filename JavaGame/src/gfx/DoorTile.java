package gfx;
import java.awt.Image;

/**
 * 
 */

/**
 * @author chris
 *
 */
public class DoorTile extends ATile {

	private static DoorTile _doorTile;
	/**
	 * @param img
	 */
	private DoorTile(Image img) {
		set_img(img);
	}
	
	public static void getTile(Image img) {
		// TODO Auto-generated method stub
		if(_doorTile == null)
		{
			_doorTile = new DoorTile(img);
		}
		
	}

	public static DoorTile flyWeightDoorTile()
	{
		if(_doorTile == null)
			throw new IllegalArgumentException();
		
		return _doorTile;
	}
}
