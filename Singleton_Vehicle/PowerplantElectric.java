/**
 * Created by copelong on 10/30/14.
 */
public class PowerplantElectric extends A_Powerplant
{
    public PowerplantElectric(String id)
    {
        super(id);
    }

    @Override
    public String generate()
    {
        return ": generating electricity";
    }
}
