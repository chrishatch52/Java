package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * @author Chris
 *
 */
public class Knight extends AHeavyWarrior {
	
	private boolean _canFrenzy;
	/**
	 *
	 */
	public Knight() {
		set_name("Sir Cramalot");
		set_charType("knight");
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 10, false));
		get_playerMoves().get_moveList().add(new Ability("Frenzy", 20, false));
		get_playerMoves().get_moveList().add(new Ability("Charge", 5, false));
		set_stats(new Stats(new AttackStats(6, 5), new DefenseStats(75),
				  new MagicStats(0,0,0), new RateStats(.6,.6,.7)));
		set_weapon(new BroadSword());
		set_armor(new HeavyPlateArmor());
		addShield(new Shield());
		set_canFrenzy(true);
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet(get_charType() + ".png")));
	}
	/**
	 * 
	 * @param goodGuys
	 * @param badGuys
	 */
	public String frenzy(AGameCharacter character)
	{
		// turns bad guy catatonic for 500 ticks
		StringBuilder result = new StringBuilder();
		Ability ab = get_playerMoves().get_moveList().get(1);
		if(is_canFrenzy())
		{
			set_canFrenzy(false); 
			character.set_alive(false);
			result.append(character.get_name() + " has gone catatonic!");
			for(int i = 5; i > -1; i--);
			character.set_alive(true);
		}
		else
		{
			result.append(ab.getDesc() + " unavailble!");
			for(int i = 12; i > -1; i--);
			set_canFrenzy(true);
		}
		
		return result.toString();
	}

	public boolean is_canFrenzy() {
		return _canFrenzy;
	}

	public void set_canFrenzy(boolean canFrenzy) {
		this._canFrenzy = canFrenzy;
	}
	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return frenzy(character);
	}

}
