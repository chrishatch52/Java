package game;


/**
 * @author chris
 *
 */
public class LongBow extends AHeavyWeapon {

	/**
	 * default
	 */
	public LongBow() {
		super("Long Bow", null, false, "new");
	}
	
	/**
	 * 
	 * @param name
	 * @param condition
	 * @param spelldamage
	 * @param attackRating
	 * @param spelldamage_
	 * @param spell_bonusRating
	 * @param attackBonus
	 */
	public LongBow(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}



}
