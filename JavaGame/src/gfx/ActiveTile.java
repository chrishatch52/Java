/**
 * 
 */
package gfx;

import java.awt.Image;

/**
 * @author chris
 *
 */
public class ActiveTile extends ATile {

	private static ActiveTile _activeTile;
	/**
	 * 
	 */
	private ActiveTile(Image img) {
		set_img(img);
	}
	
	public void getTile(Image img)
	{
		if(_activeTile == null)
		{
			_activeTile = new ActiveTile(img);
		}
	}
	
	public ActiveTile flyWeightActiveTile()
	{
		if(_activeTile == null)
			throw new IllegalArgumentException();
		
		return _activeTile;
	}

}

