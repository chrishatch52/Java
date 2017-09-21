package gfx;
import java.awt.Image;

/**
 * 
 */

/**
 * @author chris
 *
 */
public abstract class ATile implements I_Tile {

	private Image _img;
	private boolean _is_door;
	private boolean _is_bonus;
	
	
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return _img;
	}
	public void set_img(Image img)
	{
		this._img = img;
	}
	public boolean is_is_door() {
		return _is_door;
	}
	public void set_is_door(boolean _is_door) {
		this._is_door = _is_door;
	}
	public boolean is_is_bonus() {
		return _is_bonus;
	}
	public void set_is_bonus(boolean _is_bonus) {
		this._is_bonus = _is_bonus;
	}
}
