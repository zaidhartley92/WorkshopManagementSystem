package pt.repository.impl;

import pt.domain.MechanicBay;
import pt.repository.MechanicBayRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("MechanicBayRepo")
public class MechanicBayRepositoryImpl implements MechanicBayRepository {

    private static MechanicBayRepositoryImpl repository = null;
    private Set<MechanicBay> mechanicBays;

    private MechanicBayRepositoryImpl(){
        this.mechanicBays = new HashSet<>();
    }

    public static MechanicBayRepositoryImpl getRepository(){
        if (repository == null) repository = new MechanicBayRepositoryImpl();
        return repository;
    }

    @Override
    public Set<MechanicBay> getAll() {
        return this.mechanicBays;
    }

    @Override
    public MechanicBay create(MechanicBay mechanicBay) {
        this.mechanicBays.add(mechanicBay);
        return mechanicBay;
    }

    @Override
    public MechanicBay update(MechanicBay mechanicBay) {

        MechanicBay[] cloneOfMechanicBays = mechanicBays.toArray(new MechanicBay[mechanicBays.size()]);
        for (int i = 0; i<cloneOfMechanicBays.length;i++) {
            if (cloneOfMechanicBays[i].equals(mechanicBay)) {
                mechanicBays.remove(cloneOfMechanicBays[i]);
            }
        }
        return create(mechanicBay);
    }

    @Override
    public void delete(String mechanicBayId) {
        MechanicBay[] cloneOfMechanicBays = mechanicBays.toArray(new MechanicBay[mechanicBays.size()]);
        for (int i = 0; i<cloneOfMechanicBays.length;i++) {
            if (cloneOfMechanicBays[i].getMechanicBayId() == mechanicBayId) {
                if (mechanicBays.contains(cloneOfMechanicBays[i])){
                    mechanicBays.remove(cloneOfMechanicBays[i]);
                }
            }
        }
    }

    @Override
    public MechanicBay read(String mechanicBayId) {

        MechanicBay mechanicBayToReturn = null;

        MechanicBay[] cloneOfMechanicBays = mechanicBays.toArray(new MechanicBay[mechanicBays.size()]);

        for (int i = 0; i<cloneOfMechanicBays.length;i++) {
            if (cloneOfMechanicBays[i].getMechanicBayId() == mechanicBayId) {
                mechanicBayToReturn = cloneOfMechanicBays[i];
            }
        }

        return mechanicBayToReturn;
    }
}
