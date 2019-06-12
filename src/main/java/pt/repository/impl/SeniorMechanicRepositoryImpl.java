package pt.repository.impl;

import pt.domain.SeniorMechanic;
import pt.repository.SeniorMechanicRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("SeniorMechanicRepo")
public class SeniorMechanicRepositoryImpl implements SeniorMechanicRepository {

    private static SeniorMechanicRepositoryImpl repository = null;
    private Set<SeniorMechanic> seniorMechanics;

    private SeniorMechanicRepositoryImpl(){
        this.seniorMechanics = new HashSet<>();
    }

    public static SeniorMechanicRepositoryImpl getRepository(){
        if (repository == null) repository = new SeniorMechanicRepositoryImpl();
        return repository;
    }

    @Override
    public Set<SeniorMechanic> getAll() {
        return this.seniorMechanics;
    }

    @Override
    public SeniorMechanic create(SeniorMechanic seniorMechanic) {
        this.seniorMechanics.add(seniorMechanic);
        return seniorMechanic;
    }

    @Override
    public SeniorMechanic update(SeniorMechanic seniorMechanic) {

        SeniorMechanic[] cloneOfSeniorMechanics = seniorMechanics.toArray(new SeniorMechanic[seniorMechanics.size()]);
        for (int i = 0; i<cloneOfSeniorMechanics.length;i++) {
            if (cloneOfSeniorMechanics[i].equals(seniorMechanic)) {
                seniorMechanics.remove(cloneOfSeniorMechanics[i]);
            }
        }
        return create(seniorMechanic);
    }

    @Override
    public void delete(String seniorMechanicId) {
        SeniorMechanic[] cloneOfSeniorMechanics = seniorMechanics.toArray(new SeniorMechanic[seniorMechanics.size()]);
        for (int i = 0; i<cloneOfSeniorMechanics.length;i++) {
            if (cloneOfSeniorMechanics[i].getSeniorMechanicId() == seniorMechanicId) {
                if (seniorMechanics.contains(cloneOfSeniorMechanics[i])){
                    seniorMechanics.remove(cloneOfSeniorMechanics[i]);
                }
            }
        }
    }

    @Override
    public SeniorMechanic read(String seniorMechanicId) {

        SeniorMechanic seniorMechanicToReturn = null;

        SeniorMechanic[] cloneOfSeniorMechanics = seniorMechanics.toArray(new SeniorMechanic[seniorMechanics.size()]);

        for (int i = 0; i<cloneOfSeniorMechanics.length;i++) {
            if (cloneOfSeniorMechanics[i].getSeniorMechanicId() == seniorMechanicId) {
                seniorMechanicToReturn = cloneOfSeniorMechanics[i];
            }
        }

        return seniorMechanicToReturn;
    }
}
