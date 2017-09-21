/**
 * 
 */
package gfx;
import game.AItem;

import game.TreasureFactory;

import java.awt.Color;
import java.awt.GridLayout;



/**
 * @author chris
 *
 */
public class ItemListenerPanel extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemListenerPanel(int w, int h, GridLayout layout, TreasureFactory treasure)
	{
		setLayout(layout);
		setSize(h,w);
		int i, j, k = 0;
		i = j = k;
		for(AItem item : treasure.get_armor())
		{
			ItemListener myWindow = new ItemListener(treasure.get_gguys().get(j++), item);
			myWindow.setSize(Math.abs(w/3), Math.abs(h/3));
			myWindow.setVisible(true);
			add(myWindow);
		}
		for(AItem item : treasure.get_weapon())
		{
			ItemListener myWindow = new ItemListener(treasure.get_gguys().get(i++), item);
			myWindow.setSize(Math.abs(w/3), Math.abs(h/3));
			myWindow.setVisible(true);
			add(myWindow);
		}
		for(AItem item : treasure.get_upgrade())
		{
			ItemListener myWindow = new ItemListener(treasure.get_gguys().get(k++), item);
			myWindow.setSize(Math.abs(w/3), Math.abs(h/3));
			myWindow.setVisible(true);
			add(myWindow);
		}
		
        setBackground(Color.BLACK);
        setVisible(true);
        super.setAlignmentY(0L);
	}

}
