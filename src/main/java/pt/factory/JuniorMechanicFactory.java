package pt.factory;

import pt.domain.JuniorMechanic;
import pt.util.Misc;

public class JuniorMechanicFactory {
    public static JuniorMechanic getJuniorMechanic(String Name) {
        return new JuniorMechanic.Builder().juniorMechanicId(Misc.generateId())
                .name(Name)
                .build();
    }

}
