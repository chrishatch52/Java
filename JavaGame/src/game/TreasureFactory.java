package game;

/**
 * @author chris
 *
 */
public class TreasureFactory implements I_TreasureFactory {

	private java.util.List<AItem> _armor;
	private java.util.List<AItem> _weapon;
	private java.util.List<AItem> _upgrade;
	private AItem _treasureItem;
	private GoodGuyFactory _gguys;
	/**
	 * 
	 */
	public TreasureFactory(GoodGuyFactory gguys) 
	{
		_armor = new java.util.ArrayList<AItem>();
		_weapon = new java.util.ArrayList<AItem>();
		_upgrade = new java.util.ArrayList<AItem>();
		_gguys = gguys;
		for(AGoodGuy gg : _gguys.get_goodGuys())
		{
			_treasureItem = make_armor(gg.get_charType());
			_treasureItem.set_imageString(gg.get_charType() + ".png");
			_armor.add(_treasureItem);
			_treasureItem = make_weapon(gg.get_charType());
			_treasureItem.set_imageString(gg.get_charType() + ".png");
			_weapon.add(_treasureItem);
			_treasureItem = make_upgrade(gg.get_charType());
			_treasureItem.set_imageString(gg.get_charType() + ".png");
			_upgrade.add(_treasureItem);
		}
	}

	public AArmor make_armor(String type) {
		
		switch(type)
		{
			case "knight":
				return new HeavyPlateArmor();//enchanted strength
			case "paladin":
				return new HeavyPlateArmor();//enchanted health
			case "firemage":
				return new Leather_MailArmor();//enchanted fire
			case "icemage":
				return new Leather_MailArmor();//enchanted ice
			case "hunter":
				return new LightPlateArmor();//enchanted
			case "rogue":
				return new LightPlateArmor();//enchanted
			case "shadowwizard":
				return new ClothArmor();//enchanted magic + 3
			case "whitewizard":
				return new ClothArmor();//enchanted magic + 5
		}
		return null;
	}

	public AWeapon make_weapon(String type) {
		
		switch(type)
		{
			case "knight":
				return new BroadSword();//enchanted strength
			case "paladin":
				return new PikeStaff();//enchanted health
			case "firemage":
				return new Dagger();//enchanted fire
			case "icemage":
				return new Dagger();//enchanted ice
			case "hunter":
				return new LongBow();//enchanted
			case "rogue":
				return new BowieKnife();//enchanted
			case "shadowwizard":
				return new GnarledStaff();//enchanted magic + 5
			case "whitewizard":
				return new GnarledStaff();//enchanted magic + 3
		}
		return null;
	}
	
	public AItem make_upgrade(String type) {
		
		switch(type)
		{
			case "knight":
				return new Shield("Twin Tower", "Great", new Bonus(null, new DefenseBonus(10, "prot"), new MagicBonus(10, "iceprot/fireprot")));//enchanted
			case "paladin":
				return new Shield("Holy Shield", "Great", new Bonus(new AttackBonus(2, "attack"), new DefenseBonus(5, "prot"), new MagicBonus(5, "iceprot/fireprot")));//enchanted
			case "firemage":
				return new Potion("Fire Bomb", new Bonus(null,null,new MagicBonus(5, "firedmg")));
			case "icemage":
				return new Potion("Icicle", new Bonus(null,null,new MagicBonus(5, "icedmg")));
			case "hunter":
				return new ExplodingArrows();
			case "rogue":
				return new ThrowingKnife();
			case "shadowwizard":
				return new Potion("Magic Potion", new Bonus(null,null,new MagicBonus(3,"dmg")));
			case "whitewizard":
				return new Potion("Magic Potion", new Bonus(null,null,new MagicBonus(3,"dmg")));
			default:
				return new Potion("Health Potion", new Bonus(null,new DefenseBonus(25, "prot"),null));
		}
	}

	public java.util.List<AItem> get_armor() {
		return _armor;
	}

	public java.util.List<AItem> get_weapon() {
		return _weapon;
	}
	public java.util.List<AItem> get_upgrade() {
		return _upgrade;
	}

	public java.util.List<AGoodGuy> get_gguys()
	{
		return _gguys.get_goodGuys();
	}
}
