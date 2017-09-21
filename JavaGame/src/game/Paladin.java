package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * @author Chris
 *
 */
public class Paladin extends AHeavyWarrior {

	private boolean _canSmite;
	
	public Paladin() {
		set_name("Gedry Crusadi");
		set_charType("paladin");
		set_stats(new Stats(new AttackStats(5,4), new DefenseStats(60),
				new MagicStats(2,0,0), new RateStats(.5,.6,.6)));
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 10, false));
		get_playerMoves().get_moveList().add(new Ability("Smite", 15, false));
		get_playerMoves().get_moveList().add(new Ability("Charge", 5, false));
		set_weapon(new PikeStaff());
		set_armor(new LightPlateArmor());
		addShield(new Shield());
		set_canSmite(true);
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet(get_charType() + ".png")));
	}

	public String smite(AGameCharacter character)
	{
		// takes 15 or health left from enemy, returns it to paladin
		StringBuilder result = new StringBuilder();
		int health = 0;
		int zero = 0;
		if(is_canSmite())
		{
			Ability ab = get_playerMoves().get_moveList().get(1);
			set_canSmite(false); 
			DefenseStats dstats = character.get_stats().get_defenseStats();
			if(dstats.get_health() > ab.getRating())
			{
				dstats.set_health(dstats.get_health() - ab.getRating());
				health = ab.getRating();
				result.append("Smite has hit " + character.get_name() + " for " + health);
			}
			else
			{
				result.append("Smite has killed " + character.get_name());
				health = dstats.get_health();
				dstats.set_health(zero);
			}

		}
		else
		{
			result.append("Smite unavailable");
			get_playerMoves().set_specialAttackTimer(1);
			for(int i = 8; i >= 0; i--);
			get_playerMoves().set_specialAttackTimer(0);
			set_canSmite(true);
		}
		
		return result.toString();
	}

	public boolean is_canSmite() {
		return _canSmite;
	}

	public void set_canSmite(boolean _canSmite) {
		this._canSmite = _canSmite;
	}

	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return smite(character);
	}

}
