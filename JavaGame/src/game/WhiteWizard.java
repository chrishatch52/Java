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
public class WhiteWizard extends AWizard {
	
	private boolean _canRevive;
	/**
	 *
	 */
	public WhiteWizard()
	{
		set_name("GangofFour Whitebeard");
		set_charType("whitewizard");
		set_stats(new Stats(new AttackStats(3, 3), new DefenseStats(45),
				new MagicStats(10, 0, 0), new RateStats(.5, .3, .6)));
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 10, false));
		get_playerMoves().get_moveList().add(new Ability("Heal", 20, false));
		//get_playerMoves().get_moveList().add(new Ability("Group Heal", 15, true));
		get_playerMoves().get_moveList().add(new Ability("Revive", 50, false));
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet(get_charType() + ".png")));
		set_weapon(new GnarledStaff());
		set_armor(new ClothArmor());
		set_canRevive(true);
	}
	/**
	 * 
	 * @param goodGuy
	 */
	public String revive(AGameCharacter goodGuy)
	{
		// revives dead member of group, with 50 HP
		String result = "";
		if(!goodGuy.is_alive())
		{
			Ability ab = this.get_playerMoves().get_moveList().get(3);
			Stats temp_stats = goodGuy.get_stats();
			this.get_playerMoves().set_specialAttackTimer(1);
			DefenseStats d_stats = temp_stats.get_defenseStats();
			if(is_canRevive())
			{
				goodGuy.set_alive(true);
				d_stats.set_health(d_stats.get_health() + ab.getRating());
				set_canRevive(false);
				result = this.get_name() + " has revived " + goodGuy.get_name() + " with 50 HP!";
			}
			else
			{
				result = this.get_name() + " cannot revive " + goodGuy.get_name();
				for(int i = 10; i > -1; i--);
					set_canRevive(true);
				this.get_playerMoves().set_specialAttackTimer(1);
			}
		}
		return result;
	}

	public boolean is_canRevive() {
		return _canRevive;
	}

	public void set_canRevive(boolean _canRevive) {
		this._canRevive = _canRevive;
	}
	@Override
	public String specialAttack(AGameCharacter character) {
		// TODO Auto-generated method stub
		return revive(character);
	}

}
