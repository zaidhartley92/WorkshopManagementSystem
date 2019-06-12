package pt.repository;

import pt.domain.ParkingBay;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ParkingBayRepository extends IRepository<ParkingBay, String>{

    Set<ParkingBay> getAll();

}