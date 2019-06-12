package pt.service;
import pt.domain.Bike;

import java.util.Set;

public interface BikeService extends IService<Bike, String>{

    Set<Bike> getAll();

}
