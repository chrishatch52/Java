


public class SubmarineUBoat extends A_Submarine implements I_Secondary_Powerplant, I_PowerplantReciprocatingDiesel,
                                                           I_PowerplantElectric
{

	protected A_Powerplant second_;
	protected boolean primary_op_;
	
	
	public SubmarineUBoat(String input, A_Powerplant prim, A_Powerplant sec) {
		super(input, prim);
		if(prim==sec)
		{
			throw new RuntimeException("cannot install one powerplant in two spots");
		}
		installPowerplantSecondary(sec);
		second_.setHost(this);
		isPrimaryOrSecondary(true);
	}
	
	public A_Powerplant getPowerplantPrimary()
	{
		if(!this.hasPowerplant())
		{
			throw new RuntimeException("no primary powerplant installed");
		}
		return super.getPowerplant();
	}
	
	public A_Powerplant getPowerplantSecondary()
	{
		if(!this.hasPowerplantSecondary())
		{
			throw new RuntimeException("no secondary powerplant installed");
		}
		return this.second_;
	}
	
	public void isPrimaryOrSecondary(boolean is_)
	{
        this.primary_op_ = is_ ? true : false;
	}
	
	public boolean isPrimaryOrSecondary()
	{
		return primary_op_;
	}
	
	public boolean hasPowerplantPrimary() 
	{	
		return (super.getPowerplant() == null);
	}
	
	public boolean hasPowerplantSecondary() 
	{	
		return (this.second_ == null);
	}
	
	public void removePowerplantPrimary()
	{
		if(this.hasPowerplant())
		{
			throw new RuntimeException("no installed powerplant");
		}
		else
		{
			this.getPowerplant().removeHost();
			this.removePowerplant();
		}
	}
	
	public void removePowerplantSecondary()
	{
		if(this.hasPowerplant())
		{
			throw new RuntimeException("no installed secondary powerplant");
		}
		else
		{
			this.getPowerplantSecondary().removeHost();
			this.second_ = null;
		}
	}

   	public void installPowerplantPrimary(A_Powerplant p_to_install)
	{
		if(this.hasPowerplant())
		{
            if(ifPrimaryIsReciprocatingDiesel(p_to_install))
                this.installPowerplant(p_to_install);
            else
                throw new RuntimeException("incorrect powerplant");
		}
		else
		{
			throw new RuntimeException("primary powerplant" + this.pow_plant_.getID_() + "already installed");
		}
	}
	
	public void installPowerplantSecondary(A_Powerplant s_to_install)
	{
		if(this.hasPowerplantSecondary())
		{
            if(ifSecondaryIsElectric(s_to_install))
			    this.second_ = s_to_install;
            else
                throw new RuntimeException("incorrect powerplant");
		}
		else
		{
			throw new RuntimeException("secondary powerplant" + this.second_.getID_() + "already installed");
		}
	}
	
	public void move()
	{
		if(isPrimaryOrSecondary())
		{
			super.move();
		}
		else
		{
			System.out.println(this.getSaltID() + this.second_.generate());
		}
	}

    @Override
    public boolean ifSecondaryIsElectric(A_Powerplant to_check) {
        return (to_check instanceof PowerplantElectric);
    }

    @Override
    public boolean ifPrimaryIsReciprocatingDiesel(A_Powerplant to_check) {
        return (to_check instanceof PowerplantReciprocatingDiesel);
    }
}
