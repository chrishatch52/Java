/**
 * 
 */
package gfx;

import game.GoodGuyFactory;
import game.TreasureFactory;

import java.awt.Color;
import java.awt.GridLayout;

/**
 * @author chris
 *
 */
public class TreasureFrame extends ABonusFrame {
	
	private static final long serialVersionUID = -8051478809231915167L;
	
	/**
	 * 
	 */
	public TreasureFrame(int h, int w, GoodGuyFactory gguys) {
		
		super(h, w);
		setForeground(Color.DARK_GRAY);
		setLayout(new GridLayout(1,1));

		ItemListenerPanel panel =
				new ItemListenerPanel(h, w, new GridLayout(3,3), new TreasureFactory(gguys));
		
		add(panel);
		setVisible(true);
	}
}
