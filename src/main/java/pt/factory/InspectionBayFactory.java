package pt.factory;


import pt.domain.InspectionBay;
import pt.util.Misc;

public class InspectionBayFactory {
    public static InspectionBay getInspectionBay(String Name) {
        return new InspectionBay.Builder().inspectionBayId(Misc.generateId())
                .name(Name)
                .build();
    }

}
