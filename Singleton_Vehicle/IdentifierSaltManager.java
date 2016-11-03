
public class IdentifierSaltManager {

	private static IdentifierSaltManager ism = null;
	protected static int salt_num = 1;
	
	
	private IdentifierSaltManager(){	}//empty DVC prevents instantiation
	
	
	public static IdentifierSaltManager getInstance()
	{
		if(ism == null)
			return new IdentifierSaltManager();
		
		return ism;		
	}
	
	public static String getIDSalted(String name)
	{
		String name_salted = name;
		
		name_salted = name_salted + "#" + salt_num;
		
		salt_num = getSaltNext();
		
		return name_salted;
	}
	private static int getSaltNext() 
	{
		return salt_num += 1;
	}
}
