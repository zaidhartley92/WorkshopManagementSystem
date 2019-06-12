package pt.factory;

import pt.domain.ParkingBay;
import pt.util.Misc;

public class ParkingBayFactory {
    public static ParkingBay getParkingBay(String Name) {
        return new ParkingBay.Builder().parkingId(Misc.generateId())
                .parkingBayName(Name)
                .build();
    }

}
