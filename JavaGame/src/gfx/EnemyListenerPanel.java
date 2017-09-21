/**
 * 
 */
package gfx;

import game.ABadGuy;
import game.BadGuyFactory;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * @author chris
 *
 */
public class EnemyListenerPanel extends JPanel {

	private java.util.ArrayList<EnemyListener> _enemies;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2727475299764268573L;
	/**
	 * 
	 */
	public EnemyListenerPanel(int w, int h, GridLayout layout, BadGuyFactory bgs) {
		setSize(w, h);
        setLayout(layout);
        set_enemies(new java.util.ArrayList<EnemyListener>());
        
        for(ABadGuy bg : bgs.get_badGuys())
        {
        	EnemyListener myWindow = new EnemyListener(bg);
        	myWindow.setSize(350,100);
            myWindow.setVisible(true);
            add(myWindow);
           _enemies.add(myWindow);
        }
        setBackground(Color.GREEN);
        setVisible(true);
	}

	public java.util.ArrayList<EnemyListener> get_enemies() {
		return _enemies;
	}

	public void set_enemies(java.util.ArrayList<EnemyListener> _enemies) {
		this._enemies = _enemies;
	}

}
