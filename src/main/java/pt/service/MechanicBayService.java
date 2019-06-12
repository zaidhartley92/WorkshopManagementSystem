package pt.service;
import pt.domain.MechanicBay;

import java.util.Set;

public interface MechanicBayService extends IService<MechanicBay, String>{
    Set<MechanicBay> getAll();
}
