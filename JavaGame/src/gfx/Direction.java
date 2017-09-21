/**
 * 
 */
package gfx;

/**
 * @author chris
 *
 */
public class Direction {

	private AWalkableTile _north;
	private AWalkableTile _south;
	private AWalkableTile _east;
	private AWalkableTile _west;

	public Direction() {
		_north = null;
		_south = null;
		_east = null;
		_west = null;
	}
	public AWalkableTile get_north() {
		return _north;
	}
	public void set_north(AWalkableTile _north) {
		this._north = _north;
	}
	public AWalkableTile get_south() {
		return _south;
	}
	public void set_south(AWalkableTile _south) {
		this._south = _south;
	}
	public AWalkableTile get_east() {
		return _east;
	}
	public void set_east(AWalkableTile _east) {
		this._east = _east;
	}
	public AWalkableTile get_west() {
		return _west;
	}
	public void set_west(AWalkableTile _west) {
		this._west = _west;
	}
}
