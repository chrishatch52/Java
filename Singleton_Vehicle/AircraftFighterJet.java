/**
 * Created by copelong on 10/31/14.
 */
public class AircraftFighterJet extends A_Aircraft implements I_PowerplantTurbofan, I_PowerplantTurbojet
{

    public AircraftFighterJet(String id, PowerplantTurbofan pp)
    {
        super(id, pp);
    }
    public AircraftFighterJet(String id, PowerplantTurbojet pp)
    {
        super(id, pp);
    }

    @Override
    public boolean ifIsPowerplantTurbofan(A_Powerplant to_check)
    {
        return (to_check instanceof PowerplantTurbofan);
    }

    @Override
    public boolean ifIsPowerplantTurbojet(PowerplantTurbojet to_check)
    {
        return (to_check instanceof PowerplantTurbojet);
    }
}
