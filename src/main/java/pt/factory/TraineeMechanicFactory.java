package pt.factory;

import pt.domain.TraineeMechanic;
import pt.util.Misc;

public class TraineeMechanicFactory {
    public static TraineeMechanic getTraineeMechanic(String Name) {
        return new TraineeMechanic.Builder().traineeMechanicId(Misc.generateId())
                .name(Name)
                .build();
    }

}
