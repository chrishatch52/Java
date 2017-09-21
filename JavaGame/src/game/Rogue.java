package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * @author Chris
 *
 */
public class Rogue extends AShadowWarrior {

	private boolean _canBackStab;
	private boolean _canVanish;
	/**
	 * 
	 */
	public Rogue() {
		set_charType("rogue");
		set_name("Night Stalker");
		set_stats(new Stats(new AttackStats(9, 3), new DefenseStats(45),
				  new MagicStats(2,0,0), new RateStats(.7, .3, .6)));
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 5, false));
		get_playerMoves().get_moveList().add(new Ability("Back Stab", 45, false));
		get_playerMoves().get_moveList().add(new Ability("Vanish", 0, false));
		set_weapon(new ShortSword());
		set_armor(new LightPlateArmor());
		addSecondWeapon(new BowieKnife());
		set_canBackStab(true);
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet(get_charType() + ".png")));
	}

	public String backStab(AGameCharacter badGuy)
	{
		int zero = 0;
		// does 45 dmg to one enemy after vanish
		StringBuilder result = new StringBuilder();
		Ability ab = this.get_playerMoves().get_moveList().get(1);
		
		if(is_canBackStab())
		{
			vanish();
			get_playerMoves().set_specialAttackTimer(1);
			DefenseStats d_stats = badGuy.get_stats().get_defenseStats();
			int health = d_stats.get_health();
			int specialDmg = ab.getRating();
			if(health > specialDmg)
				d_stats.set_health(health - specialDmg);
			else
			{
				specialDmg = health;
				d_stats.set_health(zero);
			}
				
			
			result.append(ab.getDesc() + " " + badGuy.get_name() + 
					" for: " + ((d_stats.get_health() == 0)? "their life!" : specialDmg));
		}
		else
		{
			result.append(get_name() + "'s " + ab.getDesc() + " has failed!");
			for(int i = 15; i > -1; i--);
			set_canBackStab(true);
			this.get_playerMoves().set_specialAttackTimer(0);
		}
		return result.toString();
	}

	public boolean is_canBackStab() {
		return _canBackStab;
	}

	public void set_canBackStab(boolean canBackStab) {
		this._canBackStab = canBackStab;
	}
	/*
	 * (non-Javadoc)
	 * @see I_Vanish#vanish()
	 */
	@Override
	public String vanish() {
		// the rogue throws a smoke bomb
		StringBuilder result = new StringBuilder();
		if(can_vanish())
		{
			set_can_vanish(false);
			this.set_can_beAttacked(false);
			result.append(get_name() + " has thrown a smoke bomb!");
			for(int i = 12; i > -1; i--);
			this.set_can_beAttacked(true);
		}
		else
		{
			result.append(get_name() + " cannot vanish.");
			for(int i = 15; i > -1; i--);
			set_can_vanish(true);
		}
		
		return result.toString();
	}

	private void set_can_vanish(boolean canVanish) {
		// TODO Auto-generated method stub
		this._canVanish = canVanish;
	}

	private boolean can_vanish() {
		// TODO Auto-generated method stub
		return _canVanish;
	}

	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return backStab(character);
	}

}
