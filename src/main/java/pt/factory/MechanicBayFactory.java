package pt.factory;

import pt.domain.MechanicBay;
import pt.util.Misc;

public class MechanicBayFactory {
    public static MechanicBay getMechanicBay(String Name) {
        return new MechanicBay.Builder().mechanicBayId(Misc.generateId())
                .name(Name)
                .build();
    }

}
