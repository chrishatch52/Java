package game;


/**
 * @author chris
 *
 */
public class LevelThree extends ALevel {

	/**
	 * 
	 * @param gguys
	 */
	public LevelThree(GoodGuyFactory gguys)
	{
		super("three", gguys);
		get_badgroupone().addGroupTwo();
		addEnemies(get_badgroupone());
		get_badgrouptwo().addGroupThree();
		addEnemies(get_badgrouptwo());
		get_badgroupthree().addGroupFive();
		addEnemies(get_badgroupthree());
	}

}
