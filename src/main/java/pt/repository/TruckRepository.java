package pt.repository;

import pt.domain.Truck;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TruckRepository extends IRepository<Truck, String>{

    Set<Truck> getAll();

}