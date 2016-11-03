/**
 * Created by copelong on 10/31/14.
 */
public class ShipSpeedboat extends A_Ship implements I_PowerplantReciprocatingGas, I_PowerplantTurboshaft
{
    public ShipSpeedboat(String id, PowerplantReciprocatingGas powplant)
    {
        super(id, powplant);
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
