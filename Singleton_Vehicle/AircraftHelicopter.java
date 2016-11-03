/**
 * Created by copelong on 10/31/14.
 */
public class AircraftHelicopter extends A_Aircraft implements I_PowerplantReciprocatingGas, I_PowerplantTurboshaft
{
    private A_Powerplant sec;

    public AircraftHelicopter(String id,
                              PowerplantReciprocatingGas primary,
                              PowerplantTurboshaft secondary)
    {
        super(id, primary);
        sec = secondary;
    }

    @Override
    public boolean ifIsReciprocatingGas(A_Powerplant to_check) {
        return (to_check instanceof PowerplantReciprocatingGas);
    }

    @Override
    public boolean ifIsPowerplantTurboshaft(A_Powerplant to_check) {
        return (to_check instanceof PowerplantTurboshaft);
    }
}
