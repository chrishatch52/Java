package game;


/**
 * @author chris
 *
 */
public class BowieKnife extends AWeapon {

	/**
	 * default
	 */
	public BowieKnife() {
		super("Bowie Knife", null, false, "new");
	}
	
	/**
	 * dropped
	 * @param name
	 * @param desc
	 * @param condition
	 * @param bonus
	 */
	public BowieKnife(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}


}
