/**
 * Created by copelong on 10/31/14.
 */
public class ShipYacht extends A_Ship implements I_PowerplantReciprocatingDiesel, I_PowerplantReciprocatingGas
{
    private PowerplantReciprocatingGas gas_;
    private PowerplantReciprocatingDiesel dies_;

    public ShipYacht(String id, PowerplantReciprocatingGas gas, PowerplantReciprocatingDiesel dies)
    {
        super(id, gas);
        this.dies_ = dies;
    }

    public void move()
    {
        System.out.println(this.getSaltID() + this.getPowerplant().generate());
    }

    @Override
    public boolean ifPrimaryIsReciprocatingDiesel(A_Powerplant to_check) {
        return (to_check instanceof PowerplantReciprocatingDiesel);
    }

    @Override
    public boolean ifIsReciprocatingGas(A_Powerplant to_check) {
        return (to_check instanceof PowerplantReciprocatingGas);
    }
}
