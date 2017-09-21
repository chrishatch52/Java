package game;


/**
 * @author chris
 *
 */
public class Leather_MailArmor extends ALightArmor {

	/**
	 * default
	 */
	public Leather_MailArmor() {
		super("Leather/Mail Armor", null, false, "new");
	}

	/**
	 * dropped
	 * @param name
	 * @param condition
	 * @param bonus
	 */
	public Leather_MailArmor(String name, String condition, Bonus bonus)
	{
		super(name,  bonus, false, condition);
	}

}
