package pt.repository;

import pt.domain.Bay;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BayRepository extends IRepository<Bay, String>{

    Set<Bay> getAll();

}
