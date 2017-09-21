package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * 
 */

/**
 * @author Chris
 *
 */
public class Brigand extends ABadGuy implements I_Vanish, I_TwoHand{

	private AWeapon _secondHand;
	private boolean _can_vanish;
	private boolean _can_cripple;
	/**
	 * 
	 */
	public Brigand() {
		set_name("Brigand");
		set_charType("monsters1");
		set_playerMoves(new APlayerMoveSet(5));
		get_playerMoves().get_moveList().add(new Ability("Attack", 8, false));
		get_playerMoves().get_moveList().add(new Ability("Cripple", 15, false));
		get_playerMoves().get_moveList().add(new Ability("Vanish", 0, false));
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet("monsters1.png")));
		set_can_beAttacked(true);
		set_can_vanish(true);
		set_can_cripple(true);
		set_stats(new Stats(new AttackStats(6, 2), new DefenseStats(55), 
				  new MagicStats(2, 0, 0), new RateStats(.7, .3, .6)));
		set_weapon(new ShortSword());
		addSecondWeapon(new BowieKnife());
		set_armor(new Leather_MailArmor());
		/*
		set_atoDrop_three(new LightPlateArmor("Scourged PlateMail", "Rare", "fireprot", 6, true, null));
		set_utoDrop_one(new Potion("Max Health", 75));
		set_utoDrop_two(new Potion("Health", 20));
		set_utoDrop_three(new Scroll("Scroll Of Strength", "attack", 3));*/
	}
	/*
	 * (non-Javadoc)
	 * @see I_TwoHand#addSecondWeapon(AWeapon)
	 */
	@Override
	public void addSecondWeapon(AWeapon secondWeapon) {
		// TODO Auto-generated method stub
		_secondHand = secondWeapon;
		int tempRating = get_stats().get_attackStats().get_attackRating();
		get_stats().get_attackStats().set_attackRating(tempRating + Math.abs(tempRating/2));
	}
	/*
	 * (non-Javadoc)
	 * @see I_TwoHand#get_secondHand()
	 */
	@Override
	public AWeapon get_secondHand()
	{
		return _secondHand;
	}

	@Override
	public String vanish() {
		StringBuilder result = new StringBuilder();
		if(can_vanish())
		{
			set_can_vanish(false);
			set_can_beAttacked(false);
			result.append(get_name() + " has vanished!");
			for(int i = 1200; i > -1; i--);
			set_can_beAttacked(true);
		}
		else
		{
			result.append(get_name() + " cannot vanish.");
			for(int i = 12000; i > -1; i--);
			set_can_vanish(true);
		}
		
		return result.toString();
	}
	private void set_can_vanish(boolean can_vanish) {
		this._can_vanish = can_vanish;		
	}
	private boolean can_vanish() {
		return _can_vanish;
	}
	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return cripple(character);
	}
	private String cripple(AGameCharacter character) {
		// 15 dmg and +4 to attackSpeed for 1000 ticks
		StringBuilder result = new StringBuilder();
		Ability ab = get_playerMoves().get_moveList().get(1);
		int tempHlth = character.get_stats().get_defenseStats().get_health();
		int tempSpd = character.get_stats().get_attackStats().get_attackSpeed();
		if(can_cripple())
		{
			set_can_cripple(false);
			get_playerMoves().set_specialAttackTimer(1);
			if(tempHlth > ab.getRating())
			{
				character.get_stats().get_defenseStats().set_health(tempHlth - ab.getRating());
				result.append(ab.getDesc() + " has crippled " + character.get_name());
				character.get_stats().get_attackStats().set_attackSpeed(tempSpd + 4);
				for(int i = 1000; i > -1; i--);
				character.get_stats().get_attackStats().set_attackSpeed(tempSpd);
			}
			else
			{
				character.get_stats().get_defenseStats().set_health(0);
				result.append(ab.getDesc() + " unavailable");
				for(int i = 12000; i > -1; i--);
				set_can_cripple(true);
				get_playerMoves().set_specialAttackTimer(0);
			}
		}
		return result.toString();
	}
	private boolean can_cripple() {
		// TODO Auto-generated method stub
		return _can_cripple;
	}
	private void set_can_cripple(boolean can_cripple) {
		this._can_cripple = can_cripple;
	}
	@Override
	public String ability(AGameCharacter character) {
		// character unused
		return vanish();
	}
}
