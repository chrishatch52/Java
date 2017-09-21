package gfx;


import game.ABadGuy;
import game.Ability;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EnemyListener extends AListener {
        /**
	 * 
	 */
	private static final long serialVersionUID = -7464756284840905659L;
		TextField text = new TextField(35);
        JButton b;
        private ABadGuy _bg;
        
        public EnemyListener(ABadGuy bg) {
        	super("");
        	_bg = bg;
            GameCharacterLabel label = new GameCharacterLabel(bg);
            add(label);
            for(Ability ab : bg.get_playerMoves().get_moveList())
            {
            	b = new JButton(ab.getDesc());
            	b.setToolTipText(ab.getDesc());
            	add(b);
            	b.addActionListener(this);
            }
            b = new JButton("Stats");
            b.addActionListener(new AbstractAction(){

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					b.setToolTipText(bg.getInfo());
				}
            });
            b.setToolTipText(bg.getInfo());
            add(b);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        }

		public ABadGuy get_bg() {
			return _bg;
		}

		public void set_bg(ABadGuy _bg) {
			this._bg = _bg;
		}

}