package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * @author Chris
 *
 */
public class Ghost extends ABadGuy implements I_Blink {

	private boolean _can_blink;
	/**
	 * 
	 */
	public Ghost() {
		set_name("Ghost");
		set_charType("monsters1");
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 10, false));
		get_playerMoves().get_moveList().add(new Ability("Toxic Sludge", 10, true));
		get_playerMoves().get_moveList().add(new Ability("Blink", 0, false));
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet("monsters1.png")));
		set_stats(new Stats(new AttackStats(6, 2), new DefenseStats(50),
							new MagicStats(7, 0, 0), new RateStats(.5, 1, .5)));
		set_weapon(new Dagger());
		set_armor(new ClothArmor());
		set_can_beAttacked(false);
		/*set_wtoDrop_three(new Dagger("Rusty Nail", "Rare", "shadowdmg", 6, true, null));
		set_atoDrop_three(new ClothArmor("Tattered Rags", "Rare", "iceprot", 3, true, null));
		set_utoDrop_one(new Potion("Health", 20));
		set_utoDrop_two(new Potion("Ice" , 10));
		set_utoDrop_three(new Potion("Max Health", 75));*/
	}

	public String toxicSludge(AGameCharacter character)
	{
		
		StringBuilder result = new StringBuilder();
		Ability ab = this.get_playerMoves().get_moveList().get(1);

			DefenseStats temp_stats = character.get_stats().get_defenseStats();
			if(character.is_can_beAttacked())
			{
				result.append(ab.getDesc() + " has hit " + character.get_name());
				temp_stats.set_health(temp_stats.get_health() - ab.getRating());
			}				
		
		return result.toString();
	}

	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return toxicSludge(character);
	}
	/*
	 * (non-Javadoc)
	 * @see I_Blink#blink()
	 */
	@Override
	public String blink() {
		// become impervious for 5 seconds
		StringBuilder result = new StringBuilder();
		Ability ab = get_playerMoves().get_moveList().get(3);
		if(can_blink())
		{
			set_can_blink(false);
			set_can_beAttacked(false);
			result.append(get_name() + " has blinked!");
			for(int i = 5; i > -1; i--);
			set_can_beAttacked(true);
		}
		else
		{
			result.append(ab.getDesc() + " unavailble!");
			for(int i = 12; i > -1; i--);
			set_can_blink(true);
		}
		
		return result.toString();
	}
	private void set_can_blink(boolean can_blink) {
		this._can_blink = can_blink;
	}
	private boolean can_blink() {
		// TODO Auto-generated method stub
		return _can_blink;
	}

	@Override
	public String ability(AGameCharacter character) {
		// character unused/no 3rd option
		return null;
	}
}
