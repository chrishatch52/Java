package game;


/**
 * @author chris
 *
 */
public class Potion extends AConsumableItem {

	/**
	 * 
	 * @param type
	 * @param bonus
	 */
	public Potion(String type, Bonus bonus) {
		super("potion", type, bonus, false);
	}

}
