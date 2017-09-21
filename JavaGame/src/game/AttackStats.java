package game;


/**
 * @author chris
 *
 */
public class AttackStats {

	private int _attackRating;//strength
	private int _attackSpeed;//time it takes to attack
	
	public AttackStats()
	{}
	/**
	 * 
	 * @param attackRating
	 * @param attackSpeed
	 * @param specialAttackDmg
	 */
	public AttackStats(int attackRating, int attackSpeed)
	{ 
		_attackRating = attackRating;
		_attackSpeed = attackSpeed;
	}
	/**
	 * 
	 * @return
	 */
	public int get_attackRating() {
		return _attackRating;
	}
	/**
	 * @param _attackRating
	 */
	public void set_attackRating(int _attackRating) {
		this._attackRating = _attackRating;
	}
	/**
	 * 
	 * @return
	 */
	public int get_attackSpeed() {
		return _attackSpeed;
	}
	/**
	 * 
	 * @param _attackSpeed
	 */
	public void set_attackSpeed(int _attackSpeed) {
		this._attackSpeed = _attackSpeed;
	}

}
