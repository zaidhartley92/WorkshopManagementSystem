package pt.service;
import pt.domain.Car;

import java.util.Set;

public interface CarService extends IService<Car, String>{

    Set<Car> getAll();

}
