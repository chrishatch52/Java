package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * @author Chris
 *
 */
public class Skeleton extends ABadGuy {

	/**
	 *
	 */
	public Skeleton() {
		set_name("Skeleton");
		set_charType("skeleton");
		set_playerMoves(new APlayerMoveSet(0));
		this.get_playerMoves().get_moveList().add(new Ability("Attack", 15, false));
		this.get_playerMoves().get_moveList().add(new Ability("Bone Dance", 10, true));
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet(get_charType() + ".png")));
		set_stats(new Stats(new AttackStats(5, 2), new DefenseStats(55),
				  new MagicStats(4, 0, 0), new RateStats(.6, .3, .6)));
		set_can_beAttacked(true);
		
		set_weapon(new ShortSword());
		set_armor(new Leather_MailArmor());
		/*
		set_wtoDrop_three(new HuntingKnife("Bone Collector", "Rare", "attack", 6, false, null));
		set_atoDrop_one(new Leather_MailArmor());
		set_atoDrop_two(new LightPlateArmor());
		set_atoDrop_three(new Leather_MailArmor("Burnt Chains", "Rare", "fireprot", 6, true, null));
		set_utoDrop_one(new Potion("Fire", 10));
		set_utoDrop_two(new Potion("Strength", 2));
		set_utoDrop_three(new Scroll("Scroll Of Healing", "health", 15));*/
	}

	public String boneDance(AGameCharacter gguy)
	{
		StringBuilder result = new StringBuilder();
		Ability ab = this.get_playerMoves().get_moveList().get(1);

			DefenseStats temp_stats = gguy.get_stats().get_defenseStats();
			if(gguy.is_can_beAttacked())
			{
				result.append(ab.getDesc() + " has hit " + gguy.get_name());
				temp_stats.set_health(temp_stats.get_health() - ab.getRating());
			}				
		
		return result.toString();
	}

	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return boneDance(character);
	}
	@Override
	public String ability(AGameCharacter character)
	{
		//character unused/no extra ability
		return null;
	}
}
