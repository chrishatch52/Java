package game;


/**
 * @author chris
 *
 */
public interface I_Location {

	public int getx();
	public int gety();
	public void check_moves();
	public boolean get_east();
	public boolean get_north();
	public boolean get_south();
	public boolean get_west();
}
