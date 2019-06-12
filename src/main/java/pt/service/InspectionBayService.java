package pt.service;
import pt.domain.InspectionBay;

import java.util.Set;

public interface InspectionBayService extends IService<InspectionBay, String>{
    Set<InspectionBay> getAll();
}
