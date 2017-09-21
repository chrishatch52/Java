package game;

import gfx.ATile;


/**
 * @author chris
 *
 */
public abstract class ALocation implements I_Location {

	private int _x;
	private int _y;
	private boolean _moveEast;
	private boolean _moveNorth;
	private boolean _moveSouth;
	private boolean _moveWest;
	private ATile _tile;
	private ALevel _level;
	
	public ALocation(int x, int y)
	{
		_x = x;
		_y = y;
	}
	
	/* (non-Javadoc)
	 * @see I_Location#getx()
	 */
	@Override
	public int getx() {
		// TODO Auto-generated method stub
		return _x;
	}

	public void setx(int x)
	{
		this._x = x;
	}
	/* (non-Javadoc)
	 * @see I_Location#gety()
	 */
	@Override
	public int gety() {
		// TODO Auto-generated method stub
		return _y;
	}

	public void sety(int y)
	{
		this._y = y;
	}
	
	@Override
	public boolean get_east() {
		// TODO Auto-generated method stub
		return _moveEast;
	}

	@Override
	public boolean get_north() {
		// TODO Auto-generated method stub
		return _moveNorth;
	}

	@Override
	public boolean get_south() {
		// TODO Auto-generated method stub
		return _moveSouth;
	}

	@Override
	public boolean get_west() {
		// TODO Auto-generated method stub
		return _moveWest;
	}

	public ATile get_tile() {
		return _tile;
	}

	public void set_tile(ATile _tile) {
		this._tile = _tile;
	}
	public ALevel get_level()
	{
		return _level;
	}
	public void set_level(ALevel level) {
		// TODO Auto-generated method stub
		this._level = level;
	}

}
