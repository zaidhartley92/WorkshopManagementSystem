package pt.factory;

import pt.domain.Car;
import pt.util.Misc;

public class CarFactory {
    public static Car getCar(String carName) {
        return new Car.Builder().carId(Misc.generateId())
                .name(carName)
                .build();
    }

}