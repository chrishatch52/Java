package gfx;

import game.ALevel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;

public class ATileMap {

	private ALevel _level;
	private int _num_doors = 0;
	private AWalkableTile _entryTile;
	private int _mapSize;
	
	
	public ATileMap(String path, ALevel level){
		
		this._level = level;
	}

	public void loadMap(String path, ALevel level){
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
							OpenTileMap._openingMapTiles.add(temp);
							
						}else if(id==2){
							temp = new NormalTile(StoneTile.flyWeightStoneTile(), new Rectangle(col*32,row*32,32,32));
							temp.set_blocked(false);
							OpenTileMap._openingMapTiles.add(temp);
							
						}else if(id==3){
							temp = new NormalTile(WaterTile.flyWeightWaterTile(), new Rectangle(col*32,row*32,32,32));
							OpenTileMap._openingMapTiles.add(temp);
							
						}else if(id==4){
							temp = new ExitTile(DoorTile.flyWeightDoorTile(), new Rectangle(col*32,row*32,32,32),_level.get_levelName());
							temp.set_is_door(true);
							if(_num_doors < 2)
								temp.set_blocked(false);
														
							ExitTile temp_exit = (ExitTile)temp;
							if(_num_doors < 4)
							{
								OpenTileMap._mainDoorTiles.add(temp_exit);
								_num_doors++;
							}
							
							OpenTileMap._openingMapTiles.add(temp);
						}else if(id == 5){
							temp = new NormalTile(FlowerTile.flyWeightFlowerTile(), new Rectangle(col*32,row*32,32,32));
							/*
							this._num_battleArenas++;
							if(this._num_battleArenas == 3)
								this._num_battleArenas = 0;
							*/
							temp.set_bonus(true);
							temp.set_blocked(false);
							OpenTileMap._openingMapTiles.add(temp);
						}else if(id == 6){
							temp = new NormalTile(FlowerTile.flyWeightFlowerTile(), new Rectangle(col*32,row*32,32,32));
							/*((BonusTile)temp).set_chest(new TreasureChest(_level.get_goodGuys()));;
							temp.set_bonus(true);
							temp.set_blocked(false);*/
							OpenTileMap._openingMapTiles.add(temp);
						}else if(id == 7){
							temp = new NormalTile(RoseTile.flyWeightRoseTile(), new Rectangle(col*32,row*32,32,32));
							temp.set_blocked(false);
							OpenTileMap._openingMapTiles.add(temp);
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
	protected void link_tiles(int col, int row)
	{
		AWalkableTile temp, temp_n, temp_e;
		int to_get = 0;
		
		for(int i = col * row; i < col * (row + 1); i++)
		{
			temp = this.get_tiles().get(i);
			
			if(row > 0)
			{
					to_get = i - (col);
					temp_n = this.get_tiles().get(to_get);
					temp.get_directions().set_north(temp_n);
					temp_n.get_directions().set_south(temp);
			}
			if(i > (col * row) && i <= (col * (row + 1)))
			{
					to_get = i - 1;
					temp_e = this.get_tiles().get(to_get);
					temp.get_directions().set_east(temp_e);
					temp_e.get_directions().set_west(temp);
			}
			
		}
	}
	
	public void set_exitTile(String level, ATileMap map) {
		
		switch(level)
		{	
			case "one":
				OpenTileMap._mainDoorTiles.get(0).set_nextLevelEntryTile(map._entryTile);
				((RegTileMap)map).get_regDoorTiles().get(0).set_nextLevelEntryTile(OpenTileMap._mainDoorTiles.get(0));
				break;
			case "two":
				OpenTileMap._mainDoorTiles.get(1).set_nextLevelEntryTile(map._entryTile);
				((RegTileMap)map).get_regDoorTiles().get(0).set_nextLevelEntryTile(OpenTileMap._mainDoorTiles.get(1));
				break;
				/*case "three":
				map._exitTile = _mainDoorTiles.get(2);
				_mainDoorTiles.get(2).set_nextLevelEntryTile(map._exitTile);
				_mainDoorTiles.get(2).set_nextLevel("three");	
				break;
			case "four":
				map._exitTile = _mainDoorTiles.get(3);
				_mainDoorTiles.get(3).set_nextLevelEntryTile(map._exitTile);
				_mainDoorTiles.get(3).set_nextLevel("four");
				break;
			case "five":
				map._exitTile = _mainDoorTiles.get(4);
				_mainDoorTiles.get(4).set_nextLevelEntryTile(map._exitTile);
				_mainDoorTiles.get(4).set_nextLevel("three");
				break;*/
		}
	}
	
	public void draw(Graphics g,int scale){
		AWalkableTile tile_temp;
		Image img_temp;
		Rectangle rect_temp;
		for(int i =0;i<get_mapSize();i++){
			tile_temp = this.get_tiles().get(i);
			img_temp = tile_temp.get_tile().getImage();
			rect_temp = tile_temp.get_rect();
			g.drawImage(img_temp,rect_temp.x*scale,rect_temp.y*scale,rect_temp.height*scale,rect_temp.width*scale,null);			
		}
	}
	public ALevel get_level() {
		return _level;
	}

	public AWalkableTile get_entryTile() {
		return _entryTile;
	}
	public void set_entryTile(AWalkableTile entry)
	{
		this._entryTile = entry;
	}

	public java.util.List<AWalkableTile> get_tiles() {
		return null;
	}

	public int get_num_doors() {
		return _num_doors;
	}

	public void set_num_doors(int _num_doors) {
		this._num_doors = _num_doors;
	}

	public int get_mapSize() {
		return _mapSize;
	}

	public void set_mapSize(int _mapSize) {
		this._mapSize = _mapSize;
	}
}
