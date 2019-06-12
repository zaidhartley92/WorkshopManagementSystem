package pt.factory;

import pt.domain.Vehicle;
import pt.util.Misc;

public class VehicleFactory {
    public static Vehicle getVehicle(String Name) {
        return new Vehicle.Builder().vehicleId(Misc.generateId())
                .name(Name)
                .build();
    }

}
