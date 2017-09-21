/**
 * 
 */
package gfx;

import game.AArmor;
import game.AGoodGuy;
import game.AItem;
import game.AWeapon;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * @author chris
 *
 */
public class ItemListener extends AListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AItem _item;
	JButton b;
	/**
	 * @param title
	 * @param num_acts
	 */
	public ItemListener(AGoodGuy gg, AItem item) {
		super(item.get_itemname());
		_item = item;
	    setLayout(new GridLayout(2,1));
	    //setLayout(new FlowLayout());
    	ItemLabel label = new ItemLabel(item);
    	add(label);
    	b = new JButton(new AbstractAction("Pickup " + item.get_itemname().toUpperCase()) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(b, gg.get_name() + " has selected " + _item.get_itemname());
				if(_item.get_itemdesc().compareTo("weapon") == 0)
					gg.set_weapon((AWeapon) _item);
				else if(_item.get_itemdesc().compareTo("armor") == 0)
					gg.set_armor((AArmor) _item);
				else
					gg.set_upgrade(_item);
				
				gg.get_stats().upgradeStats(gg, _item);
				b.setVisible(false);
				b.getParent().setVisible(false);
            }
        });
    	add(b);
    }
}

