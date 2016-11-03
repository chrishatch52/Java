
public abstract class A_Vehicle implements I_Identifiable {

	
	protected String identity_;
	protected String name_salt_;
	protected A_Powerplant pow_plant_;
	protected IdentifierSaltManager ism_;
	
	public A_Vehicle(String id, A_Powerplant pp)
	{
		this.identity_ = id;
		this.pow_plant_ = pp;
		pp.setHost(this);
		ism_ = IdentifierSaltManager.getInstance();
		this.name_salt_ = IdentifierSaltManager.getIDSalted(this.identity_);
	}
	
	public String getID()
	{
		return this.identity_;
	}
	
	public String getSaltID()
	{
		return this.name_salt_;
	}
	
	public A_Powerplant getPowerplant()
	{
		if(!this.hasPowerplant())
		{
			throw new RuntimeException("no installed powerplant");
		}
		return this.pow_plant_;
	}
	
	public void removePowerplant()
	{
		if(this.hasPowerplant())
		{
			throw new RuntimeException("no installed powerplant");
		}
		else
		{
			this.pow_plant_.removeHost();
			this.pow_plant_ = null;
		}
	}

	public void installPowerplant(A_Powerplant to_install)
	{
		if(this.hasPowerplant())
		{
			this.pow_plant_ = to_install;
		}
		else
		{
			throw new RuntimeException("powerplant" + this.pow_plant_.getID_() + "already installed");
		}
	}
	
	public boolean hasPowerplant() 
	{
		return (this.pow_plant_ != null);
	}
	
	public void move()
	{
		System.out.println(this.getSaltID() + this.getPowerplant().generate());
	}

    public String getID_() {  return this.identity_; }
}
