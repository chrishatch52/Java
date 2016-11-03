/**
 * Created by copelong on 10/31/14.
 */
public class ShipDestroyer extends A_Ship implements I_PowerplantGasTurbine
{
    public ShipDestroyer(String id, PowerplantGasTurbine powplant)
    {
        super(id, powplant);
    }

    @Override
    public void move()
    {
        System.out.println(this.getSaltID() + this.getPowerplant().generate());
    }

    @Override
    public boolean ifIsPowerplantGasTurbine(A_Powerplant to_check) {
        return (to_check instanceof PowerplantGasTurbine);
    }
}
