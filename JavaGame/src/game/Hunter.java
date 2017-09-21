package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * @author Chris
 *
 */
public class Hunter extends AShadowWarrior {

	private boolean _can_multiArrow;
	private boolean _can_vanish;
	/**
	 * 
	 */
	public Hunter() {
		set_name("Chief Compton");
		set_charType("hunter");
		set_stats(new Stats(new AttackStats(5, 3), new DefenseStats(60)
		, new MagicStats(3,0,0), new RateStats(.7,.2,.4)));
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Arrow Shot", 7, false));
		get_playerMoves().get_moveList().add(new Ability("Multi Arrow", 28, false));
		get_playerMoves().get_moveList().add(new Ability("Vanish", 0, false));
		set_weapon(new LongBow());
		set_armor(new LightPlateArmor());
		addSecondWeapon(new HuntingKnife());
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet(get_charType() + ".png")));
		set_can_multiArrow(true);
		set_can_vanish(true);
	}

	public String multiArrow(AGameCharacter badguy)
	{
		// attacks one badguy 4 times
		StringBuilder result = new StringBuilder();
		Ability ab = get_playerMoves().get_moveList().get(1);
		DefenseStats d_statsE = badguy.get_stats().get_defenseStats();
		if(is_can_multiArrow())
		{
				set_can_multiArrow(false);
				if(badguy.is_alive())
				{
					d_statsE.set_health(d_statsE.get_health() - (ab.getRating() + get_stats().get_attackStats().get_attackRating()));
					result.append(ab.getDesc() + " has hit " +  badguy.get_name() + " for " + (ab.getRating() + get_stats().get_attackStats().get_attackRating()));
				}
			
			if(!badguy.is_alive())
				result.append(ab.getDesc() + " has skewered " + badguy.get_name());
		}
		else
		{
			result.append("Multi Arrow unavailable");
			for(int i = 200; i > -1; i--);
			set_can_multiArrow(true);
			get_playerMoves().set_specialAttackTimer(0);
		}
		
		return result.toString();
	}
	/* (non-Javadoc)
	 * @see I_Vanish#vanish()
	 */
	@Override
	public String vanish() {
		//the hunter puts on his ghilly suit
		StringBuilder result = new StringBuilder();
		if(can_vanish())
		{
			set_can_vanish(false);
			set_can_beAttacked(false);
			result.append(get_name() + " has put on a ghilly suit!");
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
	public boolean is_can_multiArrow() {
		return _can_multiArrow;
	}

	public void set_can_multiArrow(boolean _can_multiArrow) {
		this._can_multiArrow = _can_multiArrow;
	}

	private boolean can_vanish() {
		return _can_vanish;
	}

	private void set_can_vanish(boolean _can_vanish) {
		this._can_vanish = _can_vanish;
	}

	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return multiArrow(character);
	}

}
