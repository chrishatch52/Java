package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * @author Chris
 *
 */
public class Brute extends ABadGuy {

	private boolean _can_crush;
	/**
	 * 
	 */
	public Brute() {
		set_name("Brute");
		set_charType("monsters1");
		set_playerMoves(new APlayerMoveSet(7));
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet("monsters1.png")));
		set_can_beAttacked(true);
		set_stats(new Stats(new AttackStats(8, 6), new DefenseStats(110),
				new MagicStats(0, 0, 0), new RateStats(.5,.6,.5)));
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 10, false));
		get_playerMoves().get_moveList().add(new Ability("Crush", 25, false));
		set_can_crush(true);
		set_can_beAttacked(true);
		set_weapon(new PikeStaff());
		set_armor(new HeavyPlateArmor());
	}

	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return crush(character);
	}

	private String crush(AGameCharacter character) {
		// 25 dmg to opponent
		StringBuilder result = new StringBuilder();
		Ability ab = get_playerMoves().get_moveList().get(1);
		int tempHlth = character.get_stats().get_defenseStats().get_health();
		if(can_crush())
		{
			set_can_crush(false);
			get_playerMoves().set_specialAttackTimer(1);
			if(tempHlth > ab.getRating())
			{
				character.get_stats().get_defenseStats().set_health(tempHlth - ab.getRating());
				result.append(ab.getDesc() + " has crushed " + character.get_name());
			}
			else
			{
				character.get_stats().get_defenseStats().set_health(0);
			}
		}
		else
		{
			result.append(ab.getDesc() + " unavailable");
			for(int i = 12; i > -1; i--);
			set_can_crush(true);
			get_playerMoves().set_specialAttackTimer(0);
		}
		return result.toString();
	}

	private boolean can_crush() {
		// TODO Auto-generated method stub
		return _can_crush;
	}

	private void set_can_crush(boolean can_crush) {
		// TODO Auto-generated method stub
		this._can_crush = can_crush;
	}
	@Override
	public String ability(AGameCharacter character) {
		// character unused/no 3rd option
		return null;
	}

}
