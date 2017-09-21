package game;


/**
 * @author chris
 *
 */
public abstract class AArmor extends AItem {
	
	public AArmor(String name, Bonus bonus, boolean equipped, String condition)
	{
		super(name, "armor", bonus, equipped, condition);
	}
}
