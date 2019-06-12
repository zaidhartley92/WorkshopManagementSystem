package pt.factory;

import pt.domain.Reception;
import pt.util.Misc;

public class ReceptionFactory {
    public static Reception getSecretary(String Name) {
        return new Reception.Builder().secretaryId(Misc.generateId())
                .name(Name)
                .build();
    }

}
