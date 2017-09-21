package game;

import gfx.BattleFrame;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author chris
 *
 */
public class BattleArena {

	private GoodGuyFactory _goodGuys;
	private BadGuyFactory _badGuys;
	JFrame new_bframe = new JFrame("BATTLE ARENA");
	BattleFrame new_panel;
	/**
	 * 
	 * @param goodGuys
	 * @param badGuys
	 */
	public BattleArena(GoodGuyFactory goodGuys, BadGuyFactory badGuys) {
		// TODO Auto-generated constructor stub
		_goodGuys = goodGuys;
		_badGuys = badGuys;
		
		
		new_panel = new BattleFrame(2100, 600, _goodGuys, _badGuys);
		new_panel.setBackground(Color.RED);
		new_bframe.setSize(2100, 600);
		new_bframe.add(new_panel);
		new_bframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        new_bframe.pack();
		
		new_bframe.setResizable(true);
		new_bframe.setLocationRelativeTo(new_panel);
		
	}

	public void fight()
	{
		/**
		 *
		 */
		new_bframe.setVisible(true);
		for(int i = Integer.MAX_VALUE; i > -1; i--)
		{
				if(Math.abs(i%214748364) == 0 && new_panel.badGuysAttack())
				{
					new_panel.randomAttack_gguys();//add random timer otherwise user interface for good guys actions
				}
				else if(Math.abs(i%214748364) == 0)
				{
					new_panel.set_badGuysAttack(true);
				}

		}
	}
	
	public void boss_fight()
	{
		
	}

	public GoodGuyFactory get_goodGuys() {
		return _goodGuys;
	}

	public void set_goodGuys(GoodGuyFactory _goodGuys) {
		this._goodGuys = _goodGuys;
	}

	public BadGuyFactory get_badGuys() {
		return _badGuys;
	}

	public void set_badGuys(BadGuyFactory _badGuys) {
		this._badGuys = _badGuys;
	}

}
