package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * @author Chris
 *
 */
public class FireMage extends AMage {

	private boolean _can_fireBall;
	private static int num_fire_balls = 0;
	/**
	 *
	 */
	public FireMage() {
		set_name("Iggy Inferno");
		set_charType("firemage");
		set_playerMoves(new APlayerMoveSet(0));
		set_stats(new Stats(new AttackStats(3,3), new DefenseStats(45),
				new MagicStats(10,4,0), new RateStats()));
		get_playerMoves().get_moveList().add(new Ability("Attack", 5, false));
		get_playerMoves().get_moveList().add(new Ability("Fire Ball", 15, false));
		get_playerMoves().get_moveList().add(new Ability("Flash Heal", 10, false));
		get_playerMoves().get_moveList().add(new Ability("Blink", 0, false));
		set_weapon(new BowieKnife());
		set_armor(new Leather_MailArmor());
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet(get_charType() + ".png")));
		set_can_fireBall(true);
	}
	/**
	 * 
	 * @param badGuys
	 */
	private String fireBall(AGameCharacter badGuy)
	{
		//15 hp aoe
		StringBuilder result = new StringBuilder();
		Ability ab = get_playerMoves().get_moveList().get(1);
		if(is_can_fireBall())
		{
			MagicStats m_stats = get_stats().get_magicStats();
			if(num_fire_balls == 2)
				set_can_fireBall(false);
			else
				num_fire_balls++;
				DefenseStats d_stats = badGuy.get_stats().get_defenseStats();
				if(((d_stats.get_health() - ab.getRating()) + m_stats.get_firedmg())<1)
				{
					d_stats.set_health(0);
					badGuy.set_alive(false);
					result.append(ab.getDesc() + " has consumed" + badGuy.get_name());
				}
				else
				{
					d_stats.set_health((d_stats.get_health() - ab.getRating()));
					result.append(ab.getDesc() + " has scorched" + badGuy.get_name());
				}
			
		}
		else
		{
			result.append(ab.getDesc() + " unavailable");
			for(int i = 200; i > -1; i--);
			set_can_fireBall(true);
			get_playerMoves().set_specialAttackTimer(0);
		}
		
		return result.toString();
	}
	public boolean is_can_fireBall() {
		return _can_fireBall;
	}
	public void set_can_fireBall(boolean _can_fireBall) {
		this._can_fireBall = _can_fireBall;
	}
	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return fireBall(character);
	}
}
