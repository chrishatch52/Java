package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * @author Chris
 *
 */
public class IceMage extends AMage {

	private boolean _can_iceBlast;
	private static int num_ice_blasts = 0;
	/**
	 * 
	 */
	public IceMage() {
		set_name("Gerhardt Glacier");
		set_charType("icemage");
		set_stats(new Stats(new AttackStats(3,3), new DefenseStats(45),
				new MagicStats(10,0,4), new RateStats(.4, .2, .4)));
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 5, false));
		get_playerMoves().get_moveList().add(new Ability("Ice Blast", 20, false));
		get_playerMoves().get_moveList().add(new Ability("Flash Heal", 10, false));
		get_playerMoves().get_moveList().add(new Ability("Blink", 0, false));
		set_weapon(new BowieKnife());
		set_armor(new Leather_MailArmor());
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet(get_charType() + ".png")));
		set_can_iceBlast(true);
	}
	/**
	 * 
	 * @param badGuys
	 */
	private String iceBlast(AGameCharacter badGuy)
	{
		//20 aoe dmg
		StringBuilder result = new StringBuilder();
		Ability ab = get_playerMoves().get_moveList().get(1);
		if(is_can_iceBlast())
		{
			MagicStats m_stats = get_stats().get_magicStats();		
			if(num_ice_blasts == 2)
				set_can_iceBlast(false);
			else
				num_ice_blasts++;
			this.get_playerMoves().set_specialAttackTimer(1);
			DefenseStats d_stats = badGuy.get_stats().get_defenseStats();
			if(((d_stats.get_health() - ab.getRating() + m_stats.get_icedmg())) < 1)
			{
				d_stats.set_health(0);
				badGuy.set_alive(false);
				result.append(ab.getDesc() + " has shattered" + badGuy.get_name());
			}
			else
			{
				d_stats.set_health((d_stats.get_health() - (ab.getRating() + m_stats.get_icedmg())));
				result.append(ab.getDesc() + " has frozen" + badGuy.get_name());
			}
			
		}
		else
		{
			result.append(ab.getDesc() + " unavailable");
			for(int i = 8; i > -1; i--);
			set_can_iceBlast(true);
			this.get_playerMoves().set_specialAttackTimer(0);
		}
		
		return result.toString();
	}
	public boolean is_can_iceBlast() {
		return _can_iceBlast;
	}
	public void set_can_iceBlast(boolean _can_iceBlast) {
		this._can_iceBlast = _can_iceBlast;
	}
	
	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return iceBlast(character);
	}
}
