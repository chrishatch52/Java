package game;


/**
 * @author chris
 *
 */
public class ClothArmor extends ALightArmor {

	/**
	 * default
	 */
	public ClothArmor() {
		super("Cloth Armor", null, false, "new");
	}
	/**
	 * dropped
	 * @param name
	 * @param desc
	 * @param condition
	 * @param bonus
	 */
	public ClothArmor(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}

}
