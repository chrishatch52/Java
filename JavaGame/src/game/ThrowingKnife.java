package game;


/**
 * @author chris
 *
 */
public class ThrowingKnife extends AConsumableItem {

	/**
	 * 
	 */
	public ThrowingKnife() {
		super("Throwing Knife", "attack",
				new Bonus(new AttackBonus(5, "attack"),new DefenseBonus(),new MagicBonus()), false);
	}

}
