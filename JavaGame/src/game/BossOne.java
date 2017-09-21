package game;


/**
 * 
 */

/**
 * @author chris
 *
 */
public class BossOne extends ABoss implements I_Vanish{

	private boolean _can_vanish;
	private boolean _can_v_fire;
	private static int num_v_fires = 0;
	/**
	 * 
	 */
	public BossOne() {
		set_name("Gilgamesh V");
		set_charType("boss1");
		set_stats(new Stats(new AttackStats(7, 2), new DefenseStats(100), new MagicStats(5, 0, 0), new RateStats(.8, .5, .6)));
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 15, false));
		get_playerMoves().get_moveList().add(new Ability("V Fire", 20, true));
		get_playerMoves().get_moveList().add(new Ability("Heal", 20, false));
		//get_playerMoves().get_moveList().add(new Ability("Group Heal", 15, true));
		//get_playerMoves().get_moveList().add(new Ability("Vanish", 0, false));
		set_can_vanish(true);
		set_weapon(new PikeStaff("Head Pole", "Rare", new Bonus(new AttackBonus(10, "attack"), new DefenseBonus(), new MagicBonus())));//enchanted
		set_armor(new LightPlateArmor("Scourged PlateMail", "Rare", new Bonus(new AttackBonus(), new DefenseBonus(20, "fireprot"), new MagicBonus(10, "firedmg"))));//enchanted 
	}

	@Override
	public String vanish() {
		
		StringBuilder result = new StringBuilder();
		if(can_vanish())
		{
			set_can_vanish(false);
			this.set_can_beAttacked(false);
			result.append(get_name() + " has vanished!");
			for(int i = 1200; i > -1; i--);
			this.set_can_beAttacked(true);
		}
		else
		{
			for(int i = 1200000; i > -1; i--);
			set_can_vanish(true);
		}
		
		return result.toString();
	}

	public boolean can_vanish() {
		return _can_vanish;
	}

	public void set_can_vanish(boolean _can_vanish) {
		this._can_vanish = _can_vanish;
	}

	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return vFire(character);
	}

	private String vFire(AGameCharacter character) {
		StringBuilder result = new StringBuilder();
		MagicStats m_stats = get_stats().get_magicStats();
		Ability ab = get_playerMoves().get_moveList().get(1);
		if(can_v_fire())
		{
			if(num_v_fires == 2)
				set_can_v_fire(false);
			else
				num_v_fires++;
				DefenseStats d_stats = character.get_stats().get_defenseStats();
				if(((d_stats.get_health() - ab.getRating()) + m_stats.get_firedmg())<1)
				{
					d_stats.set_health(0);
					character.set_alive(false);
					result.append(ab.getDesc() + " has exploded " + character.get_name());
				}
				else
				{
					d_stats.set_health((d_stats.get_health() - ab.getRating()));
					result.append(ab.getDesc() + " has bowled over " + character.get_name());
				}
			
		}
		else
		{
			result.append(ab.getDesc() + " unavailable");
			for(int i = 800; i > -1; i--);
			set_can_v_fire(true);
			get_playerMoves().set_specialAttackTimer(0);
		}
		
		return result.toString();
	}

	private boolean can_v_fire() {
		return _can_v_fire;
	}

	private void set_can_v_fire(boolean can_v_fire) {
		this._can_v_fire = can_v_fire;
	}
	@Override
	public String ability(AGameCharacter character) {
		// character unused
		return heal();
	}
}
