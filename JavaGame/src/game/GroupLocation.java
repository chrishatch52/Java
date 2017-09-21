package game;


/**
 * @author chris
 *
 */
public abstract class GroupLocation extends ALocation {

	private boolean _center_member;
	private boolean _left_member;
	private boolean _right_member;
	/**
	 * 
	 */
	public GroupLocation(int x, int y) {
		super(x, y);
	}
	public boolean is_has_left_member() {
		return _left_member;
	}
	public void set_has_left_member(boolean _has_left_member) {
		this._left_member = _has_left_member;
	}
	public boolean is_has_right_member() {
		return _right_member;
	}
	public void set_has_right_member(boolean _has_right_member) {
		this._right_member = _has_right_member;
	}
	public boolean is_center_member() {
		return _center_member;
	}
	public void set_center_member(boolean _center_member) {
		this._center_member = _center_member;
	}

}
