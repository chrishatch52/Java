package game;


/**
 * @author Chris
 *
 */
public abstract class AWizard extends ACaster implements I_GroupHeal {

	@Override
	public String groupHeal(AGameCharacterFactory goodguys) {
			//ran out of time to work out the logic for a modular set of abilities
			//therefore this is never used
			StringBuilder result = new StringBuilder();
			Ability ab = get_playerMoves().get_moveList().get(2);
			for(AGoodGuy gg : ((GoodGuyFactory)goodguys).get_goodGuys())
			{
				DefenseStats d_stats = gg.get_stats().get_defenseStats();
				if(gg.is_alive())
				{
					d_stats.set_health(d_stats.get_health() + ab.getRating());
					result.append(ab.getDesc());
				}
				else
				{
					result.append(ab.getDesc() + " has ended " + " due to a fallen comrade!");
					break;//if any member is dead the heal fails
				}
			}
		return result.toString();
	}
	
	public String ability(AGameCharacter character)
	{
		//character unused
		return heal();
	}
}
