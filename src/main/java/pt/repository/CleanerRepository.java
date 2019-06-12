package pt.repository;

import pt.domain.Cleaner;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CleanerRepository extends IRepository<Cleaner, String>{

    Set<Cleaner> getAll();

}