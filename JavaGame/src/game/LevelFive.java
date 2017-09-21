package game;


/**
 * @author chris
 *
 */
public class LevelFive extends ALevel {

	/**
	 * @param goodGuys
	 */
	public LevelFive(GoodGuyFactory gguys)
	{
		super("five", gguys);
		get_badgroupone().addGroupTwo();
		addEnemies(get_badgroupone());
		get_badgrouptwo().addGroupThree();
		addEnemies(get_badgrouptwo());
		get_badgroupthree().addGroupFive();
		addEnemies(get_badgroupthree());
	}

}
