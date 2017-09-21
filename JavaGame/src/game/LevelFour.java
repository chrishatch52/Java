package game;


/**
 * @author chris
 *
 */
public class LevelFour extends ALevel {

	/**
	 * @param goodGuys
	 */
	public LevelFour(GoodGuyFactory gguys)
	{
		super("four", gguys);
		get_badgroupone().addGroupTwo();
		addEnemies(get_badgroupone());
		get_badgrouptwo().addGroupThree();
		addEnemies(get_badgrouptwo());
		get_badgroupthree().addGroupFive();
		addEnemies(get_badgroupthree());
	}

}
