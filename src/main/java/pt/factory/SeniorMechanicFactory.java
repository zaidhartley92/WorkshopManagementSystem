package pt.factory;

import pt.domain.SeniorMechanic;
import pt.util.Misc;

public class SeniorMechanicFactory {
    public static SeniorMechanic getSeniorMechanic(String Name) {
        return new SeniorMechanic.Builder().seniorMechanicId(Misc.generateId())
                .name(Name)
                .build();
    }

}
