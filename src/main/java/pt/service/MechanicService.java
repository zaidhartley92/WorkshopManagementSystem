package pt.service;
import pt.domain.Mechanic;

import java.util.Set;

public interface MechanicService extends IService<Mechanic, String>{
    Set<Mechanic> getAll();
}
