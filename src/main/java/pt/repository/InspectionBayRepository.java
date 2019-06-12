package pt.repository;

import pt.domain.InspectionBay;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface InspectionBayRepository extends IRepository<InspectionBay, String>{

    Set<InspectionBay> getAll();

}