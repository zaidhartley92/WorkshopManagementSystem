package pt.repository.impl;

import pt.domain.Tire;
import pt.repository.TireRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("TireRepo")
public class TireRepositoryImpl implements TireRepository {

    private static TireRepositoryImpl repository = null;
    private Set<Tire> tires;

    private TireRepositoryImpl(){
        this.tires = new HashSet<>();
    }

    public static TireRepositoryImpl getRepository(){
        if (repository == null) repository = new TireRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Tire> getAll() {
        return this.tires;
    }

    @Override
    public Tire create(Tire tire) {
        this.tires.add(tire);
        return tire;
    }

    @Override
    public Tire update(Tire tire) {

        Tire[] cloneOfTires = tires.toArray(new Tire[tires.size()]);
        for (int i = 0; i<cloneOfTires.length;i++) {
            if (cloneOfTires[i].equals(tire)) {
                tires.remove(cloneOfTires[i]);
            }
        }
        return create(tire);
    }

    @Override
    public void delete(String tireId) {
        Tire[] cloneOfTires = tires.toArray(new Tire[tires.size()]);
        for (int i = 0; i<cloneOfTires.length;i++) {
            if (cloneOfTires[i].getTireId() == tireId) {
                if (tires.contains(cloneOfTires[i])){
                    tires.remove(cloneOfTires[i]);
                }
            }
        }
    }

    @Override
    public Tire read(String tireId) {

        Tire tireToReturn = null;

        Tire[] cloneOfTires = tires.toArray(new Tire[tires.size()]);

        for (int i = 0; i<cloneOfTires.length;i++) {
            if (cloneOfTires[i].getTireId() == tireId) {
                tireToReturn = cloneOfTires[i];
            }
        }

        return tireToReturn;
    }
}