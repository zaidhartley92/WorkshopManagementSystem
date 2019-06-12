package pt.service;
import pt.domain.ParkingBay;

import java.util.Set;

public interface ParkingBayService extends IService<ParkingBay, String>{
    Set<ParkingBay> getAll();

}
