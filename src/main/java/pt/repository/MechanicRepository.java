package pt.repository;

import pt.domain.Mechanic;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MechanicRepository extends IRepository<Mechanic, String>{

    Set<Mechanic> getAll();

}
