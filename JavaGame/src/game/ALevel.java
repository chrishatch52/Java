package game;



/**
 * 
 */

/**
 * @author chris
 *
 */
public abstract class ALevel implements I_Levels {

	private BadGuyFactory _badgroupone = new BadGuyFactory(this);
	private BadGuyFactory _badgrouptwo = new BadGuyFactory(this);
	private BadGuyFactory _badgroupthree = new BadGuyFactory(this);
	private BattleArena _battleArena;
	private java.util.List<BadGuyFactory> _badGuysOnLevel;
	private GoodGuyFactory _goodGuys;
	private String _levelName;
	/**
	 * 
	 * @param levelName
	 * @param gguys 
	 * @param goodGuys
	 */
	public ALevel(String levelName, GoodGuyFactory gguys)
	{
		_levelName = levelName;
		_badGuysOnLevel = new java.util.ArrayList<BadGuyFactory>();
		_goodGuys = gguys;
	}
	/*
	 * (non-Javadoc)
	 * @see I_Levels#addEnemies(BadGuyFactory)
	 */
	@Override
	public void addEnemies(BadGuyFactory badGuys) {
		// adds specific mobs
		_badGuysOnLevel.add(badGuys);
	}
	/*
	 * (non-Javadoc)
	 * @see I_Levels#accept(GoodGuyFactory)
	 */
	@Override
	public void accept(GoodGuyFactory goodGuyFactory)
	{
		_goodGuys = goodGuyFactory;
		for(AGoodGuy gg : _goodGuys.get_goodGuys())
		{
			gg.get_myLocation().set_level(this);
		}
	}
	/**
	 * 
	 * @return
	 */
	public GoodGuyFactory get_goodGuys() {
		return _goodGuys;
	}
	/**
	 * 
	 * @param _goodGuys
	 */
	public void set_goodGuys(GoodGuyFactory _goodGuys) {
		this._goodGuys = _goodGuys;
	}
	/**
	 * 
	 * @return
	 */
	public BadGuyFactory get_badgroupone() {
		return _badgroupone;
	}
	/**
	 * 
	 * @param _badgroupone
	 */
	public void set_badgroupone(BadGuyFactory _badgroupone) {
		this._badgroupone = _badgroupone;
	}
	/**
	 * 
	 * @return
	 */
	public BadGuyFactory get_badgrouptwo() {
		return _badgrouptwo;
	}
	/**
	 * 
	 * @param _badgrouptwo
	 */
	public void set_badgrouptwo(BadGuyFactory _badgrouptwo) {
		this._badgrouptwo = _badgrouptwo;
	}
	/**
	 * 
	 * @return
	 */
	public BadGuyFactory get_badgroupthree() {
		return _badgroupthree;
	}
	/**
	 * 
	 * @param _badgroupthree
	 */
	public void set_badgroupthree(BadGuyFactory _badgroupthree) {
		this._badgroupthree = _badgroupthree;
	}
	/**
	 * 
	 * @return
	 */
	public java.util.List<BadGuyFactory> get_badGuysOnLevel() {
		return _badGuysOnLevel;
	}
	/**
	 * 
	 * @param _badGuysOnLevel
	 */
	public void set_badGuysOnLevel(java.util.List<BadGuyFactory> _badGuysOnLevel) {
		this._badGuysOnLevel = _badGuysOnLevel;
	}
	/**
	 * 
	 * @return
	 */
	public BattleArena get_battleArena() {
		return _battleArena;
	}
	/**
	 * 
	 * @param _battleArena
	 */
	public void set_battleArena(BattleArena _battleArena) {
		this._battleArena = _battleArena;
	}

	/**
	 * 
	 * @return
	 */
	public String get_levelName() {
		return _levelName;
	}
	/**
	 * 
	 * @param _levelName
	 */
	public void set_levelName(String _levelName) {
		this._levelName = _levelName;
	}

}
