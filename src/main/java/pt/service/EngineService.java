package pt.service;
import pt.domain.Engine;

import java.util.Set;

public interface EngineService extends IService<Engine, String>{

    Set<Engine> getAll();
}
