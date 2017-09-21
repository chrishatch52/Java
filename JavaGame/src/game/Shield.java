package game;


/**
 * @author chris
 *
 */
public class Shield extends AConsumableItem {

	/**
	 * default
	 */
	public Shield() {
		super("Rusty Shield", "shield", 
				new Bonus(new AttackBonus(),new DefenseBonus(10, "health"),new MagicBonus()), false);
	}
	
	/**
	 * dropped
	 * @param name
	 * @param desc
	 * @param bonus
	 */
	public Shield(String name, String desc, Bonus bonus)
	{
		super(name, desc, bonus, false);
	}

}
