package game;


/**
 * @author chris
 *
 */
public class BossTwo extends ABoss {

	private static int num_lightning_storm = 0;
	private boolean _lightning_storm;
	/**
	 * 
	 */
	public BossTwo() {
		set_name("Gruyy Bair Lothmok");
		set_charType("boss1");
		set_stats(new Stats(new AttackStats(6, 2), new DefenseStats(150), 
					new MagicStats(10,3,3), new RateStats(.7,.3,.6)));
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 10, false));
		get_playerMoves().get_moveList().add(new Ability("Lightning Storm", 30, true));
		get_playerMoves().get_moveList().add(new Ability("Heal", 20, false));
		//get_playerMoves().get_moveList().add(new Ability("Group Heal", 15, true));
		set_weapon(new GnarledStaff("Mjolbeer", "Rare", new Bonus(new AttackBonus(), new DefenseBonus(), new MagicBonus(10, "magic"))));//enchanted to drop
		set_armor(new LightPlateArmor("Scourged PlateMail", "Rare", new Bonus(new AttackBonus(), new DefenseBonus(20, "fireprot"), new MagicBonus(10, "firedmg"))));//enchanted
	}

	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return lightningStorm(character);
	}

	private String lightningStorm(AGameCharacter character) {
		StringBuilder result = new StringBuilder();
		MagicStats m_stats = get_stats().get_magicStats();
		Ability ab = get_playerMoves().get_moveList().get(1);
		if(can_lightning_storm())
		{
			if(num_lightning_storm == 2)
				set_can_lightning_storm(false);
			else
				num_lightning_storm++;
				DefenseStats d_stats = character.get_stats().get_defenseStats();
				if(((d_stats.get_health() - ab.getRating()) + m_stats.get_firedmg())<1)
				{
					d_stats.set_health(0);
					character.set_alive(false);
					result.append(ab.getDesc() + " has electrocuted " + character.get_name());
				}
				else
				{
					d_stats.set_health((d_stats.get_health() - ab.getRating()));
					result.append(ab.getDesc() + " has shocked " + character.get_name());
				}
			
		}
		else
		{
			result.append(ab.getDesc() + " unavailable");
			for(int i = 800; i > -1; i--);
			set_can_lightning_storm(true);
			get_playerMoves().set_specialAttackTimer(0);
		}
		
		return result.toString();
	}

	private boolean can_lightning_storm() {
		return _lightning_storm;
	}

	private void set_can_lightning_storm(boolean lightning_storm) {
		this._lightning_storm = lightning_storm;		
	}

	@Override
	public String ability(AGameCharacter character) {
		// character unused
		return heal();
	}

}
