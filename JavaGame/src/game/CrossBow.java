package game;


/**
 * @author chris
 *
 */
public class CrossBow extends AWeapon {

	/**
	 * default
	 */
	public CrossBow() {
		super("Cross Bow", null, false, "new");
	}

	/**
	 * dropped
	 * @param name
	 * @param desc
	 * @param condition
	 * @param bonus
	 */
	public CrossBow(String name, String desc, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}

}
