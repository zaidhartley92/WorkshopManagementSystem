package pt.service;
import pt.domain.SeniorMechanic;

import java.util.Set;

public interface SeniorMechanicService extends IService<SeniorMechanic, String>{
    Set<SeniorMechanic> getAll();
}
