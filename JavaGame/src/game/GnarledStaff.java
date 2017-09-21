package game;


/**
 * @author chris
 *
 */
public class GnarledStaff extends AWeapon {

	/**
	 * default
	 */
	public GnarledStaff() {
		super("Gnarled Staff", null, false, "new");
	}

	/**
	 * dropped
	 * @param name
	 * @param desc
	 * @param condition 
	 * @param bonus
	 */
	public GnarledStaff(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}

}
