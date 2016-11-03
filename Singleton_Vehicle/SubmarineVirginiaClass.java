/**
 * Created by copelong on 10/31/14.
 */
public class SubmarineVirginiaClass extends A_Submarine implements I_PowerplantNuclear
{
    public SubmarineVirginiaClass(String id, A_Powerplant powplant)
    {
        super(id, powplant);
    }

    @Override
    public boolean ifIsNuclear(A_Powerplant to_check) {
        return (to_check instanceof PowerplantNuclear);
    }
}
