package game;


/**
 * @author chris
 *
 */
public class BossLevelThree extends ALevel {

	private final BadGuyFactory _theFinalCountdown = new BadGuyFactory(this);
	/**
	 * 
	 * @param goodGuys
	 */
	public BossLevelThree(GoodGuyFactory gguys)
	{
		super("The ThunderDome", gguys);
		_theFinalCountdown.get_boss(3);
		_theFinalCountdown.addGroupTwo();
		_theFinalCountdown.set_bossGroup(true);
		get_badgroupone().addGroupOne();
		addEnemies(get_badgroupone());
		get_badgrouptwo().addGroupThree();
		addEnemies(get_badgrouptwo());
		get_badgroupthree().addGroupFour();
		addEnemies(get_badgroupthree());
		addEnemies(_theFinalCountdown);
	}

}
