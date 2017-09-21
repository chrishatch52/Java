package game;


/**
 * @author chris
 *
 */
public abstract class AWeapon extends AItem {

	
	public AWeapon(String name, Bonus bonus, boolean equipped, String condition)
	{
		super(name, "weapon", bonus, equipped, condition);
	}

}
