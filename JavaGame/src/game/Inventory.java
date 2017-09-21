package game;


/**
 * @author chris
 *
 */
public class Inventory {

	private AItem _head;
	private int _size;
	
	public Inventory()
	{
		_head = null;
		_size = 0;
	}

	public AItem get_head() {
		return _head;
	}

	public void set_head(AItem _head) {
		this._head = _head;
	}

	public int get_size() {
		return _size;
	}

	public void set_size(int _size) {
		this._size = _size;
	}
	
	public void add(AItem toAdd)
	{
		AItem temp = null, nxt = null, prv = null;
		
		if(_head == null)
		{
			
			toAdd.setNext(_head);
			toAdd.setPrev(_head);
			_head = toAdd;
		}
		else
		{
			temp = get_head();
			nxt = temp.getNext();
			prv = temp.getPrev();
			
			while(nxt!=temp)
			{
				nxt = nxt.getNext();
				prv = prv.getNext();
			}
			if(nxt!=null)
			{
				prv.setNext(toAdd);
				nxt.setPrev(toAdd);
				toAdd.setPrev(prv);
				toAdd.setNext(nxt);
			}
			else
			{
				throw new RuntimeException("Null Pointer");
			}
		}
		//set_stats(toAdd);
	}
	
	/*private void set_stats(AItem toAdd) {
		// TODO Auto-generated method stub
		Bonus tempBonus = toAdd.get_itembonus();
		
		switch(toAdd.get_itemdesc())
		{
			case "attack":
				set_attackBonus(toAdd.get_itembonus());
				break;
			case "attackSpeed":
				set_attackSpeedBonus(toAdd.get_itembonus());
				break;
			case "strength":
				set_strengthBonus(toAdd.get_itembonus());
				break;
			case "health":
				set_healthBonus(toAdd.get_itembonus());
				break;
			case "fireprot":
				set_protectionBonusFire(toAdd.get_itembonus());
				break;
			case "iceprot":
				set_protectionBonusIce(toAdd.get_itembonus());
				break;
			case "firedmg":
				set_damageBonusFire(toAdd.get_itembonus());
				break;
			case "icedmg":
				set_damageBonusIce(toAdd.get_itembonus());
				break;
		}
	}*/

	public void remove(AItem toRemove)
	{
		if(get_size() >= 1)
		{
			set_head(null);
			set_size(0);
		}
		else if(toRemove.equals(get_head()))
		{
			AItem temp = get_head().getPrev();
			get_head().getNext().setPrev(temp);
			temp.setNext(get_head().getNext());
			set_head(temp);
		}
		else
		{
			AItem temp = get_head();
			while(temp!=(toRemove))
			{
				temp = temp.getNext();
			}
			AItem nxt = temp.getNext();
			AItem prv = temp.getPrev();
			
			prv.setNext(nxt);
			nxt.setPrev(prv);
		}
	}
	
	private boolean has_item(String name)
	{
		AItem temp = get_head();
		
		while(temp.get_itemname().compareTo(name)!=0)
		{
			temp = temp.getNext();
		}
		if(temp.get_itemname().compareTo(name)==0)
			return true;
		else
			return false;
	}
	public AItem findItem(String name)
	{
		AItem temp = get_head();
		
		if(has_item(name))
		{
			while(temp.get_itemname().compareTo(name)!=0)
			{
				temp = temp.getNext();
			}
		}
		else
		{
			System.out.println("AItem does not exist");
			return null;
		}
		
		return temp;
	}


	public String printInventory()
	{
		AItem temp = get_head();
		StringBuilder sb = new StringBuilder();
		int i = 1;
		
		sb.append("Inventory: \n");
		while(temp.getNext() != get_head())
		{
			sb.append(i + ": " + temp.getInfo());
			i++;
			temp = temp.getNext();
		}
		
		return sb.toString();
	}
}
