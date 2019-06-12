package pt.service;
import pt.domain.TraineeMechanic;

import java.util.Set;

public interface TraineeMechanicService extends IService<TraineeMechanic, String>{
    Set<TraineeMechanic> getAll();
}
