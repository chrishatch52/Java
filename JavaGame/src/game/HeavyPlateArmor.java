package game;


/**
 * @author chris
 *
 */
public class HeavyPlateArmor extends AHeavyArmor {

	/**
	 * 
	 */
	public HeavyPlateArmor() {
		super("Heavy Plate Armor", null, false, "new");
	}
	
	/**
	 * dropped
	 * @param name
	 * @param condition
	 * @param bonus
	 */
	public HeavyPlateArmor(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, condition);
	}

}
