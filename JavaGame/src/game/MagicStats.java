package game;


/**
 * @author chris
 *
 */
public class MagicStats {

	private int _magicRating;
	private int _firedmg;
	private int _icedmg;
	
	public MagicStats()
	{}
	/**
	 * 
	 * @param magicRating
	 * @param firedmg
	 * @param icedmg
	 */
	public MagicStats(int magicRating, int firedmg, int icedmg) 
	{
		_magicRating = magicRating;
		_firedmg = firedmg;
		_icedmg = icedmg;
	}
	/**
	 * 
	 * @return
	 */
	public int get_magicRating() {
		return _magicRating;
	}
	/**
	 * 
	 * @param _magicRating
	 */
	public void set_magicRating(int _magicRating) {
		this._magicRating = _magicRating;
	}
	/**
	 * 
	 * @return
	 */
	public int get_firedmg() {
		return _firedmg;
	}
	/**
	 * 
	 * @param _firedmg
	 */
	public void set_firedmg(int _firedmg) {
		this._firedmg = _firedmg;
	}
	/**
	 * 
	 * @return
	 */
	public int get_icedmg() {
		return _icedmg;
	}
	/**
	 * 
	 * @param _icedmg
	 */
	public void set_icedmg(int _icedmg) {
		this._icedmg = _icedmg;
	}

}
