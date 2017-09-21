package game;


/**
 * 
 */

/**
 * @author chris
 *
 */
public class Stats implements I_Upgrade{

	private AttackStats _attackStats;
	private DefenseStats _defenseStats;
	private MagicStats _magicStats;
	private RateStats _rateStats;
	
	public Stats(AttackStats astats, DefenseStats dstats, MagicStats mstats, RateStats rstats)
	{
		_attackStats = astats;
		_defenseStats = dstats;
		_magicStats = mstats;
		_rateStats = rstats;
	}
	/*
	 * (non-Javadoc)
	 * @see I_Upgrade#upgradeArmor(AGameCharacter, AArmor)
	 */
	@Override
	public void upgradeArmor(AGameCharacter character, AArmor armor) 
	{
		upgradeStats(character, armor);		
	}
	/*
	 * (non-Javadoc)
	 * @see I_Upgrade#upgradeStats(AGoodGuy, AUpgrade)
	 */
	@Override
	public void upgradeStats(AGameCharacter character, AItem item) {
		
		Stats temp_stats = character.get_stats();
		AttackStats a_stats = temp_stats._attackStats;
		DefenseStats d_stats = temp_stats._defenseStats;
		MagicStats m_stats = temp_stats._magicStats;
		Bonus temp_bonus = item.get_itembonus();
		AttackBonus a_bonus = null;
		DefenseBonus d_bonus = null;
		MagicBonus m_bonus = null;
		if(temp_bonus == null)
			return;
		if(temp_bonus.get_attackBonus()!=null)
			a_bonus = temp_bonus.get_attackBonus();
		if(temp_bonus.get_defenseBonus()!=null)
			d_bonus = temp_bonus.get_defenseBonus();
		if(temp_bonus.get_magicBonus()!=null)
			m_bonus = temp_bonus.get_magicBonus();
		
		switch(a_bonus.get_type())
		{
			case "dmg":
				a_stats.set_attackRating(a_stats.get_attackRating() + a_bonus.get_rating());
				break;
			case "speed":
				a_stats.set_attackSpeed(a_stats.get_attackSpeed() + a_bonus.get_rating());
				break;
		}
		switch(m_bonus.get_type())
		{
			case "icedmg":
				m_stats.set_icedmg(m_stats.get_icedmg() + m_bonus.get_rating());
				break;
			case "firedmg":
				m_stats.set_firedmg(m_stats.get_firedmg() + m_bonus.get_rating());
				break;
			case "magic":
				m_stats.set_magicRating(m_stats.get_magicRating() + m_bonus.get_rating());
				break;
		}
		switch(d_bonus.get_type())
		{
			case "health":
				d_stats.set_health(d_stats.get_health() + d_bonus.get_rating());
				break;
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see I_Upgrade#upgradeWeapon(AGoodGuy, AWeapon)
	 */
	@Override
	public void upgradeWeapon(AGameCharacter character, AWeapon weapon) 
	{
		upgradeStats(character, weapon);
	}
	
	public AttackStats get_attackStats()
	{
		return _attackStats;
	}
	public DefenseStats get_defenseStats()
	{
		return _defenseStats;
	}
	public MagicStats get_magicStats()
	{
		return _magicStats;
	}
	public RateStats get_rateStats()
	{
		return _rateStats;
	}
	public String getInfo() {
		
		StringBuilder info = new StringBuilder();
		
		info.append("Attack Rating: " + _attackStats.get_attackRating());
		info.append("\n\n Attack Speed: " + _attackStats.get_attackSpeed());
		info.append("\n\n Health: " + _defenseStats.get_health());
		info.append("\n\n Magic Rating: " + _magicStats.get_magicRating());
		info.append("\n\n Fire Damage: " + _magicStats.get_firedmg());
		info.append("\n\n Ice Damage: " + _magicStats.get_icedmg());
		info.append("\n\n Hit Chance: " + _rateStats.get_hitChance());
		info.append("\n\n Counter Chance: " + _rateStats.get_counterChance());
		info.append("\n\n Block Chance: " + _rateStats.get_blockChance());
		return info.toString();
	}
}
