package game;



/**
 * 
 */

/**
 * @author chris
 *
 */
public interface I_TreasureFactory {

	
	public AArmor make_armor(String type);
	public AWeapon make_weapon(String type);
	public AItem make_upgrade(String type);
	
}
