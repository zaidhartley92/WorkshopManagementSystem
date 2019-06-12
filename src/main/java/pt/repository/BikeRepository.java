package pt.repository;

import pt.domain.Bike;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BikeRepository extends IRepository<Bike, String>{

    Set<Bike> getAll();

}