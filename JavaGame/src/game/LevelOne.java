package game;


/**
 * @author chris
 *
 */
public class LevelOne extends ALevel {
	
	/**
	 */
	public LevelOne(GoodGuyFactory gguys)
	{
		super("one", gguys);
		get_badgroupone().addGroupTwo();
		addEnemies(get_badgroupone());
		get_badgrouptwo().addGroupThree();
		addEnemies(get_badgrouptwo());
		get_badgroupthree().addGroupSix();
		addEnemies(get_badgroupthree());
	}
	
}
