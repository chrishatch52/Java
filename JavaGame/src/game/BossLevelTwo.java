package game;


/**
 * @author chris
 *
 */
public class BossLevelTwo extends ALevel {

	private final BadGuyFactory _GruyyBairLothmok = new BadGuyFactory(this);
	/**
	 * @param goodGuys
	 */
	public BossLevelTwo(GoodGuyFactory gguys)
	{
		super("Longhouse Lothmok", gguys);
		_GruyyBairLothmok.get_boss(2);
		_GruyyBairLothmok.addGroupFour();
		_GruyyBairLothmok.set_bossGroup(true);
		get_badgroupone().addGroupOne();
		addEnemies(get_badgroupone());
		get_badgrouptwo().addGroupThree();
		addEnemies(get_badgrouptwo());
		get_badgroupthree().addGroupFour();
		addEnemies(get_badgroupthree());
		addEnemies(_GruyyBairLothmok);
	}

}
