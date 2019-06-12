package pt.factory;

import pt.domain.Door;
import pt.util.Misc;

public class DoorFactory {
    public static Door getDoor(String Name) {
        return new Door.Builder().doorId(Misc.generateId())
                .name(Name)
                .build();
    }

}
