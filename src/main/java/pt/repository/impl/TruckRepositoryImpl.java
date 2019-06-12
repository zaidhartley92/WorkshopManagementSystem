package pt.repository.impl;

import pt.domain.Truck;
import pt.repository.TruckRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("TruckRepo")
public class TruckRepositoryImpl implements TruckRepository {

    private static TruckRepositoryImpl repository = null;
    private Set<Truck> trucks;

    private TruckRepositoryImpl(){
        this.trucks = new HashSet<>();
    }

    public static TruckRepositoryImpl getRepository(){
        if (repository == null) repository = new TruckRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Truck> getAll() {
        return this.trucks;
    }

    @Override
    public Truck create(Truck truck) {
        this.trucks.add(truck);
        return truck;
    }

    @Override
    public Truck update(Truck truck) {

        Truck[] cloneOfTrucks = trucks.toArray(new Truck[trucks.size()]);
        for (int i = 0; i<cloneOfTrucks.length;i++) {
            if (cloneOfTrucks[i].equals(truck)) {
                trucks.remove(cloneOfTrucks[i]);
            }
        }
        return create(truck);
    }

    @Override
    public void delete(String truckId) {
        Truck[] cloneOfTrucks = trucks.toArray(new Truck[trucks.size()]);
        for (int i = 0; i<cloneOfTrucks.length;i++) {
            if (cloneOfTrucks[i].getTruckId() == truckId) {
                if (trucks.contains(cloneOfTrucks[i])){
                    trucks.remove(cloneOfTrucks[i]);
                }
            }
        }
    }

    @Override
    public Truck read(String truckId) {

        Truck truckToReturn = null;

        Truck[] cloneOfTrucks = trucks.toArray(new Truck[trucks.size()]);

        for (int i = 0; i<cloneOfTrucks.length;i++) {
            if (cloneOfTrucks[i].getTruckId() == truckId) {
                truckToReturn = cloneOfTrucks[i];
            }
        }

        return truckToReturn;
    }
}