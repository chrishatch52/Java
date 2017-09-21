/**
 * 
 */
package gfx;

import java.awt.Rectangle;

/**
 * @author chris
 *
 */
public abstract class AWalkableTile implements Comparable<AWalkableTile> {

	private ATile _tile;
	private Rectangle _rect;
	private Direction _directions;
	private boolean _bonus;
	private boolean _blocked;
	private boolean _door;
	/**
	 * 
	 */
	public AWalkableTile(ATile tile, Rectangle rect) {
		_tile = tile;
		_rect = rect;
		_directions = new Direction();
		set_blocked(true);
		set_bonus(false);
	}
	public ATile get_tile() {
		return this._tile;
	}
	public void set_tile(ATile _tile) {
		this._tile = _tile;
	}
	public Rectangle get_rect() {
		return this._rect;
	}
	public void set_rect(Rectangle _rect) {
		this._rect = _rect;
	}
	public boolean is_blocked() {
		return _blocked;
	}
	public void set_blocked(boolean _blocked) {
		this._blocked = _blocked;
	}
	public boolean is_door() {
		return _door;
	}
	public void set_is_door(boolean door) {
		this._door = door;
	}
	public boolean is_bonus() {
		return _bonus;
	}
	public void set_bonus(boolean bonus) {
		this._bonus = bonus;
	}
	public Direction get_directions() {
		return _directions;
	}
	public void set_directions(Direction _directions) {
		this._directions = _directions;
	}
	@Override
	public int compareTo(AWalkableTile exitTile) {
		// TODO Auto-generated method stub
		if(this == null || exitTile == null)
			return -1;
		
		if(this.getClass() != exitTile.getClass())
			return -1;
		
		if(this == exitTile)
			return 0;
		
		return -1;
	}

}
