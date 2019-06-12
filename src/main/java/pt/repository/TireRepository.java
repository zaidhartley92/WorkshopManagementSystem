package pt.repository;

import pt.domain.Tire;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TireRepository extends IRepository<Tire, String>{

    Set<Tire> getAll();

}