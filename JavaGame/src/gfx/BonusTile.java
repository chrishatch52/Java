/**
 * 
 */
package gfx;

import game.BadGuyFactory;
import game.BattleArena;
import game.GoodGuyFactory;
import game.TreasureChest;

import java.awt.Rectangle;

/**
 * @author chris
 *
 */
public class BonusTile extends AWalkableTile {

	private boolean _battleArena;
	private GoodGuyFactory _goodGuys;
	private BadGuyFactory _badGuys;
	private BattleArena _arena;
	private TreasureChest _chest;
	/**
	 * @param tile
	 * @param rect
	 */
	public BonusTile(ATile tile, Rectangle rect, boolean battleArena) {
		super(tile, rect);
		_battleArena = battleArena;
	}
	public boolean is_battleArena() {
		return _battleArena;
	}
	public void set_battleArena(boolean _battleArena) {
		this._battleArena = _battleArena;
	}

	public void set_goodGuys(GoodGuyFactory _goodGuys) {
		this._goodGuys = _goodGuys;
	}
	
	public GoodGuyFactory get_goodGuys()
	{
		return _goodGuys;
	}

	public void set_badGuys() {
		this._badGuys = null;
	}
	
	public BadGuyFactory get_badGuys()
	{
		return _badGuys;
	}
	public BattleArena get_arena() {
		return _arena;
	}
	public void set_arena(BattleArena _arena) {
		this._arena = _arena;
	}
	public TreasureChest get_chest() {
		return _chest;
	}
	public void set_chest(TreasureChest _chest) {
		this._chest = _chest;
	}
}
