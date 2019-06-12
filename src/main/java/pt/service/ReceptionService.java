package pt.service;
import pt.domain.Reception;

import java.util.Set;

public interface ReceptionService extends IService<Reception, String>{
    Set<Reception> getAll();
}
