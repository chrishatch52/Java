package game;


/**
 * 
 */

/**
 * @author chris
 *
 */
public class BossThree extends ABoss implements I_TwoHand {

	private AWeapon _secondHand;
	private boolean _can_murder_ball;
	private static int num_murder_balls = 0;
	/**
	 * 
	 */
	public BossThree() {
		set_name("The Final Countdown");
		set_charType("boss1");
		set_stats(new Stats(new AttackStats(10, 2), new DefenseStats(175), new MagicStats(10,3,3), new RateStats(.8,.7,.7)));
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 15, false));
		get_playerMoves().get_moveList().add(new Ability("Murder Ball", 35, true));
		get_playerMoves().get_moveList().add(new Ability("Heal", 25, false));
		//get_playerMoves().get_moveList().add(new Ability("Group Heal", 15, true));
		set_weapon(new ShortSword("Bone Collector", "attack", new Bonus(new AttackBonus(6, "dmg"), new DefenseBonus(), new MagicBonus())));//enchanted
		addSecondWeapon(new BowieKnife("Spikket", "attack", new Bonus(new AttackBonus(3, "dmg"), new DefenseBonus(), new MagicBonus(5, "dmg"))));//enchanted
		set_armor(new HeavyPlateArmor("Impenetrable", "Rare",new Bonus(new AttackBonus(), new DefenseBonus(20, "maxhealth"), new MagicBonus())));//enchanted
	}

	/*
	 * (non-Javadoc)
	 * @see I_TwoHand#addSecondWeapon(AWeapon)
	 */
	@Override
	public void addSecondWeapon(AWeapon secondWeapon) {
		this._secondHand = secondWeapon;
		get_stats().upgradeWeapon(this, secondWeapon);
	}
	
	public AWeapon get_secondHand() {
		return _secondHand;
	}
	private String murderBall(AGameCharacter character) {
		StringBuilder result = new StringBuilder();
		MagicStats m_stats = get_stats().get_magicStats();
		Ability ab = get_playerMoves().get_moveList().get(1);
		if(can_murder_ball())
		{
			if(num_murder_balls == 2)
				set_can_murder_ball(false);
			else
				num_murder_balls++;
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
			set_can_murder_ball(true);
			get_playerMoves().set_specialAttackTimer(0);
		}
		
		return result.toString();
	}
	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return murderBall(character);
	}

	public boolean can_murder_ball() {
		return _can_murder_ball;
	}

	public void set_can_murder_ball(boolean can_murder_ball) {
		this._can_murder_ball = can_murder_ball;
	}
	@Override
	public String ability(AGameCharacter character) {
		// character unused
		return heal();
	}
}
