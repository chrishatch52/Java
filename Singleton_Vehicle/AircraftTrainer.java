/**
 * Created by copelong on 10/31/14.
 */
public class AircraftTrainer extends A_Aircraft implements I_PowerplantReciprocatingDiesel,
                                                           I_PowerplantReciprocatingGas
{

    public AircraftTrainer(String id, PowerplantReciprocatingGas powplant)
    {
        super(id, powplant);
    }

    public AircraftTrainer(String id, PowerplantReciprocatingDiesel powplant)
    {
        super(id, powplant);
    }

    @Override
    public boolean ifPrimaryIsReciprocatingDiesel(A_Powerplant to_check)
    {
        return (to_check instanceof PowerplantReciprocatingDiesel);
    }

    @Override
    public boolean ifIsReciprocatingGas(A_Powerplant to_check)
    {
        return (to_check instanceof PowerplantReciprocatingGas);
    }
}
