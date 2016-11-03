/**
 * Created by copelong on 10/31/14.
 */
public class PowerplantGasTurbine extends A_Powerplant
{
    public PowerplantGasTurbine(String id)
    {
        super(id);
    }

    @Override
    public String generate()
    {
        return "spinning a gas turbine";
    }
}
