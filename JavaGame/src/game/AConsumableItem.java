package game;


/**
 * @author chris
 *
 */
public abstract class AConsumableItem extends AItem {

	/**
	 * @param name
	 * @param description
	 * @param bonus
	 * @param equipped
	 */
	public AConsumableItem(String name, String description, Bonus bonus,
			boolean equipped) {
		super(name, description, bonus, equipped, "new");
	}
	public void boostAttack(AttackStats attack)
	{
		int temp_rating = attack.get_attackRating();
		int temp_speed = attack.get_attackSpeed();
		AttackBonus temp_bonus = this.get_itembonus().get_attackBonus();
		
		switch(this.get_itemdesc())
		{
			case "rating":
				attack.set_attackRating(temp_rating + temp_bonus.get_rating());
				break;
			case "speed":
				attack.set_attackSpeed(temp_speed + temp_bonus.get_rating());
				break;
		}
	}
	public void boostDefense(DefenseStats defense)
	{
		int temp_health = defense.get_health();
		DefenseBonus temp_bonus = this.get_itembonus().get_defenseBonus();
		
		defense.set_health(temp_health + temp_bonus.get_rating());

	}
	public void boostMagic(MagicStats magic)
	{
		int temp_rating = magic.get_magicRating();
		int temp_firedmg = magic.get_firedmg();
		int temp_icedmg = magic.get_icedmg();
		MagicBonus temp_bonus = this.get_itembonus().get_magicBonus();
		
		switch(this.get_itemdesc())
		{
			case "rating":
				magic.set_magicRating(temp_rating + temp_bonus.get_rating());
				break;
			case "firedmg":
				magic.set_firedmg(temp_firedmg + temp_bonus.get_rating());
				break;
			case "icedmg":
				magic.set_icedmg(temp_icedmg + temp_bonus.get_rating());
				break;
		}

	}
	
}
