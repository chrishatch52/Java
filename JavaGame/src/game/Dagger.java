package game;


/**
 * @author chris
 *
 */
public class Dagger extends AWeapon {

	/**
	 * default
	 */
	public Dagger() {
		super("Dagger", null, false, "new");
	}

	/**
	 * dropped
	 * @param name
	 * @param desc
	 * @param condition
	 * @param bonus
	 */
	public Dagger(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}

	

}
