package game;


/**
 * @author chris
 *
 */
public class DefenseStats {
	
	private int _health;
	private int _maxHealth;
	
	public DefenseStats()
	{}
	/**
	 * 
	 * @param health
	 */
	public DefenseStats(int health) 
	{
		_maxHealth = _health = health;
	}
	/**
	 * 
	 * @return
	 */
	public int get_health() {
		return _health;
	}
	/**
	 * 
	 * @param health
	 */
	public void set_health(int health) {
		if(health < 0)
			this._health = 0;
		else if(health > _maxHealth)
			this._maxHealth = this._health = _maxHealth + (health - _maxHealth);
		else
			this._health = health;
	}
	/**
	 * 
	 * @return
	 */
	public int get_maxHealth() {
		return _maxHealth;
	}
	/**
	 * 
	 * @param _maxHealth
	 */
	public void set_maxHealth(int _maxHealth) {
		this._maxHealth = _maxHealth;
	}

}
