package pt.factory;

import pt.domain.Tire;
import pt.util.Misc;

public class TireFactory {
    public static Tire getTire(String Name) {
        return new Tire.Builder().tireId(Misc.generateId())
                .name(Name)
                .build();
    }

}
