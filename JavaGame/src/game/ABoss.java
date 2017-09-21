package game;


/**
 * 
 */

/**
 * @author chris
 *
 */
public abstract class ABoss extends ABadGuy implements I_Smash, I_GroupHeal, I_Cast{

	/**
	 * 
	 */
	public void random_drop(GoodGuyFactory gguys)
	{
		TreasureChest tc = new TreasureChest(gguys);
		if(!is_alive())
			tc.open();
	}
	/*
	 * (non-Javadoc)
	 * @see I_GroupHeal#groupHeal(AGameCharacterFactory)
	 */
	@Override
	public String groupHeal(AGameCharacterFactory bossgroup) {
		// +15 health to boss group or return to max_health if difference is under 15
		for(AGameCharacter gc : ((BadGuyFactory)bossgroup).get_badGuys())
		{
			int temp_health = gc.get_stats().get_defenseStats().get_health();
			int temp_max_health = gc.get_stats().get_defenseStats().get_maxHealth();
			if(gc.is_alive())
			{
				if(temp_max_health - temp_health > 15)
					gc.get_stats().get_defenseStats().set_health(temp_health + 15);
				else
					gc.get_stats().get_defenseStats().set_health(temp_health + (temp_max_health - temp_health));
		
			}
		}
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see I_Smash#smash(AGameCharacter)
	 */
	@Override
	public void smash(AGameCharacter character) 
	{
		// +20 dmg
		int temp_health = character.get_stats().get_defenseStats().get_health();
		if(character.is_can_beAttacked())
			character.get_stats().get_defenseStats().set_health(temp_health - 20);
			
	}
	/*
	 * (non-Javadoc)
	 * @see I_Cast#spell(AGameCharacter)
	 */
	@SuppressWarnings("unused")
	@Override
	public String spell(AGameCharacterFactory characters) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		switch(this.get_charType())
		{
		
			case"bossone":
				BossOne temp_b1 = (BossOne)this;
				//sb.append(temp_b1.fireBall((BadGuyFactory)characters));
				break;
			case"icemage":
				BossTwo temp_b2 = (BossTwo)this;
				//sb.append(temp_im.iceBlast((BadGuyFactory)characters));
				break;
			case"shadowwizard":
				BossThree temp_b3 = (BossThree)this;
				//sb.append(temp_sw.drain((BadGuyFactory)characters));					
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
