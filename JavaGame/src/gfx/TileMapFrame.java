/**
 * 
 */
package gfx;

import java.awt.*;
import java.beans.PropertyVetoException;

import javax.swing.*;

/**
 * @author chris
 *
 */
public class TileMapFrame extends JInternalFrame {

	private ATileMap _map;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TileMapFrame(int w, int h, ATileMap map)
	{
		super();
		setBounds(0,0,w,h);
		_map = map;
		setResizable(false);
		setVisible(false);
	}
	
	public void drawFrame(Graphics g, Sprite character)
	{
		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(true);

		_map.draw(g, 2);
		character.draw(g, 1);
	}

	public ATileMap get_map() {
		return _map;
	}

	public void set_map(ATileMap _map) {
		this._map = _map;
	}
	
	
		
}
