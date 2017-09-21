package gfx;

import game.AGoodGuy;
import game.APlayerMoveSet;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CharacterListener extends AListener {
        /**
	 * 
	 */
	private static final long serialVersionUID = -7464756284840905659L;
	private TextField _text = new TextField(35);
	JButton a_b;
	JButton at_b;
	JButton sa_b;
    JButton _b;
    JPopupMenu _a_pmenu;
    JPopupMenu _sa_pmenu;
    JPopupMenu _ab_pmenu;
    private AGoodGuy _gguy;

    public CharacterListener(AGoodGuy gc, EnemyListenerPanel enemies) 
    {
            super("");
            _gguy = gc;
            GameCharacterLabel label = new GameCharacterLabel(gc);
            setLayout(new FlowLayout());
            add(label);
            addListeners(gc.get_playerMoves(), enemies);
            _b = new JButton("Stats");
            _b.addActionListener(new AbstractAction(){

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					_b.setToolTipText(gc.getInfo());
				}
            	
            });
            _b.setToolTipText(gc.getInfo());
            add(_b);
    }

	private void addListeners(APlayerMoveSet moves,EnemyListenerPanel enemies) {
			at_b = new JButton(moves.get_moveList().get(0).getDesc());
    		_a_pmenu = new JPopupMenu();
    		for(EnemyListener enemList : enemies.get_enemies())
    		{
    				_a_pmenu.add(new JMenuItem(new AbstractAction(moves.get_moveList().get(0).getDesc() +
        					" " + enemList.get_bg().get_name()) {
                        /**
    					 * 
    					 */
    					private static final long serialVersionUID = 1L;
    					
    					public void actionPerformed(ActionEvent e) {

    						if(enemList.get_bg().is_can_beAttacked())
    							JOptionPane.showMessageDialog(at_b, _gguy.counter(enemList.get_bg()));
                        }
                    }));
    				at_b.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            _a_pmenu.show(e.getComponent(), e.getX(), e.getY());
                        }
                    });
    				at_b.setToolTipText(moves.get_moveList().get(0).getDesc());
    				at_b.addActionListener(this);
        	    	add(at_b);    			
    		}
    		sa_b = new JButton(moves.get_moveList().get(1).getDesc());
    		_sa_pmenu = new JPopupMenu();
    		for(EnemyListener enemList : enemies.get_enemies())
    		{
    			_sa_pmenu.add(new JMenuItem(new AbstractAction(moves.get_moveList().get(1).getDesc() +
    					" " + enemList.get_bg().get_name()) {
                    /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					
					public void actionPerformed(ActionEvent e) {
						
						if(_gguy.get_playerMoves().get_specialAttackTimer() == 0)
						{
							if(enemList.get_bg().is_alive())
								JOptionPane.showMessageDialog(sa_b, _gguy.specialAttack(enemList.get_bg()));
						}
                    }
                }));
    			sa_b.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        _sa_pmenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                });
    			sa_b.setToolTipText(moves.get_moveList().get(1).getDesc());
    			sa_b.addActionListener(this);
    	    	add(sa_b);
    		}
    		a_b = new JButton(moves.get_moveList().get(2).getDesc());
    		_ab_pmenu = new JPopupMenu();
    		if(moves.get_moveList().get(2).getDesc().compareTo("Blink")==0 ||
    				moves.get_moveList().get(2).getDesc().compareTo("Heal")==0||
    				moves.get_moveList().get(2).getDesc().compareTo("Vanish")==0 )
    		{
    			_ab_pmenu.add(new JMenuItem(new AbstractAction(moves.get_moveList().get(2).getDesc()) {
                    /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					
					public void actionPerformed(ActionEvent e) {
						
						JOptionPane.showMessageDialog(a_b, _gguy.ability(null));
						
                    }
                }));
    			a_b.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        _ab_pmenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                });
    			a_b.setToolTipText(moves.get_moveList().get(2).getDesc());
    			a_b.addActionListener(this);
    	    	add(a_b);
    		}
    		else
    		{	
	    		for(EnemyListener enemList : enemies.get_enemies())
	    		{
	    			_ab_pmenu.add(new JMenuItem(new AbstractAction(moves.get_moveList().get(2).getDesc() +
	    					" " + enemList.get_bg().get_name()) {
	                    /**
						 * 
						 */
						private static final long serialVersionUID = 1L;
						
						public void actionPerformed(ActionEvent e) {
							
							if(enemList.get_bg().is_alive())
								JOptionPane.showMessageDialog(a_b, _gguy.ability(enemList.get_bg()));
							
	                    }
	                }));
	    			a_b.addMouseListener(new MouseAdapter() {
	                    public void mousePressed(MouseEvent e) {
	                        _ab_pmenu.show(e.getComponent(), e.getX(), e.getY());
	                    }
	                });
	    			a_b.setToolTipText(moves.get_moveList().get(2).getDesc());
	    			a_b.addActionListener(this);
	    	    	add(a_b);
	    		}
		}
	}
	@Override
    public void actionPerformed(ActionEvent e) {
    	
    }

	public TextField get_text() {
		return _text;
	}

	public void set_text(TextField _text) {
		this._text = _text;
	}

	public AGoodGuy get_gguy() {
		return _gguy;
	}

	public void set_gguy(AGoodGuy _gguy) {
		this._gguy = _gguy;
	}

}