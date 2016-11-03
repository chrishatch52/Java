/**
 * Created by copelong on 10/31/14.
 */
public class ShipAircraftCarrier extends A_Ship implements I_PowerplantNuclear
{

    public ShipAircraftCarrier(String id, A_Powerplant powplant)
    {
        super(id, powplant);
    }

    public void move()
    {
        System.out.println(this.getSaltID() + this.getPowerplant().generate());
    }

    @Override
    public boolean ifIsNuclear(A_Powerplant to_check)
    {
        return (to_check instanceof PowerplantNuclear);
    }
}
