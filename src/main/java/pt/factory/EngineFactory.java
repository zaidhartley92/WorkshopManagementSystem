package pt.factory;


import pt.domain.Engine;
import pt.util.Misc;

public class EngineFactory {
    public static Engine getEngine(String Name) {
        return new Engine.Builder().engineId(Misc.generateId())
                .name(Name)
                .build();
    }

}