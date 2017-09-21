/**
 * 
 */
package game;

import gfx.TreasureFrame;

import java.awt.Color;

import javax.swing.JFrame;
/**
 * @author chris
 *
 */

public class TreasureChest {

	static JFrame new_tframe = new JFrame("TREASURE CHEST");
	/**
	 * 
	 */
	public TreasureChest(GoodGuyFactory gguys) {
		// TODO Auto-generated constructor stub
		
		TreasureFrame new_panel = new TreasureFrame(2100, 600, gguys);
		
		new_panel.setBackground(Color.RED);
		new_tframe.setSize(2100, 600);
		new_tframe.add(new_panel);
		new_tframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        new_tframe.pack();
		
		new_tframe.setResizable(true);
		new_tframe.setLocationRelativeTo(new_panel);
	}
	
	public void open()
	{
		new_tframe.setVisible(true);
	}

}
