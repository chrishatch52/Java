package gfx;


import java.awt.Graphics;
//import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Sprite extends ASprite {
	//nav finals
	private CharacterSpriteSheet _spriteSheet;
	
	public static final int MOVE_UP = 0, MOVE_RIGHT = 1, MOVE_DOWN = 2, MOVE_LEFT = 3;
	
	private int x,y;
	private AWalkableTile _tile;
	private ATileMap _tileMap;
	
	private int _spriteOffset = 32;
	
	private int _upMoves = 0, _downMoves = 0, _leftMoves = 0, _rightMoves = 0;
	
	public Sprite(int w, int h, CharacterSpriteSheet spritesheet, ATileMap map){
		super(w, h, spritesheet.getSprite(0, 0, w, h));
		this._spriteSheet = spritesheet;
		this._tile = map.get_tiles().get(0);
		this._tileMap = map;
		this.setX((int)(map.get_tiles().get(0).get_rect().getWidth()/2));
		this.setY((int)(map.get_tiles().get(0).get_rect().getHeight()/2));
	}
	
	public Sprite(int w, int h, CharacterSpriteSheet spritesheet) {
		super(w, h, spritesheet.getSprite(0, 0, w, h));
		this._spriteSheet = spritesheet;
	}

	public void draw(Graphics g, int scale){
		g.drawImage(get_spriteImage(), this.x, this.y,32*scale,32*scale, null);
	}
	
	public void navigate(int nav, int scale){
		//add tile bounding logic here
		
		switch(nav){
			default:
				System.out.println("Not navigating..?");
				break;
			case MOVE_UP:
				if(this._tile.get_directions().get_north()!=null)
				{
					if(!this._tile.get_directions().get_north().is_blocked())
					{
						this.set_tile(this._tile.get_directions().get_north());
						this.y-=32*scale;
						this.set_spriteImage(getSpriteUp());
					}					
				}
				break;
			case MOVE_RIGHT:
				if(this._tile.get_directions().get_west()!=null)
				{
					if(!this._tile.get_directions().get_west().is_blocked())
					{
						this.set_tile(this._tile.get_directions().get_west());
						this.x+=32*scale;
						this.set_spriteImage(getSpriteRight());
					}
				}
				break;
			case MOVE_DOWN:
				if(this._tile.get_directions().get_south()!=null)
				{
					if(!this._tile.get_directions().get_south().is_blocked())
					{
						this.set_tile(this._tile.get_directions().get_south());
						this.y+=32*scale;
						this.set_spriteImage(getSpriteDown());
					}
				}
				break;
			case MOVE_LEFT:
				if(this._tile.get_directions().get_east()!=null)
				{
					if(!this._tile.get_directions().get_east().is_blocked())
					{
						this.set_tile(this._tile.get_directions().get_east());
						this.x-=32*scale;
						this.set_spriteImage(getSpriteLeft());
					}
				}
				break;
				
		}
	}
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public AWalkableTile get_tile() {
		return _tile;
	}

	public void set_tile(AWalkableTile _tile) {
		this._tile = _tile;
	}

	public ATileMap get_tileMap() {
		return _tileMap;
	}
	
	public void set_level(ATileMap tilemap) {
		
		this._tileMap = tilemap;
		this._tile = tilemap.get_entryTile();
	}
	
	public BufferedImage getSpriteUp()
	{
		if(this._upMoves == 3)
			this._upMoves = 0;
		
		else
			this._upMoves++;
		
		return _spriteSheet.getSprite(0+_spriteOffset*this._upMoves, 143, 32, 48);
	}
	public BufferedImage getSpriteLeft()
	{
		if(this._leftMoves == 3)
			this._leftMoves = 0;
		
		else
			this._leftMoves++;
		return _spriteSheet.getSprite(0+_spriteOffset*this._leftMoves, 49, 32, 48);
	}
	public BufferedImage getSpriteRight()
	{
		if(this._rightMoves == 3)
			this._rightMoves = 0;
		
		else
			this._rightMoves++;
		return _spriteSheet.getSprite(0+_spriteOffset*this._rightMoves, 97, 32, 48);
	}
	public BufferedImage getSpriteDown() {
		if(this._rightMoves == 3)
			this._rightMoves = 0;
		
		else
			this._rightMoves++;
		return _spriteSheet.getSprite(0+_spriteOffset*this._downMoves, 0, 32, 48);
	}
}