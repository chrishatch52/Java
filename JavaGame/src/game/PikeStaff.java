package game;


/**
 * @author chris
 *
 */
public class PikeStaff extends AHeavyWeapon {

	/**
	 * default
	 */
	public PikeStaff() {
		super("Pike Staff", null, false, "new");
	}

	/**
	 * dropped
	 * @param name
	 * @param condition
	 * @param bonus
	 */
	public PikeStaff(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}

}
