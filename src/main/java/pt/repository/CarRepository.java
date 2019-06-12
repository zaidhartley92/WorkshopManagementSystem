package pt.repository;

import pt.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CarRepository extends IRepository<Car, String>{

    Set<Car> getAll();

}