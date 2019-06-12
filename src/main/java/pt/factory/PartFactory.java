package pt.factory;

import pt.domain.Part;
import pt.util.Misc;

public class PartFactory {
    public static Part getPart(String Name) {
        return new Part.Builder().partId(Misc.generateId())
                .name(Name)
                .build();
    }

}
