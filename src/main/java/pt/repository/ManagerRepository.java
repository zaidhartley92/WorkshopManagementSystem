package pt.repository;

import pt.domain.Manager;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ManagerRepository extends IRepository<Manager, String>{

    Set<Manager> getAll();

}