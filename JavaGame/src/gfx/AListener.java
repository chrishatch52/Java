/**
 * 
 */
package gfx;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author chris
 *
 */
public class AListener extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1232762203194418172L;
	/**
	 * 
	 */
	public AListener(String title) {
		super(title);
		 setLayout(new FlowLayout());
	}


    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().compareTo("get stats") == 0)
    		JOptionPane.showMessageDialog(this, e.getActionCommand());
    	
    	if(e.getActionCommand().compareTo("inventory") == 0)
    		JOptionPane.showMessageDialog(this, e.getActionCommand());
    }

}
