
public interface I_Secondary_Powerplant {

	public A_Powerplant getPowerplantSecondary();
	public void isPrimaryOrSecondary(boolean is_);
	public boolean isPrimaryOrSecondary();
	public boolean hasPowerplantSecondary();
	public void removePowerplantSecondary();
	public void installPowerplantSecondary(A_Powerplant s_to_install);
	
}
