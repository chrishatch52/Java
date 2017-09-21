package game;


/**
 * 
 */

/**
 * @author Chris
 *
 */
public abstract class ABadGuy extends AGameCharacter implements
	I_Drop{
	
	
	@Override
	public AItem dropItem() {
		// TODO Auto-generated method stub
		switch(get_charType())
		{
		case "bossone":
			BossOne temp_b1 = (BossOne)this;
			temp_b1.random_drop(temp_b1.get_myLocation().get_level().get_goodGuys());
			break;
		case "bosstwo":
			BossTwo temp_b2 = (BossTwo)this;
			temp_b2.random_drop(temp_b2.get_myLocation().get_level().get_goodGuys());
			break;
		case "bossthree":
			BossThree temp_b3 = (BossThree)this;
			temp_b3.random_drop(temp_b3.get_myLocation().get_level().get_goodGuys());
			break;
		}
		return null;
	}
	@Override
	public void set_dropItem(AItem toDrop) {
		// TODO Auto-generated method stub
		
	}
}
