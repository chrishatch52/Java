/**
 * 
 */
package game;

/**
 * @author chris
 *
 */
public class Ability implements I_Ability {

	private String _desc;
	private int _rating;
	private boolean _group;
	/**
	 * 
	 */
	public Ability(String desc, int rating, boolean group) {
		_desc = desc;
		_rating = rating;
		_group = group;
	}

	/* (non-Javadoc)
	 * @see game.I_Ability#getDesc()
	 */
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return _desc;
	}

	/* (non-Javadoc)
	 * @see game.I_Ability#getRating()
	 */
	@Override
	public int getRating() {
		// TODO Auto-generated method stub
		return _rating;
	}
	/*
	 * (non-Javadoc)
	 * @see game.I_Ability#isGroupAbility()
	 */
	public boolean isGroupAbility()
	{
		return _group;
	}

}
