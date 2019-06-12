package pt.service;
import pt.domain.Tire;

import java.util.Set;

public interface TireService extends IService<Tire, String>{
    Set<Tire> getAll();
}
