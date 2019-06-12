package pt.service;
import pt.domain.Vehicle;

import java.util.Set;

public interface VehicleService extends IService<Vehicle, String>{
    Set<Vehicle> getAll();
}
