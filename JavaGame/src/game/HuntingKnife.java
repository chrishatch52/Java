package game;


/**
 * @author chris
 *
 */
public class HuntingKnife extends AWeapon {

	/**
	 * default
	 */
	public HuntingKnife() {
		super("Hunting Knife", null, false, "new");
	}

	/**
	 * dropped
	 * @param name
	 * @param desc
	 * @param condition
	 * @param bonus
	 */
	public HuntingKnife(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}
	

}
