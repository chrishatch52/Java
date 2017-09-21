package game;


/**
 * 
 */

/**
 * @author Chris
 *
 */
public abstract class AMage extends ACaster implements I_Blink {

	private boolean _can_blink = true;

	/*
	 * (non-Javadoc)
	 * @see ACaster#heal()
	 */
	@Override
	public String heal() {
		// flash heal regardless of turn unused at this time
		int temp_health = this.get_stats().get_defenseStats().get_health();
		int temp_max_health = this.get_stats().get_defenseStats().get_maxHealth();
		
		StringBuilder result = new StringBuilder();
		if(temp_max_health - temp_health > 10)
		{
			result.append(get_name() + " has healed for 10 health points!");
			this.get_stats().get_defenseStats().set_health(temp_health + 10);
		}
		else
		{
			result.append(get_name() + " has healed for " + (temp_max_health - temp_health) + " health points!");
			this.get_stats().get_defenseStats().set_health(temp_health + (temp_max_health - temp_health));
		}
			
		return result.toString();
	}
	/*
	 * (non-Javadoc)
	 * @see I_Blink#blink()
	 */
	@Override
	public String blink() {
		// become impervious for 5 seconds
		StringBuilder result = new StringBuilder();
		Ability ab = get_playerMoves().get_moveList().get(3);
		if(can_blink())
		{
			set_can_blink(false);
			set_can_beAttacked(false);
			result.append(get_name() + " has blinked!");
			for(int i = 500; i > -1; i--);
			set_can_beAttacked(true);
		}
		else
		{
			result.append(ab.getDesc() + " unavailble!");
			for(int i = 12000; i > -1; i--);
			set_can_blink(true);
		}
		
		return result.toString();
	}
	public String ability(AGameCharacter character)
	{
		//character unused
		return blink();
	}
	private void set_can_blink(boolean can_blink) {
		this._can_blink = can_blink;
	}
	private boolean can_blink() {
		// TODO Auto-generated method stub
		return _can_blink;
	}
	

}
