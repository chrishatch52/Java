package game;


/**
 * @author chris
 *
 */
public class RateStats {

	private double _hitChance;
	private double _blockChance;
	private double _counterChance;
	
	public RateStats()
	{}
	/**
	 * 
	 */
	public RateStats(double hitChance, double blockChance, double counterChance) 
	{
		_hitChance = hitChance;
		_blockChance = blockChance;
		_counterChance = counterChance;
	}
	
	public double get_hitChance() {
		return _hitChance;
	}
	public void set_hitChance(double _hitChance) {
		this._hitChance = _hitChance;
	}
	public double get_blockChance() {
		return _blockChance;
	}
	public void set_blockChance(double _blockChance) {
		this._blockChance = _blockChance;
	}
	public double get_counterChance() {
		return _counterChance;
	}
	public void set_counterChance(double _counterChance) {
		this._counterChance = _counterChance;
	}

}
