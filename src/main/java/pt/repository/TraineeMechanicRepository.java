package pt.repository;

import pt.domain.TraineeMechanic;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TraineeMechanicRepository extends IRepository<TraineeMechanic, String>{

    Set<TraineeMechanic> getAll();

}