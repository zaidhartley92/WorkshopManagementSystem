package pt.service;
import pt.domain.JuniorMechanic;

import java.util.Set;

public interface JuniorMechanicService extends IService<JuniorMechanic, String>{
    Set<JuniorMechanic> getAll();
}
