package game;


/**
 * @author chris
 *
 */
public class LightPlateArmor extends AHeavyArmor {

	/**
	 * default
	 */
	public LightPlateArmor() {
		super("Plate/Mail Armor", null,  false, "new");
	}
	
	/**
	 * dropped
	 * @param name
	 * @param condition
	 * @param bonus
	 */
	public LightPlateArmor(String name, String condition, Bonus bonus)
	{
		super(name, bonus, false, "new");
	}


}
