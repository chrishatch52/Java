
public abstract class A_Powerplant implements I_Identifiable {

	protected String identity_;
	protected A_Vehicle host_;
	
	
	public A_Powerplant(String id)
	{
		this.identity_ = id;
	}
	
	public String getID_()
	{
		return this.identity_;
	}
	
	public void setHost(A_Vehicle vehicle)
	{
		if(this.hasHost())
		{
			this.host_ = vehicle;
		}
		else
		{
			throw new RuntimeException(this.host_.getID() + " has " + this.getID_() + " installed");
		}
		
	}
	
	public A_Vehicle getHost()
	{
		if(this.hasHost())
		{
			return this.host_;
		}
		else
		{
			throw new RuntimeException(this.host_.getID());
		}
	}
	
	public void removeHost()
	{
		if(!this.hasHost())
		{
			this.host_ = null;
		}
		else
		{
			throw new RuntimeException("no host given");
		}
	}

	private boolean hasHost() 
	{
		return (this.host_ == null);
	}
	
	public abstract String generate();

}
