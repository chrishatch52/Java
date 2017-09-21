package game;


/**
 * @author chris
 *
 */
public class BossLevelOne extends ALevel {
	
	private final BadGuyFactory _gilgameshV = new BadGuyFactory(this);
	/**
	 * 
	 * @param goodGuys
	 */
	public BossLevelOne(GoodGuyFactory gguys)
	{
		super("Lair of Gilgamesh V", gguys);
		_gilgameshV.set_bossGroup(true);
		_gilgameshV.get_boss(1);
		_gilgameshV.addGroupOne();
		addEnemies(_gilgameshV);
	}
	public BadGuyFactory get_bossGroup()
	{
		return _gilgameshV;
	}
}
