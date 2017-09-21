package game;


/**
 * @author chris
 *
 */
public class ExplodingArrows extends AConsumableItem {

	/**
	 * 
	 */
	public ExplodingArrows() {
		super("Exploding Arrows", "attack",
				new Bonus(new AttackBonus(5, "attack"),new DefenseBonus(),new MagicBonus()), false);
	}

}
