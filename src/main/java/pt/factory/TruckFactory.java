package pt.factory;

import pt.domain.Truck;
import pt.util.Misc;

public class TruckFactory {
    public static Truck getTruck(String Name) {
        return new Truck.Builder().truckId(Misc.generateId())
                .name(Name)
                .build();
    }

}
