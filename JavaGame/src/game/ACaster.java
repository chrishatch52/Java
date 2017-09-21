package game;


/**
 * 
 */

/**
 * @author Chris
 *
 */
public abstract class ACaster extends AGoodGuy implements I_LightEquip, I_Cast {

	/* (non-Javadoc)
	 * @see I_LightEquip#addLarmor(ALightArmor)
	 */
	@Override
	public void addLarmor(ALightArmor lightArmor) {
		// changes armor for caster
		get_stats().upgradeArmor(this, lightArmor);
	}

	/* (non-Javadoc)
	 * @see I_LightEquip#addScroll(ALightWeapon)
	 */
	@Override
	public void addScroll(AItem scroll) {
		// adds scroll to caster
		get_stats().upgradeStats(this, scroll);
	}

	/* (non-Javadoc)
	 * @see I_LightEquip#addKnife(AWeapon)
	 */
	@Override
	public void addLweapon(AWeapon lightWeapon) {
		// changes weapon for caster
		get_stats().upgradeWeapon(this, lightWeapon);
	}
	/*
	 * (non-Javadoc)
	 * @see I_Cast#spell(AGameCharacter)
	 */
	@Override
	public String spell(AGameCharacterFactory characters) {
		//not fully implemented for use
		StringBuilder sb = new StringBuilder();
							
			switch(get_charType())
			{
				case"firemage":
					FireMage temp_fm = (FireMage)this;
					sb.append(temp_fm.heal());
					break;
				case"icemage":
					IceMage temp_im = (IceMage)this;
					sb.append(temp_im.heal());
					break;
				case"shadowwizard":
					ShadowWizard temp_sw = (ShadowWizard)this;
					sb.append(temp_sw.groupHeal((GoodGuyFactory)characters));					
					break;
				case"whitewizard":
					WhiteWizard temp_ww = (WhiteWizard)this;
					sb.append(temp_ww.groupHeal((GoodGuyFactory)characters));
					break;
			}
		
		return sb.toString();
	}
	/*
	 * (non-Javadoc)
	 * @see I_Cast#heal()
	 */
	@Override
	public String heal() {
		// TODO Auto-generated method stub
		int temp_health = this.get_stats().get_defenseStats().get_health();
		int temp_max_health = this.get_stats().get_defenseStats().get_maxHealth();
		
		String result = "";
		if(temp_max_health - temp_health > 20)
		{
			result = this.get_name() + " has healed for 20 health points!";
			this.get_stats().get_defenseStats().set_health(temp_health + 20);
		}
		else
		{
			result = this.get_name() + " has healed for " + (temp_max_health - temp_health) + " health points!";
			this.get_stats().get_defenseStats().set_health(temp_health + (temp_max_health - temp_health));
		}
			
		return result;
		
	}

}
