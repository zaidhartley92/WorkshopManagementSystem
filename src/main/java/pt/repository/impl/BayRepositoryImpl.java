package pt.repository.impl;

import pt.domain.Bay;
import pt.repository.BayRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("BayRepo")
public class BayRepositoryImpl implements BayRepository {

    private static BayRepositoryImpl repository = null;
    private Set<Bay> bays;

    private BayRepositoryImpl(){
        this.bays = new HashSet<>();
    }

    public static BayRepositoryImpl getRepository(){
        if (repository == null) repository = new BayRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Bay> getAll() {
        return this.bays;
    }

    @Override
    public Bay create(Bay bay) {
        this.bays.add(bay);
        return bay;
    }

    @Override
    public Bay update(Bay bay) {

        Bay[] cloneOfBays = bays.toArray(new Bay[bays.size()]);
        for (int i = 0; i<cloneOfBays.length;i++) {
            if (cloneOfBays[i].equals(bay)) {
                bays.remove(cloneOfBays[i]);
            }
        }
        return create(bay);
    }

    @Override
    public void delete(String bayId) {
        Bay[] cloneOfBays = bays.toArray(new Bay[bays.size()]);
        for (int i = 0; i<cloneOfBays.length;i++) {
            if (cloneOfBays[i].getBayId() == bayId) {
                if (bays.contains(cloneOfBays[i])){
                    bays.remove(cloneOfBays[i]);
                }
            }
        }
    }

    @Override
    public Bay read(String bayId) {

        Bay bayToReturn = null;

        Bay[] cloneOfBays = bays.toArray(new Bay[bays.size()]);

        for (int i = 0; i<cloneOfBays.length;i++) {
            if (cloneOfBays[i].getBayId() == bayId) {
                bayToReturn = cloneOfBays[i];
            }
        }

        return bayToReturn;
    }
}