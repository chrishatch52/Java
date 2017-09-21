package game;


/**
 * @author chris
 *
 */
public class BroadSword extends AHeavyWeapon {

	/**
	 * default
	 */
	public BroadSword() {
		super("Broad Sword", null, false, "new");
	}
	
	/**
	 * dropped
	 * @param name
	 * @param desc
	 * @param condition
	 * @param bonus
	 */
	public BroadSword(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}


}
