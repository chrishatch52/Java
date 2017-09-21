package game;


/**
 * 
 */

/**
 * @author Chris
 *
 */
public abstract class AGoodGuy extends AGameCharacter {

	private boolean _has_armor;
	private boolean _has_weapon;
	private boolean _has_upgrade;
	/**
	 * 
	 */

	public boolean is_has_armor() {
		return _has_armor;
	}
	public void set_has_armor(boolean _has_armor) {
		this._has_armor = _has_armor;
	}
	public boolean is_has_weapon() {
		return _has_weapon;
	}
	public void set_has_weapon(boolean _has_weapon) {
		this._has_weapon = _has_weapon;
	}
	public boolean is_has_upgrade() {
		return _has_upgrade;
	}
	public void set_has_upgrade(boolean _has_upgrade) {
		this._has_upgrade = _has_upgrade;
	}
	
}
