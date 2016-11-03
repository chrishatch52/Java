/**
 * Created by copelong on 10/31/14.
 */
public class PowerplantTurboshaft extends A_Powerplant
{

    public PowerplantTurboshaft(String id)
    {
        super(id);
    }

    @Override
    public String generate()
    {
        return "spinning a shaft";
    }
}
