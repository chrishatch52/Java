package game;


/**
 * @author chris
 *
 */
public class Bonus {

	private AttackBonus _attackBonus;
	private DefenseBonus _defenseBonus;
	private MagicBonus _magicBonus;
	
	
	//public Bonus() {}
	
	public Bonus(AttackBonus attackBonus, DefenseBonus defenseBonus, MagicBonus magicBonus)
	{
		_attackBonus = attackBonus;
		_defenseBonus = defenseBonus;
		_magicBonus = magicBonus;
	}

	public AttackBonus get_attackBonus() {
		return _attackBonus;
	}

	public void set_attackBonus(AttackBonus _attackBonus) {
		this._attackBonus = _attackBonus;
	}

	public DefenseBonus get_defenseBonus() {
		return _defenseBonus;
	}

	public void set_defenseBonus(DefenseBonus _defenseBonus) {
		this._defenseBonus = _defenseBonus;
	}

	public MagicBonus get_magicBonus() {
		return _magicBonus;
	}

	public void set_magicBonus(MagicBonus _magicBonus) {
		this._magicBonus = _magicBonus;
	}
}
