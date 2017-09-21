package game;


/**
 * @author chris
 *
 */
public abstract class ALootFactory implements I_LootFactory {

	private AItem _loot;
	private java.util.List<AItem> _lootList;
	
	/* (non-Javadoc)
	 * @see I_LootFactory#getLoot()
	 */
	@Override
	public AItem getLoot(int i) {
		// TODO Auto-generated method stub
		return _loot;
	}

	/* (non-Javadoc)
	 * @see I_LootFactory#getLoot_desc()
	 */
	@Override
	public String getLoot_desc(int i) {
		// TODO Auto-generated method stub
		return _lootList.get(i).get_itemdesc();
	}

	/* (non-Javadoc)
	 * @see I_LootFactory#getLoot_bonus()
	 */
	@Override
	public Bonus getLoot_bonus(int i) {
		// TODO Auto-generated method stub
		return _lootList.get(i).get_itembonus();
	}

	public void addLoot(AItem loot) {
		// TODO Auto-generated method stub
		
	}

}
