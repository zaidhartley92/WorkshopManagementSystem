package pt.factory;

import pt.domain.Bay;
import pt.util.Misc;

public class BayFactory {
    public static Bay getBay(String Name) {
        return new Bay.Builder().bayId(Misc.generateId())
                .name(Name)
                .build();
    }

}

