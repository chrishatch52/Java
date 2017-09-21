package game;


/**
 * @author Chris
 *
 */
public class BadGuyFactory extends AGameCharacterFactory {


	private java.util.List<ABadGuy> _badGuys;
	private boolean _bossGroup;
	/**
	 * 
	 */
	public BadGuyFactory(ALevel level) {
		_badGuys = new java.util.ArrayList<ABadGuy>();
	}

	public void addGroupOne()
	{
		addBadGuy(new Ghost());
		addBadGuy(new Skeleton());
		addBadGuy(new Brigand());
	}
	public void addGroupTwo()
	{
		addBadGuy(new Brigand());
		addBadGuy(new Skeleton());
		addBadGuy(new Brute());
	}
	public void addGroupThree()
	{
		addBadGuy(new Ghost());
		addBadGuy(new Brute());
		addBadGuy(new Skeleton());
	}
	public void addGroupFour()
	{
		addBadGuy(new Ghost());
		addBadGuy(new Skeleton());
		addBadGuy(new Skeleton());
	}
	public void addGroupFive()
	{
		addBadGuy(new Brute());
		addBadGuy(new Skeleton());
		addBadGuy(new Brute());
	}
	public void addGroupSix()
	{
		addBadGuy(new Brigand());
		addBadGuy(new Ghost());
		addBadGuy(new Brigand());
	}

	public void get_boss(int level)
	{
		switch(level)
		{
		case 1:
			this.addBadGuy(new BossOne());
			break;
		case 2:
			this.addBadGuy(new BossTwo());
			break;
		case 3:
			this.addBadGuy(new BossThree());
			break;
		}
	}
	
	public java.util.List<ABadGuy> get_badGuys() {
		return _badGuys;
	}
	
	public void addBadGuy(ABadGuy badGuy)
	{
		get_badGuys().add(badGuy);
	}

	public boolean is_bossGroup() {
		return _bossGroup;
	}

	public void set_bossGroup(boolean _bossGroup) {
		this._bossGroup = _bossGroup;
	}
}
