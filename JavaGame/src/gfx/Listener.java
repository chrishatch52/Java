package gfx;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Listener extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton _button;

	public Listener(String title)
	{
		_button = new JButton(title);
		setLayout(new FlowLayout());
		addComponentListener((ComponentListener) this);
		add(_button);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public JButton get_button()
	{
		return _button;
	}

}
