package pt.factory;

import pt.domain.Bike;
import pt.util.Misc;

public class BikeFactory {
    public static Bike getBike(String Name) {
        return new Bike.Builder().bikeId(Misc.generateId())
                .name(Name)
                .build();
    }

}

