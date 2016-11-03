/**
 * Created by copelong on 10/31/14.
 */
public class PowerplantNuclear extends A_Powerplant
{
    public PowerplantNuclear(String id)
    {
        super(id);
    }

    @Override
    public String generate()
    {
        return "splitting atoms";
    }
}
