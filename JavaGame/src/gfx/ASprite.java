package gfx;

import java.awt.image.BufferedImage;

/**
 * 
 */

/**
 * @author chris
 *
 */
public abstract class ASprite {
	
	public static final int MOVE_UP = 0, MOVE_RIGHT = 1, MOVE_DOWN = 2, MOVE_LEFT = 3;

	private BufferedImage _spriteImage;
	private double _spriteXPosition;
    private double _spriteYPosition;
    private int _spriteHeight;
    private int _spriteWidth;
	/**
	 * 
	 */
	public ASprite(int width, int height, BufferedImage bufferedImage) {
		// TODO Auto-generated constructor stub
		this._spriteWidth = width;
        this._spriteHeight = height;
        this.set_spriteImage(bufferedImage);
	}
	public double get_spriteXPosition() {
		return _spriteXPosition;
	}

	public void set_spriteXPosition(double spriteXPosition) {
		this._spriteXPosition = spriteXPosition;
	}

	public double get_spriteYPosition() {
		return _spriteYPosition;
	}

	public void set_spriteYPosition(double spriteYPosition) {
		this._spriteYPosition = spriteYPosition;
	}

	public int get_spriteHeight() {
		return _spriteHeight;
	}

	public void set_spriteHeight(int spriteHeight) {
		this._spriteHeight = spriteHeight;
	}

	public int get_spriteWidth() {
		return _spriteWidth;
	}

	public void set_spriteWidth(int spriteWidth) {
		this._spriteWidth = spriteWidth;
	}

	public BufferedImage get_spriteImage() {
		return _spriteImage;
	}
	public void set_spriteImage(BufferedImage _spriteImage) {
		this._spriteImage = _spriteImage;
	}

}
