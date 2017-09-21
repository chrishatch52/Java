package game;

import gfx.CharacterSpriteSheet;
import gfx.Sprite;


/**
 * @author chris
 *
 */
public class ShadowWizard extends AWizard {

	private boolean _canDrain;
	/**
	 * 
	 */
	public ShadowWizard() 
	{
		set_name("Bocephus Jenkins");
		set_charType("shadowwizard");
		set_stats(new Stats(new AttackStats(3, 3), new DefenseStats(35),
				new MagicStats(10, 0, 0), new RateStats(.5, .3, .6)));
		set_playerMoves(new APlayerMoveSet(0));
		get_playerMoves().get_moveList().add(new Ability("Attack", 10, false));
		get_playerMoves().get_moveList().add(new Ability("Drain", 10, false));
//		get_playerMoves().get_moveList().add(new Ability("Group Heal", 15, true));
		get_playerMoves().get_moveList().add(new Ability("Heal", 20, false));
		set_weapon(new GnarledStaff());
		set_armor(new ClothArmor());
		set_sprite(new Sprite(32,32,new CharacterSpriteSheet(get_charType() + ".png")));
	}
	
	public String drain(AGameCharacter character)
	{
		// 	drains 10 life from enemy, returns to wizard
		//  if enemy hp below 10, returns hp to wizard
			int health = 0;
			int zero = 0;
			StringBuilder result = new StringBuilder();
			Ability ab = get_playerMoves().get_moveList().get(1);
			MagicStats m_stats = get_stats().get_magicStats();
			if(is_canDrain())
			{
					set_canDrain(false); 
					DefenseStats d_stats = character.get_stats().get_defenseStats();
					if(d_stats.get_health() > ab.getRating() + m_stats.get_magicRating())
					{
						d_stats.set_health(d_stats.get_health() - ab.getRating() + m_stats.get_magicRating());
						health = ab.getRating() + m_stats.get_magicRating();
						result.append("Drain " + character.get_name() + " ");
					}
					else
					{
						result.append("Drain has killed " + character.get_name() + " ");
						health = d_stats.get_health();
						d_stats.set_health(zero);
					}
				
				int temp_health = get_stats().get_defenseStats().get_health();
				int temp_max_health = get_stats().get_defenseStats().get_maxHealth();
				
				if(temp_max_health - temp_health > health)
					this.get_stats().get_defenseStats().set_health(temp_health + health);
				else
					this.get_stats().get_defenseStats().set_health(temp_max_health);
			}
			else
			{
				result.append("Drain unavailable");
				for(int i = 60; i > -1; i--);
				set_canDrain(true);
			}
			
			return result.toString();
		}

		public boolean is_canDrain() {
			return _canDrain;
		}

		public void set_canDrain(boolean canDrain) {
			this._canDrain = canDrain;
		}

		@Override
		public String specialAttack(AGameCharacter character) {
			// TODO Auto-generated method stub
			return drain(character);
		}

}

