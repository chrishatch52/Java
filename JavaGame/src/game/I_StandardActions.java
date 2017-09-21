package game;



/**
 * 
 */

/**
 * @author Chris
 *
 */
public interface I_StandardActions {
	
	/**
	 * 
	 * @param character
	 */
	public String attack(AGameCharacter character);
	/**
	 * 
	 * @param character
	 */
	public String counter(AGameCharacter character);
	/**
	 * 
	 * @param character
	 */
	public String specialAttack(AGameCharacter character);
	/**
	 * 
	 * @param character
	 */
	public String ability(AGameCharacter character);
	

}
