package game;


/**
 * @author chris
 *
 */
public class LevelTwo extends ALevel {

	/**
	 * @param gguys
	 */
	public LevelTwo(GoodGuyFactory gguys)
	{
		super("two", gguys);
		get_badgroupone().addGroupOne();
		addEnemies(get_badgroupone());
		get_badgrouptwo().addGroupFour();
		addEnemies(get_badgrouptwo());
		get_badgroupthree().addGroupFive();
		addEnemies(get_badgroupthree());
	}

}
