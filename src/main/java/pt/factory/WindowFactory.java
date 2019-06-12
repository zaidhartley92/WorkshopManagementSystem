package pt.factory;

import pt.domain.Window;
import pt.util.Misc;

public class WindowFactory {
    public static Window getWindow(String Name) {
        return new Window.Builder().windowId(Misc.generateId())
                .name(Name)
                .build();
    }

}
