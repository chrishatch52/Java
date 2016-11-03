/**
 * Created by copelong on 10/31/14.
 */
public class PowerplantTurbofan extends A_Powerplant
{

    public PowerplantTurbofan(String id)
    {
        super(id);
    }

    @Override
    public String generate()
    {
        return "bypassing lots of air";
    }
}
