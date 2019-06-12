package pt.factory;

import pt.domain.Cleaner;
import pt.util.Misc;

public class CleanerFactory {
    public static Cleaner getCleaner(String Name) {
        return new Cleaner.Builder().cleanerId(Misc.generateId())
                .name(Name)
                .build();
    }

}