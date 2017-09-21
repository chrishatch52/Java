package game;



/**
 * 
 */

/**
 * @author Chris
 *
 */
public interface I_Upgrade {

	public void upgradeArmor(AGameCharacter character, AArmor armor);
	public void upgradeStats(AGameCharacter character, AItem item);
	public void upgradeWeapon(AGameCharacter character, AWeapon weapon);

}
