/**
 * 
 */
package gfx;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;

import game.ALevel;
import game.BattleArena;
import game.TreasureChest;


/**
 * @author chris
 *
 */
public class RegTileMap extends ATileMap {
	
	private java.util.List<AWalkableTile> _regMapTiles;
	private java.util.List<ExitTile> _regDoorTiles;
	private java.util.List<ExitTile> _bossDoorTiles;
	private int _num_battleArenas;
	private String[] _bossLevels = {"bosslvl_one", "bosslvl_two", "bosslvl_three"};
	private int i;

	public RegTileMap(String path, ALevel level) {
		super(path, level);
		set_regDoorTiles(new java.util.ArrayList<ExitTile>());
		if(_bossDoorTiles == null)
			_bossDoorTiles = new java.util.ArrayList<ExitTile>();
		
		_regMapTiles = new java.util.ArrayList<AWalkableTile>();
		loadMap(path, level);
		i = 0;
		for(ExitTile et : _regDoorTiles)
		{
			et.set_nextLevel("opening");
		}
		for(ExitTile et : _bossDoorTiles)
		{
			et.set_nextLevel(_bossLevels[i++]);
		}
		set_entryTile(_regDoorTiles.get(0));
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
							temp.set_blocked(false);
							this.get_tiles().add(temp);
							
						}else if(id==3){
							temp = new NormalTile(WaterTile.flyWeightWaterTile(), new Rectangle(col*32,row*32,32,32));
							this.get_tiles().add(temp);
							
						}else if(id==4){
							temp = new ExitTile(DoorTile.flyWeightDoorTile(), new Rectangle(col*32,row*32,32,32),level.get_levelName());
							temp.set_is_door(true);
							if(this.get_num_doors() == 0)
							{
								temp.set_blocked(false);
								_regDoorTiles.add((ExitTile)temp);
							}
							else if(get_num_doors() == 1)
							{
								_bossDoorTiles.add((ExitTile)temp);
							}																			
							this.set_num_doors(this.get_num_doors() + 1);
							this.get_tiles().add(temp);
						}else if(id == 5){
							temp = new BonusTile(FlowerTile.flyWeightFlowerTile(), new Rectangle(col*32,row*32,32,32), true);
							switch(this._num_battleArenas)
							{
							case 0:
								((BonusTile)temp).set_arena(new BattleArena(get_level().get_goodGuys(), get_level().get_badgroupone()));
								break;
							case 1:
								((BonusTile)temp).set_arena(new BattleArena(get_level().get_goodGuys(), get_level().get_badgrouptwo()));
								break;
							case 2:
								((BonusTile)temp).set_arena(new BattleArena(get_level().get_goodGuys(), get_level().get_badgroupthree()));
								break;
							}
							this._num_battleArenas++;
							if(this._num_battleArenas == 3)
								this._num_battleArenas = 0;
							
							temp.set_bonus(true);
							temp.set_blocked(false);
							this.get_tiles().add(temp);
						}else if(id == 6){
							temp = new BonusTile(FlowerTile.flyWeightFlowerTile(), new Rectangle(col*32,row*32,32,32), false);
							((BonusTile)temp).set_chest(new TreasureChest(get_level().get_goodGuys()));;
							temp.set_bonus(true);
							temp.set_blocked(false);
							this.get_tiles().add(temp);
						}else if(id == 7){
							temp = new NormalTile(RoseTile.flyWeightRoseTile(), new Rectangle(col*32,row*32,32,32));
							temp.set_blocked(false);
							this.get_tiles().add(temp);
						}else if(id == 8){
							temp = new ExitTile(DoorTile.flyWeightDoorTile(), new Rectangle(col*32,row*32,32,32), get_level().get_levelName());
							temp.set_is_door(true);
							temp.set_blocked(false);
							((ExitTile)temp).set_nextLevelEntryTile(this.get_entryTile());
							_bossDoorTiles.add((ExitTile)temp);
							
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
	
	public java.util.List<AWalkableTile> get_tiles()
	{
		return _regMapTiles;
	}
	
	public java.util.List<ExitTile> get_regDoorTiles() {
		return _regDoorTiles;
	}

	public void set_regDoorTiles(java.util.List<ExitTile> _regDoorTiles) {
		this._regDoorTiles = _regDoorTiles;
	}
	public java.util.List<ExitTile> get_bossDoorTiles() {
		return _bossDoorTiles;
	}
}
