/**
 * 
 */
package gfx;
//import java.awt.Dimension;

import game.BadGuyFactory;
import game.GoodGuyFactory;

import java.awt.Color;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;


/**
 * @author chris
 *
 */
public class BattleFrame extends ABonusFrame {
	
	private static final long serialVersionUID = -6751686946114898830L;
	public EnemyListenerPanel sub_frame1;
	public CharacterListenerPanel sub_frame;
	private boolean _badGuysAttack = true;

	public BattleFrame(int w, int h, GoodGuyFactory gguys, BadGuyFactory bguys) {
		super(w, h);
		setForeground(Color.DARK_GRAY);
		setLayout(new BoxLayout(this, 1));
		sub_frame1 =
				new EnemyListenerPanel(Math.abs((w/3)*2), h, new GridLayout(3,2), bguys);
		
		sub_frame = 
				new CharacterListenerPanel(Math.abs(w/3), h, new GridLayout(1,3), gguys, sub_frame1);
		
		add(sub_frame);
        add(sub_frame1);
		setVisible(true);
	}
	public void randomAttack_gguys() {
		// TODO Auto-generated method stub
		ArrayList<EnemyListener> enemies = sub_frame1.get_enemies();
		ArrayList<CharacterListener> characters = sub_frame.get_characters();
		
		for(EnemyListener enemList : enemies)
		{
				Random r = new Random();
				int rand = r.nextInt(characters.size()-1) + 0;
				if(!enemList.get_bg().is_alive())
				{
					enemies.remove(enemList);
					enemList.setVisible(false);
					enemList.setEnabled(false);
				}
				else
				{
					if(rand == 2)
					{
						int spec_rand = r.nextInt(1) + 3;
						if(characters.get(spec_rand).get_gguy().is_alive() 
								&& enemList.get_bg().get_playerMoves().get_specialAttackTimer() == 0)
						{
							JOptionPane.showMessageDialog(enemList, enemList.get_bg().specialAttack(characters.get(spec_rand).get_gguy()));
						}
					}
					else if(characters.get(rand).get_gguy().is_alive())
					{
						JOptionPane.showMessageDialog(enemList, enemList.get_bg().counter(characters.get(rand).get_gguy()));
					}
					if(!characters.get(rand).get_gguy().is_alive())
					{
						characters.remove(characters.get(rand).get_gguy());
						characters.get(rand).setVisible(false);
						characters.get(rand).setEnabled(false);
					}
					if(enemies.size() == 0)
						JOptionPane.showMessageDialog(this, "You've WON!");
					else if(characters.size() == 0)
						JOptionPane.showMessageDialog(this, "You've LOST...");
					
					if(enemies.size() == 0 || characters.size() == 0)
						this.setVisible(false);
				}
		}
		set_badGuysAttack(false);
	}
	public void set_badGuysAttack(boolean badGuysAttack) {
		this._badGuysAttack = badGuysAttack;
	}
	public boolean badGuysAttack() {
		return _badGuysAttack;
	}
}
