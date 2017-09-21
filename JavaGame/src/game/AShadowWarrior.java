package game;


/**
 * 
 */

/**
 * @author Chris
 *
 */
public abstract class AShadowWarrior extends AFighter implements I_Vanish, I_TwoHand {

	private AWeapon _secondHand;
	/*
	 * (non-Javadoc)
	 * @see I_TwoHand#get_secondHand()
	 */
	@Override
	public AWeapon get_secondHand()
	{
		return _secondHand;
	}
	/*
	 * (non-Javadoc)
	 * @see I_TwoHand#addSecondWeapon(AWeapon)
	 */
	@Override
	public void addSecondWeapon(AWeapon secondWeapon) {
		
		_secondHand = secondWeapon;
		get_stats().upgradeWeapon(this, secondWeapon);
	}
	public String ability(AGameCharacter character)
	{
		//character unused
		return vanish();
	}
}
