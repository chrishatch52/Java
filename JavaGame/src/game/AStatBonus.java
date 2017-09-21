package game;


/**
 * @author chris
 *
 */
public abstract class AStatBonus {

	private int _rating;
	private String _type;
	/**
	 * @param rating
	 * @param type
	 */
	public AStatBonus(int rating, String type) 
	{
		_rating = rating;
		_type = type;
	}
	public int get_rating() {
		return _rating;
	}
	public void set_rating(int _rating) {
		this._rating = _rating;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}

}
