package pt.repository;

import pt.domain.Part;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PartRepository extends IRepository<Part, String>{

    Set<Part> getAll();

}