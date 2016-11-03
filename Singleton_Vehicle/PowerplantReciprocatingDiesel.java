/**
 * Created by copelong on 10/30/14.
 */
public class PowerplantReciprocatingDiesel extends A_Powerplant
{
    public PowerplantReciprocatingDiesel(String id)
    {
        super(id);
    }

    @Override
    public String generate()
    {
        return ": chattering away";
    }
}
