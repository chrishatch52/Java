/**
 * 
 */
package gfx;

import java.awt.Rectangle;

/**
 * @author chris
 *
 */
public class ExitTile extends AWalkableTile {

	private AWalkableTile _nextLevelEntryTile;
	private String _nextLevel;
	private String _level;
	/**
	 * @param tile
	 * @param rect
	 */
	public ExitTile(ATile tile, Rectangle rect, String level) {
		super(tile, rect);
		set_level(level);
	}
	public AWalkableTile get_nextLevelEntryTile() {
		return _nextLevelEntryTile;
	}
	public void set_nextLevelEntryTile(AWalkableTile _nextLevelEntryTile) {
		this._nextLevelEntryTile = _nextLevelEntryTile;
	}
	public String get_nextLevel() {
		return _nextLevel;
	}
	public void set_nextLevel(String _nextLevel) {
		this._nextLevel = _nextLevel;
	}
	public String get_level() {
		return _level;
	}
	public void set_level(String _level) {
		this._level = _level;
	}
}
