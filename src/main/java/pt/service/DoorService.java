package pt.service;
import pt.domain.Door;

import java.util.Set;

public interface DoorService extends IService<Door, String>{

    Set<Door> getAll();

}
