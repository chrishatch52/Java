package game;

import java.util.Random;

import gfx.Sprite;

/**
 * 
 */

/**
 * @author Chris
 *
 */
public abstract class AGameCharacter implements I_GameCharacter, I_StandardActions {

	private String _name;
	private String _charType;
	private Stats _stats;
	private APlayerMoveSet _playerMoves;
	private CharacterLocation _myLocation;
	private boolean _alive = true;
	private boolean _can_beAttacked = true;
	private AWeapon _weapon;
	private AArmor _armor;
	private AItem _upgrade;
	private Sprite _sprite;
	
	/* (non-Javadoc)
	 * @see I_GameCharacterFactory#get_name()
	 */
	@Override
	public String get_name() {
		return _name;
	}
	
	public void set_name(String name)
	{
		this._name = name;
	}
	public String get_charType() {
		return _charType;
	}
	public void set_charType(String _charType) {
		this._charType = _charType;
	}
	public AWeapon get_weapon() {
		return _weapon;
	}
	public void set_weapon(AWeapon weapon) {
		this._weapon = weapon;
		get_stats().upgradeWeapon(this, weapon);
	}
	public AArmor get_armor() {
		return _armor;
	}
	public void set_armor(AArmor armor) {
		this._armor = armor;
		get_stats().upgradeArmor(this, armor);
	}
	public AItem get_upgrade() {
		return _upgrade;
	}

	public void set_upgrade(AItem _upgrade) {
		this._upgrade = _upgrade;
		get_stats().upgradeStats(this, _upgrade);
	}
	public CharacterLocation get_myLocation() {
		return _myLocation;
	}
	public void set_myLocation(CharacterLocation _myLocation) {
		this._myLocation = _myLocation;
	}
	public APlayerMoveSet get_playerMoves() {
		return _playerMoves;
	}
	public void set_playerMoves(APlayerMoveSet playerMoves) {
		this._playerMoves = playerMoves;
	}
	public Stats get_stats() {
		return _stats;
	}
	public void set_stats(Stats stats) {
		this._stats = stats;
	}
	public String getInfo() {		
		return get_stats().getInfo();
	}
	@Override
	public String attack(AGameCharacter character) {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder();
		DefenseStats d_statsE = character.get_stats().get_defenseStats();
		
		if(character.is_alive())
		{
			int temphealth = d_statsE.get_health();
			int attack = (get_stats().get_attackStats().get_attackRating());;
			d_statsE.set_health(temphealth - (get_stats().get_attackStats().get_attackRating()));
			result.append(get_name() + " has hit " + character.get_name() + " for " + attack);
			if(d_statsE.get_health() == 0)
			{
				result.append(", " + get_name() + " has slain " + character.get_name());
				character.set_alive(false);
			}
		
		}		
		return result.toString();
	}
	@Override
	public String counter(AGameCharacter character) {
		
		Random r = new Random();
		int random = r.nextInt(100 - 1) + 1;
		StringBuilder result = new StringBuilder();
		if(character._can_beAttacked)
		{
			if(character.get_stats().get_rateStats().get_counterChance()*100 <= random)
			{
				return attack(character);
			}
			else if (character.get_stats().get_rateStats().get_blockChance()*100 <= random)
			{
				result.append(get_name() + "'s attack has been blocked");
			}
			else
			{
				return character.attack(this);
			}
		}
		else
		{
			result.append(character.get_name() + " cannot be attacked!");
		}
		return result.toString();
	}
	
	public boolean is_alive() {
		return _alive;
	}
	public void set_alive(boolean _alive) {
		this._alive = _alive;
	}
	public boolean is_can_beAttacked() {
		return _can_beAttacked;
	}
	public void set_can_beAttacked(boolean _can_beAttacked) {
		this._can_beAttacked = _can_beAttacked;
	}

	public Sprite get_sprite() {
		return _sprite;
	}

	public void set_sprite(Sprite _sprite) {
		this._sprite = _sprite;
	}
}
