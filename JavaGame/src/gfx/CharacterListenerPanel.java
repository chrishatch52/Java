/**
 * 
 */
package gfx;

import game.AGoodGuy;
import game.GoodGuyFactory;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * @author chris
 * @param <AGoodGuy>
 *
 */
public class CharacterListenerPanel extends JInternalFrame {

	private java.util.ArrayList<CharacterListener> _characters;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CharacterListenerPanel(int w, int h, GridLayout layout, GoodGuyFactory ggs, EnemyListenerPanel enemies)
	{
		setLayout(layout);
		setSize(w,h);
		set_characters(new java.util.ArrayList<CharacterListener>());
		for(AGoodGuy gg : ggs.get_goodGuys())
		{
			CharacterListener myWindow = new CharacterListener(gg, enemies);
			myWindow.setSize(350,200);
		    myWindow.setVisible(true);
		    add(myWindow);
		    _characters.add(myWindow);
		}
        setBackground(Color.BLACK);
        setVisible(true);
        super.setAlignmentY(0L);
	}

	public java.util.ArrayList<CharacterListener> get_characters() {
		return _characters;
	}

	public void set_characters(java.util.ArrayList<CharacterListener> _characters) {
		this._characters = _characters;
	}
}
