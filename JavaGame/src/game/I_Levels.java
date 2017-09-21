package game;



/**
 * 
 */

/**
 * @author chris
 *
 */
public interface I_Levels {//Visitor

	
	public void addEnemies(BadGuyFactory badGuys);
	public void accept(GoodGuyFactory goodGuyFactory);
	
}
