package pt.factory;

import pt.domain.Tool;
import pt.util.Misc;

public class ToolFactory {
    public static Tool getTool(String Name) {
        return new Tool.Builder().toolId(Misc.generateId())
                .name(Name)
                .build();
    }

}
