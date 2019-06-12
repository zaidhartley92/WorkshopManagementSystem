package pt.service;
import pt.domain.Truck;

import java.util.Set;

public interface TruckService extends IService<Truck, String>{
    Set<Truck> getAll();
}
