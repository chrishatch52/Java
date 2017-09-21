package game;


/**
 * 
 */

/**
 * @author Chris
 *
 */
public abstract class AFighter extends AGoodGuy implements I_HeavyEquip,
		I_Smash {

	/*
	 * (non-Javadoc)
	 * @see I_Smash#smash(AGameCharacter)
	 */
	@Override
	public void smash(AGameCharacter character) {
		// 10 dmg to enemy +3 to attack speed
		Stats d_statsbg = character.get_stats();
		if(character.is_can_beAttacked())
		{
			d_statsbg.get_defenseStats().set_health(d_statsbg.get_defenseStats().get_health() - 10);
			int temp_attack_speed = d_statsbg.get_attackStats().get_attackSpeed();
			d_statsbg.get_attackStats().set_attackSpeed(temp_attack_speed + 3);
			for(int i = 12000; i > -1; i--);
			d_statsbg.get_attackStats().set_attackSpeed(temp_attack_speed);
			
		}
	}

	/* (non-Javadoc)
	 * @see I_HeavyEquip#addHarmor(AHeavyArmor)
	 */
	@Override
	public void addHarmor(AHeavyArmor heavyArmor) {
		get_stats().upgradeArmor(this, heavyArmor);
	}

	/* (non-Javadoc)
	 * @see I_HeavyEquip#addShield(AHeavyWeapon)
	 */
	@Override
	public void addShield(AItem shield) {
		get_stats().upgradeStats(this, shield);
	}

	/* (non-Javadoc)
	 * @see I_HeavyEquip#addHweapon(AHeavyWeapon)
	 */
	@Override
	public void addHweapon(AHeavyWeapon heavyWeapon) {
		get_stats().upgradeWeapon(this, heavyWeapon);
	}

}
