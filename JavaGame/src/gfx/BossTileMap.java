/**
 * 
 */
package gfx;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;

import game.ALevel;
import game.BattleArena;
import game.BossLevelOne;

/**
 * @author chris
 *
 */
public class BossTileMap extends ATileMap {

	private java.util.List<AWalkableTile> _bossMapTiles;
	private ExitTile _bossDoorTile;
	/**
	 * @param tileMapFrame 
	 * @param path
	 * @param map
	 * @param level
	 */
	public BossTileMap(TileMapFrame tileMapFrame, String path, ALevel level) {
		super(path, level);
		_bossMapTiles = new java.util.ArrayList<AWalkableTile>();
		loadMap(path, level);
		set_entryTile(_bossDoorTile);
		_bossDoorTile.set_nextLevel(tileMapFrame.get_map().get_level().get_levelName());
		_bossDoorTile.set_nextLevelEntryTile(((RegTileMap)tileMapFrame.get_map()).get_bossDoorTiles().get(0));
	}

	@Override
	public void loadMap(String path, ALevel level)
	{
		try{
			//System.out.println(path);
			BufferedReader br = new BufferedReader(new FileReader("src/gfx/" + path));
			String curLine;
			AWalkableTile temp = null;
			
			int row = 0;
			while((curLine = br.readLine())!=null){
				if(curLine.isEmpty())
					continue;
				
				String[] values = curLine.trim().split(" ");
				int col = 0;
				for(String val : values){
					if(!val.isEmpty()){
						int id = Integer.parseInt(val);
						if(id==1){
							temp = new NormalTile(GrassTile.flyWeightGrassTile(), new Rectangle(col*32,row*32,32,32));
							temp.set_blocked(false);
							this.get_tiles().add(temp);
							
						}else if(id==2){
							temp = new NormalTile(StoneTile.flyWeightStoneTile(), new Rectangle(col*32,row*32,32,32));
							this.get_tiles().add(temp);
							
						}else if(id==3){
							temp = new NormalTile(WaterTile.flyWeightWaterTile(), new Rectangle(col*32,row*32,32,32));
							
							this.get_tiles().add(temp);
							
						}else if(id==4){
							temp = new ExitTile(DoorTile.flyWeightDoorTile(), new Rectangle(col*32,row*32,32,32), get_level().get_levelName());
							temp.set_blocked(false);
							temp.set_is_door(true);
							set_bossDoorTile((ExitTile)temp);
							this.get_tiles().add(temp);
						}else if(id==5){
							temp = new BonusTile(RoseTile.flyWeightRoseTile(), new Rectangle(col*32,row*32,32,32),true);
							temp.set_bonus(true);
							temp.set_blocked(false);
							((BonusTile)temp).set_arena(new BattleArena(get_level().get_goodGuys(), ((BossLevelOne)get_level()).get_bossGroup()));
							this.get_tiles().add(temp);
						}
						col++;
					}
				}
				this.set_mapSize(col);
				link_tiles(col, row);
				row++;
			}
			this.set_mapSize((this.get_mapSize() * row));
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void set_bossDoorTile(ExitTile temp) {
		if(_bossDoorTile == null)
		{
			_bossDoorTile = temp;
		}
	}

	@Override
	public void set_exitTile(String level, ATileMap map)
	{
		_bossDoorTile.set_nextLevel(level);
		_bossDoorTile.set_nextLevelEntryTile(map.get_entryTile());
	}
	public java.util.List<AWalkableTile> get_tiles()
	{
		return _bossMapTiles;
	}

	public AWalkableTile get_exitTile() {
		return _bossDoorTile.get_nextLevelEntryTile();
	}
}
