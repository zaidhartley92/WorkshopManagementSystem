package pt.factory;

import pt.domain.Manager;
import pt.util.Misc;

public class ManagerFactory {
    public static Manager getManager(String Name) {
        return new Manager.Builder().managerId(Misc.generateId())
                .name(Name)
                .build();
    }

}
