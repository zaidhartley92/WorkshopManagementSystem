package pt.repository;

import pt.domain.Reception;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ReceptionRepository extends IRepository<Reception, String>{

    Set<Reception> getAll();

}