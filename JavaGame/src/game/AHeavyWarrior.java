package game;


/**
 * 
 */

/**
 * @author Chris
 *
 */
public abstract class AHeavyWarrior extends AFighter implements I_Charge {

	private double _chargeChance;
	private AItem _shield;
	/**
	 * 
	 * @return
	 */
	public double get_chargeChance() {
		return _chargeChance;
	}
	/**
	 * 
	 * @param _chargeChance
	 */
	public void set_chargeChance(double _chargeChance) {
		this._chargeChance = _chargeChance;
	}		
	/*
	 * (non-Javadoc)
	 * @see AFighter#addShield(AItem)
	 */
	@Override
	public void addShield(AItem shield) {
		this._shield = shield;
		get_stats().upgradeStats(this, shield);
	}
	/*
	 * (non-Javadoc)
	 * @see I_Charge#charge(AGameCharacterFactory)
	 */
	@Override
	public String charge(AGameCharacter character) {
		// +10 dmg to enemy subtracts 2 from attackrating
		StringBuilder result = new StringBuilder();
		Stats statsE = character.get_stats();
		Ability ab = get_playerMoves().get_moveList().get(2);
		if(character.is_can_beAttacked())
		{
			statsE.get_attackStats().set_attackRating(statsE.get_attackStats().get_attackRating() - 2);
			statsE.get_defenseStats().set_health(statsE.get_defenseStats().get_health() - ab.getRating());
			if(statsE.get_defenseStats().get_health() > 0)
			{
				result.append(ab.getDesc() + " has hit for " + ab.getRating());
			}
			else
				result.append(ab.getDesc() + " has ended " + character.get_name());
		}
		
		return result.toString();
	}
	@Override
	public String ability(AGameCharacter character)
	{
		return charge(character);
	}
	/**
	 * 
	 * @return
	 */
	public AItem get_shield() {
		return _shield;
	}

}
