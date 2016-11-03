/**
 * Created by copelong on 10/31/14.
 */
public class AircraftCommercialAirliner extends A_Aircraft implements I_PowerplantTurbofan, I_PowerplantTurboshaft
{

    public AircraftCommercialAirliner(String id, PowerplantTurbofan pp)
    {
        super(id, pp);
    }
    public AircraftCommercialAirliner(String id, PowerplantTurboshaft pp)
    {
        super(id, pp);
    }

    public void move()
    {
        System.out.println(this.getSaltID() + this.getPowerplant().generate());
    }

    @Override
    public boolean ifIsPowerplantTurbofan(A_Powerplant to_check)
    {
        return (to_check instanceof PowerplantTurbofan);
    }

    @Override
    public boolean ifIsPowerplantTurboshaft(A_Powerplant to_check)
    {
        return (to_check instanceof PowerplantTurboshaft);
    }
}
