/**
 * 
 */
package gfx;

import game.GoodGuyFactory;
import game.OpeningLevel;

/**
 * @author chris
 *
 */
public class OpenTileMap extends ATileMap {

	public static OpenTileMap _openingMap;
	public static java.util.List<AWalkableTile> _openingMapTiles = new java.util.ArrayList<AWalkableTile>();
	public static java.util.List<ExitTile> _mainDoorTiles = new java.util.ArrayList<ExitTile>();
	private final String[] _levelExits = {"one","two","three","four","five"};
	private int i;
	/**
	 * @param gguys
	 */
	private OpenTileMap(GoodGuyFactory gguys) {
		super("opening_map.txt", new OpeningLevel(gguys));
		loadMap("opening_map.txt", get_level());
		i = 0;
		for(ExitTile et : _mainDoorTiles)
		{
			if(i < _levelExits.length)
				et.set_nextLevel(_levelExits[i++]);
		}
		
		set_entryTile(_openingMapTiles.get(0));
	}
	
	public static OpenTileMap getInstance(GoodGuyFactory gguys)
	{
		if(_openingMap == null)
		{
			_openingMap = new OpenTileMap(gguys);
		}
		return _openingMap;
	}
	
	@Override
	public java.util.List<AWalkableTile> get_tiles()
	{
		return _openingMapTiles;
	}

}
