/**
 * Created by copelong on 10/31/14.
 */
public class PowerplantReciprocatingGas extends A_Powerplant
{

    public PowerplantReciprocatingGas(String id)
    {
        super(id);
    }

    @Override
    public String generate()
    {
        return "vroom vroom!";
    }
}
