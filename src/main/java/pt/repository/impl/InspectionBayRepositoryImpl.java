package pt.repository.impl;

import pt.domain.InspectionBay;
import pt.repository.InspectionBayRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("InspectionBayRepo")
public class InspectionBayRepositoryImpl implements InspectionBayRepository {

    private static InspectionBayRepositoryImpl repository = null;
    private Set<InspectionBay> inspectionBays;

    private InspectionBayRepositoryImpl(){
        this.inspectionBays = new HashSet<>();
    }

    public static InspectionBayRepositoryImpl getRepository(){
        if (repository == null) repository = new InspectionBayRepositoryImpl();
        return repository;
    }

    @Override
    public Set<InspectionBay> getAll() {
        return this.inspectionBays;
    }

    @Override
    public InspectionBay create(InspectionBay inspectionBay) {
        this.inspectionBays.add(inspectionBay);
        return inspectionBay;
    }

    @Override
    public InspectionBay update(InspectionBay inspectionBay) {

        InspectionBay[] cloneOfInspectionBays = inspectionBays.toArray(new InspectionBay[inspectionBays.size()]);
        for (int i = 0; i<cloneOfInspectionBays.length;i++) {
            if (cloneOfInspectionBays[i].equals(inspectionBay)) {
                inspectionBays.remove(cloneOfInspectionBays[i]);
            }
        }
        return create(inspectionBay);
    }

    @Override
    public void delete(String inspectionBayId) {
        InspectionBay[] cloneOfInspectionBays = inspectionBays.toArray(new InspectionBay[inspectionBays.size()]);
        for (int i = 0; i<cloneOfInspectionBays.length;i++) {
            if (cloneOfInspectionBays[i].getInspectionBayId() == inspectionBayId) {
                if (inspectionBays.contains(cloneOfInspectionBays[i])){
                    inspectionBays.remove(cloneOfInspectionBays[i]);
                }
            }
        }
    }

    @Override
    public InspectionBay read(String inspectionBayId) {

        InspectionBay inspectionBayToReturn = null;

        InspectionBay[] cloneOfInspectionBays = inspectionBays.toArray(new InspectionBay[inspectionBays.size()]);

        for (int i = 0; i<cloneOfInspectionBays.length;i++) {
            if (cloneOfInspectionBays[i].getInspectionBayId() == inspectionBayId) {
                inspectionBayToReturn = cloneOfInspectionBays[i];
            }
        }

        return inspectionBayToReturn;
    }
}
