/**
 * Created by copelong on 10/31/14.
 */
public class PowerplantTurbojet extends A_Powerplant {

    public PowerplantTurbojet(String id)
    {
        super(id);
    }

    @Override
    public String generate() {
        return "exhausting a jet";
    }
}
