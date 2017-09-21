package game;



/**
 * @author chris
 *
 */
public interface I_LootFactory {

	
	public AItem getLoot(int i);
	public String getLoot_desc(int i);
	public Bonus getLoot_bonus(int i);
	
}
