/**
 * 
 */
package gfx;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author chris
 *
 */
public class TileFactory {

	public static TileFactory _tileFactory = null;
	private final MapSpriteSheet _mapSprites = new MapSpriteSheet();
	//Tile images
	private Image TILE_STONE,TILE_GRASS,TILE_WATER,TILE_DOOR,TILE_WOOD,TILE_FLOWER,TILE_ROSE,
				 TILE_GRASS_ROCK,TILE_STONE_2,TILE_STONE_3,TILE_STONE_4,TILE_WATER_ROCK,TILE_WATER_STONE;
	/**
	 * 
	 */
	private TileFactory() {
		TILE_GRASS = new ImageIcon(_mapSprites.getSprite(107, 33, 32, 32)).getImage();//1
		TILE_STONE = new ImageIcon(_mapSprites.getSprite(173, 0, 32, 32)).getImage();//2
		TILE_WATER = new ImageIcon(_mapSprites.getSprite(305,165,32,32)).getImage();//3
		
		TILE_DOOR = new ImageIcon(_mapSprites.getSprite(272,0,32,32)).getImage();//4
		TILE_WOOD = new ImageIcon(_mapSprites.getSprite(436,65,32,32)).getImage();//5
		TILE_FLOWER = new ImageIcon(_mapSprites.getSprite(74,231,32,32)).getImage();//6
		TILE_ROSE = new ImageIcon(_mapSprites.getSprite(107,231,32,32)).getImage();//7
		
		TILE_GRASS_ROCK = new ImageIcon(_mapSprites.getSprite(139,167,32,32)).getImage();//8
		TILE_STONE_2 = new ImageIcon(_mapSprites.getSprite(173,32,32,32)).getImage();//9
		TILE_STONE_3 = new ImageIcon(_mapSprites.getSprite(205,0,32,32)).getImage();//10
		TILE_STONE_4 = new ImageIcon(_mapSprites.getSprite(205,32,32,32)).getImage();//11
		TILE_WATER_ROCK = new ImageIcon(_mapSprites.getSprite(336,128,32,32)).getImage();//12
		TILE_WATER_STONE = new ImageIcon(_mapSprites.getSprite(368,65,32,32)).getImage();//13
		
		DoorTile.getTile(TILE_DOOR);
		FlowerTile.getTile(TILE_FLOWER);
		GrassTile.getTile(TILE_GRASS);
		GrassTile_Rock.getTile(TILE_GRASS_ROCK);
		RoseTile.getTile(TILE_ROSE);
		StoneTile.getTile(TILE_STONE);
		StoneTile_Two.getTile(TILE_STONE_2);
		StoneTile_Three.getTile(TILE_STONE_3);
		StoneTile_Four.getTile(TILE_STONE_4);
		WaterTile.getTile(TILE_WATER);
		WaterTile_Rock.getTile(TILE_WATER_ROCK);
		WaterTile_Stone.getTile(TILE_WATER_STONE);
		WoodTile.getTile(TILE_WOOD);
	}
	
	public static TileFactory getInstance()
	{
		if(_tileFactory == null)
		{
			_tileFactory = new TileFactory();
		}
		
		return _tileFactory;
	}

}
