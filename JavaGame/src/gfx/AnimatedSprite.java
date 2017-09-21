package gfx;



import java.awt.image.BufferedImage;

/**
 * 
 */

/**
 * @author chris
 *
 */
public class AnimatedSprite extends ASprite {

	public static final int MOVE_UP = 0, MOVE_RIGHT = 1, MOVE_DOWN = 2, MOVE_LEFT = 3;
	private int _frameNumber;
    private int _frameWidth;
    private int _frameHeight;
    private int _frameX;
    private int _frameY;
    private int _totalWidth;
    private int _totalHeight;
    private int _totalFrames;
    //private ATile _tile;
	/**
	 * @param width
	 * @param height
	 * @param doubleBuffer
	 */
	public AnimatedSprite(int totalFrames, int frameWidth,
						  int frameHeight, int totalWidth,
						  int totalHeight, BufferedImage doubleBuffer) {
		super(totalWidth, totalHeight, doubleBuffer);
		this._frameWidth = frameWidth;
        this._frameHeight = frameHeight;
        this._frameX = 0;
        this._frameY = 0;
        this._frameNumber = 0;
        this._totalFrames = totalFrames;
        this._totalWidth = totalWidth;
        this._totalHeight = totalHeight;
	}
	/*
	public void navigate(int nav, int scale){
		//add tile bounding logic here
		switch(nav){
			default:
				System.out.println("Not navigating..?");
				break;
			case MOVE_UP:
				if(!_tile.get_north().is_blocked())
					this._frameY-=32*scale;
				break;
			case MOVE_RIGHT:
				if(!_tile.get_west().is_blocked())
					this._frameX+=32*scale;
				break;
			case MOVE_DOWN:
				if(!_tile.get_south().is_blocked())
					this._frameY+=32*scale;
				break;
			case MOVE_LEFT:
				if(!_tile.get_west().is_blocked())
					this._frameX-=32*scale;
				break;
				
		}
	}
	*/
	public int get_frameNumber() {
		return _frameNumber;
	}
	public void set_frameNumber(int _frameNumber) {
		this._frameNumber = _frameNumber;
	}
	public int get_frameWidth() {
		return _frameWidth;
	}
	public void set_frameWidth(int _frameWidth) {
		this._frameWidth = _frameWidth;
	}
	public int get_frameHeight() {
		return _frameHeight;
	}
	public void set_frameHeight(int _frameHeight) {
		this._frameHeight = _frameHeight;
	}
	public int get_frameX() {
		return _frameX;
	}
	public void set_frameX(int _frameX) {
		this._frameX = _frameX;
	}
	public int get_frameY() {
		return _frameY;
	}
	public void set_frameY(int _frameY) {
		this._frameY = _frameY;
	}
	public int get_totalWidth() {
		return _totalWidth;
	}
	public void set_totalWidth(int _totalWidth) {
		this._totalWidth = _totalWidth;
	}
	public int get_totalHeight() {
		return _totalHeight;
	}
	public void set_totalHeight(int _totalHeight) {
		this._totalHeight = _totalHeight;
	}
	public int get_totalFrames() {
		return _totalFrames;
	}
	public void set_totalFrames(int _totalFrames) {
		this._totalFrames = _totalFrames;
	}
	/*
	public ATile get_tile() {
		return _tile;
	}
	public void set_tile(ATile _tile) {
		this._tile = _tile;
	}
	*/
}
