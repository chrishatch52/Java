package game;


/**
 * @author chris
 *
 */
public class ShortSword extends AHeavyWeapon {

	/**
	 * default
	 */
	public ShortSword() {
		super("Short Sword", null, false, "new");
	}
	
	/**
	 * dropped
	 * @param name
	 * @param condition
	 * @param bonus
	 */
	public ShortSword(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}



}
