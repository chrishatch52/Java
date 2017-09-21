package game;

import java.awt.image.BufferedImage;


/**
 * @author chris
 *
 */
public abstract class AItem {

		private String _name;
		private String _desc;
		private String _condition;
		private Bonus _bonus;
		private boolean _equipped;
		private AItem next;
		private AItem prev;
		private BufferedImage _image = null;
		private String _itemImgString;
		
		public AItem() {}
		
		public AItem(String name, String description, Bonus bonus, boolean equipped, String condition)
		{
			_name = name;
			_desc = description;
			_bonus = bonus;
			_equipped = equipped;
			_condition = condition;
		}

		public String get_itemname() {
			return _name;
		}

		public String get_itemdesc() {
			return _desc;
		}

		public Bonus get_itembonus() {
			return _bonus;
		}

		public AItem getNext() {
			return next;
		}

		public void set_bonus(Bonus bonus)
		{
			this._bonus = bonus;
		}
		
		public void setNext(AItem next) {
			this.next = next;
		}

		public AItem getPrev() {
			return prev;
		}

		public void setPrev(AItem prev) {
			this.prev = prev;
		}
		
		public String getInfo()
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append("AItem Name: ");
			sb.append(get_itemname() + "\n");
			sb.append("AItem Desc: ");
			sb.append(get_itemdesc() + "\n");
			sb.append("AItem Bonus: ");
			sb.append(get_itembonus() + "\n");
			
			return sb.toString();
		}

		public boolean is_equipped() {
			return _equipped;
		}

		public void set_equipped(boolean _equipped) {
			this._equipped = _equipped;
		}

		public String get_condition() {
			return _condition;
		}

		public void set_condition(String _condition) {
			this._condition = _condition;
		}

		public BufferedImage get_image() {
			// TODO Auto-generated method stub
			return _image;
		}
		
		public void set_image(BufferedImage img)
		{
			this._image = img;
		}

		public int getImgX() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getImgY() {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getImgString() {
			// TODO Auto-generated method stub
			return _itemImgString;
		}

		public void set_imageString(String imgString) {
			// TODO Auto-generated method stub
			this._itemImgString = imgString;
		}

	}
