package game;



public abstract class AGameCharacterFactory implements I_GameCharacterFactory {

		private String _groupType;
		private GroupLocation _myGroupLocation;
		/**
		 * 
		 * @return
		 */
		public String get_groupType() {
			return _groupType;
		}
		/**
		 * 
		 * @param _groupType
		 */
		public void set_groupType(String _groupType) {
			this._groupType = _groupType;
		}
		/**
		 * 
		 * @return GroupLocation returns location of group good or bad.
		 */
		public GroupLocation get_myGroupLocation() {
			return _myGroupLocation;
		}
		/**
		 * 
		 * @param _myGroupLocation sets location of group good or bad.
		 */
		public void set_myGroupLocation(GroupLocation _myGroupLocation) {
			this._myGroupLocation = _myGroupLocation;
		}

}
