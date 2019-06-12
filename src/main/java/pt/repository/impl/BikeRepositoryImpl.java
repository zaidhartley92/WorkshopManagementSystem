package pt.repository.impl;

import pt.domain.Bike;
import pt.repository.BikeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("BikeRepo")
public class BikeRepositoryImpl implements BikeRepository {

    private static BikeRepositoryImpl repository = null;
    private Set<Bike> bikes;

    private BikeRepositoryImpl(){
        this.bikes = new HashSet<>();
    }

    public static BikeRepositoryImpl getRepository(){
        if (repository == null) repository = new BikeRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Bike> getAll() {
        return this.bikes;
    }

    @Override
    public Bike create(Bike bike) {
        this.bikes.add(bike);
        return bike;
    }

    @Override
    public Bike update(Bike bike) {

        Bike[] cloneOfBikes = bikes.toArray(new Bike[bikes.size()]);
        for (int i = 0; i<cloneOfBikes.length;i++) {
            if (cloneOfBikes[i].equals(bike)) {
                bikes.remove(cloneOfBikes[i]);
            }
        }
        return create(bike);
    }

    @Override
    public void delete(String bikeId) {
        Bike[] cloneOfBikes = bikes.toArray(new Bike[bikes.size()]);
        for (int i = 0; i<cloneOfBikes.length;i++) {
            if (cloneOfBikes[i].getBikeId() == bikeId) {
                if (bikes.contains(cloneOfBikes[i])){
                    bikes.remove(cloneOfBikes[i]);
                }
            }
        }
    }

    @Override
    public Bike read(String bikeId) {

        Bike bikeToReturn = null;

        Bike[] cloneOfBikes = bikes.toArray(new Bike[bikes.size()]);

        for (int i = 0; i<cloneOfBikes.length;i++) {
            if (cloneOfBikes[i].getBikeId() == bikeId) {
                bikeToReturn = cloneOfBikes[i];
            }
        }

        return bikeToReturn;
    }
}