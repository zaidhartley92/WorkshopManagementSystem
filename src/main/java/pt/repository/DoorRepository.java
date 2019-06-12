package pt.repository;

import pt.domain.Door;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DoorRepository extends IRepository<Door, String>{

    Set<Door> getAll();

}