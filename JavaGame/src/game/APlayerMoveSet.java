package game;


/**
 * @author chris
 *
 */
public class APlayerMoveSet {

	private int _specialAttackTimer;
	private java.util.List<Ability> _moveList;
	
	public APlayerMoveSet(int specialAttackTimer) 
	{
		_specialAttackTimer = specialAttackTimer;
		_moveList = new java.util.ArrayList<Ability>();
	}

	public int get_specialAttackTimer() {
		return _specialAttackTimer;
	}

	public void set_specialAttackTimer(int _specialAttackTimer) {
		this._specialAttackTimer = _specialAttackTimer;
	}

	public java.util.List<Ability> get_moveList() {
		// TODO Auto-generated method stub
		return _moveList;
	}
}
