package game;


/**
 * @author chris
 *
 */
public abstract class CharacterLocation extends ALocation {
	
	/**
	 * 
	 */
	public CharacterLocation(GroupLocation myGroupLocation) {
		super(myGroupLocation.getx(), myGroupLocation.gety());
		if(!myGroupLocation.is_center_member())
		{
			myGroupLocation.set_center_member(true);
			this.setx(myGroupLocation.getx());
		}
		else if(!myGroupLocation.is_has_left_member())
		{
			myGroupLocation.set_has_left_member(true);
			this.setx(myGroupLocation.getx() - 2);
		}
		else if(!myGroupLocation.is_has_right_member())
		{
			myGroupLocation.set_has_right_member(true);
			this.setx(myGroupLocation.getx() + 2);
		}
		else
		{
			throw new RuntimeException("Group full");
		}
		this.sety(myGroupLocation.gety());
	}

}
