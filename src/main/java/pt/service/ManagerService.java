package pt.service;
import pt.domain.Manager;

import java.util.Set;

public interface ManagerService extends IService<Manager, String>{
    Set<Manager> getAll();
}
