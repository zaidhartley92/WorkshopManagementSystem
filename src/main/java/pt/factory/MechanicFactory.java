package pt.factory;

import pt.domain.Mechanic;
import pt.util.Misc;

public class MechanicFactory {
    public static Mechanic getMechanic(String Name) {
        return new Mechanic.Builder().mechanicId(Misc.generateId())
                .name(Name)
                .build();
    }

}