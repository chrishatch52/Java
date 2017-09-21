package game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.*;

import gfx.*;

public class Game extends Canvas implements Runnable {

	// private int map = 0;
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = 384;// WIDTH/16*9;
	public static final int SCALE = 2;
	public static final int SPRITE_SIZE = 32;
	public static final String NAME = "Sloppy 2D Game Engine";
	public int fps = 0;

	private boolean running = false;
	private JFrame frame;

	public int tickCount = 0;
	// private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
	// BufferedImage.TYPE_INT_RGB);

	// spritesheets for map and character
	private CharacterSpriteSheet spritesheet = new CharacterSpriteSheet("knight.png");

	// map
	private java.util.List<TileMapFrame> maps = new java.util.ArrayList<TileMapFrame>();

	public static TileFactory _tileFactory = TileFactory.getInstance();//just to build tiles, accessed through 
																	   //each tiles getFlyWeightTile method
	private Sprite character;
	private GoodGuyFactory gguys = new GoodGuyFactory();

	private int map = 0;
	public Game() {	
		setBackground(Color.BLACK);
		maps.add(new TileMapFrame(WIDTH, HEIGHT, OpenTileMap.getInstance(gguys)));
		maps.add(new TileMapFrame(WIDTH, HEIGHT, new RegTileMap("level1_map.txt", new LevelOne(gguys))));
		maps.add(new TileMapFrame(WIDTH, HEIGHT, new RegTileMap("level2_map.txt", new LevelTwo(gguys))));
		maps.add(new TileMapFrame(WIDTH, HEIGHT, new BossTileMap(maps.get(2),"boss1_map.txt", new BossLevelOne(gguys))));
		/*
		 * maps.add(new ATileMap("level2_map.txt", mapsheet, "two"));
		 * maps.add(new ATileMap("level3_map.txt", mapsheet, "three"));
		 * maps.add(new ATileMap("boss2_map.txt", mapsheet, "bosstwo"));
		 * maps.add(new ATileMap("level4_map.txt", mapsheet, "four"));
		 * maps.add(new ATileMap("level5_map.txt", mapsheet, "five"));
		 * maps.add(new ATileMap("boss3_map.txt", mapsheet, "bossthree"));
		 */
		character = new Sprite(SPRITE_SIZE,SPRITE_SIZE + (SPRITE_SIZE/2),spritesheet, maps.get(0).get_map());
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));

		frame = new JFrame(NAME);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		// modularity starts here
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP)
					character.navigate(Sprite.MOVE_UP, SCALE);
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					character.navigate(Sprite.MOVE_RIGHT, SCALE);
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					character.navigate(Sprite.MOVE_DOWN, SCALE);
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					character.navigate(Sprite.MOVE_LEFT, SCALE);
							
				}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP)
					character.set_spriteImage(character.getSpriteUp());
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					character.set_spriteImage(character.getSpriteRight());
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					character.set_spriteImage(character.getSpriteDown());				
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					character.set_spriteImage(character.getSpriteLeft());
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					AWalkableTile t_tile = character.get_tile();
					if (t_tile.is_door())
					{
						ExitTile temp_exit = (ExitTile)t_tile;
						switch(temp_exit.get_nextLevel())
						{
							case "opening":
								int openingDoor = getPrevLevel(temp_exit.get_level());
								character.set_tile(OpenTileMap._mainDoorTiles.get(openingDoor));
								map = 0;
								break;
							case "one":
								if(maps.size() < 2)
									maps.add(new TileMapFrame(WIDTH, HEIGHT, new RegTileMap("level1_map.txt", new LevelOne(gguys))));
								character.set_tile(((RegTileMap)maps.get(1).get_map()).get_regDoorTiles().get(0));
								map = 1;
								break;
							case "two":
								if(maps.size() < 3)
									maps.add(new TileMapFrame(WIDTH, HEIGHT, new RegTileMap("level2_map.txt", new LevelTwo(gguys))));
								if(temp_exit.get_level().compareTo("Lair of Gilgamesh V") == 0)
								{
									character.set_tile(((BossTileMap)maps.get(3).get_map()).get_exitTile());
									character.setX((WIDTH  - 24)*SCALE);
								}	
								else
								{
									character.set_tile(((RegTileMap)maps.get(2).get_map()).get_regDoorTiles().get(0));
									character.setX(16);
									character.setY((int) character.getY());
								}
								map = 2;
								break;
							case "bosslvl_one":
								if(maps.size() < 4)
									maps.add(new TileMapFrame(WIDTH, HEIGHT, new BossTileMap(maps.get(2),"boss1_map.txt", new BossLevelOne(gguys))));
								character.set_tile(((BossTileMap)maps.get(3).get_map()).get_entryTile());
								character.setX(16);
								character.setY((int) character.getY());
								map = 3;
								break;
							
						}
						render();
					}
					else if(t_tile.is_bonus())
					{
						if(((BonusTile)t_tile).is_battleArena())
						{
							((BonusTile)t_tile).get_arena().fight();
							((BonusTile)t_tile).set_arena(null);
							t_tile.set_bonus(false);
						}
						else if(!((BonusTile)t_tile).is_battleArena())
						{
							((BonusTile)t_tile).get_chest().open();
							((BonusTile)t_tile).set_chest(null);
							t_tile.set_bonus(false);
						}
					}
				}
			}

			public void keyTyped(KeyEvent e) {

			}
		});
	}

	protected int getPrevLevel(String nextLevel) {
		// TODO Auto-generated method stub
		switch(nextLevel)
		{
			case "one":
//				character.setX((int)OpenTileMap._mainDoorTiles.get(0).get_rect().getCenterX());
//				character.setY((int)OpenTileMap._mainDoorTiles.get(0).get_rect().getCenterY());
				return 0;
			case "two":
				character.set_tile(OpenTileMap._mainDoorTiles.get(1));
				//System.out.println("Center X: " + OpenTileMap._mainDoorTiles.get(1).get_rect().getCenterX());
				character.setX((int)(OpenTileMap._mainDoorTiles.get(1).get_rect().getMinX() + 8) * SCALE);
				//character.setY((int)OpenTileMap._mainDoorTiles.get(1).get_rect().getCenterY());
				return 1;
			case "three":
				character.setX((int)OpenTileMap._mainDoorTiles.get(2).get_rect().getCenterX());
				character.setY((int)OpenTileMap._mainDoorTiles.get(2).get_rect().getCenterY());
				return 2;
			case "four":
				character.setX((int)OpenTileMap._mainDoorTiles.get(3).get_rect().getCenterX());
				character.setY((int)OpenTileMap._mainDoorTiles.get(3).get_rect().getCenterY());
				return 3;
			case "five":
				character.setX((int)OpenTileMap._mainDoorTiles.get(4).get_rect().getCenterX());
				character.setY((int)OpenTileMap._mainDoorTiles.get(4).get_rect().getCenterY());
				return 4;
		}
		return -1;
	}

	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	@Override
	public void run() {
		// limit fps approx. 60
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		int ticks = 0;
		int frames = 0;
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			while (delta >= 1) {
				ticks++;
				tick();
				delta--;
				shouldRender = true;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shouldRender) {
				frames++;
				render();
			}
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(frames + ", " + ticks);
				fps = frames;
				frames = 0;
				ticks = 0;
			}
		}
	}

	public void drawDiagnostic(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.drawString(fps + " ", 20, 40);
	}

	public void tick() {
		/*
		 * 
		 * 
		 * UPDATES
		 */
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		maps.get(map).drawFrame(g, character);
		drawDiagnostic(g);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
		game.requestFocus();
	}

}