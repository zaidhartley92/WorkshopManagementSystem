package pt.repository.impl;

import pt.domain.Vehicle;
import pt.repository.VehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("VehicleRepo")
public class VehicleRepositoryImpl implements VehicleRepository {

    private static VehicleRepositoryImpl repository = null;
    private Set<Vehicle> vehicles;

    private VehicleRepositoryImpl(){
        this.vehicles = new HashSet<>();
    }

    public static VehicleRepositoryImpl getRepository(){
        if (repository == null) repository = new VehicleRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Vehicle> getAll() {
        return this.vehicles;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {

        Vehicle[] cloneOfVehicles = vehicles.toArray(new Vehicle[vehicles.size()]);
        for (int i = 0; i<cloneOfVehicles.length;i++) {
            if (cloneOfVehicles[i].equals(vehicle)) {
                vehicles.remove(cloneOfVehicles[i]);
            }
        }
        return create(vehicle);
    }

    @Override
    public void delete(String vehicleId) {
        Vehicle[] cloneOfVehicles = vehicles.toArray(new Vehicle[vehicles.size()]);
        for (int i = 0; i<cloneOfVehicles.length;i++) {
            if (cloneOfVehicles[i].getVehicleId() == vehicleId) {
                if (vehicles.contains(cloneOfVehicles[i])){
                    vehicles.remove(cloneOfVehicles[i]);
                }
            }
        }
    }

    @Override
    public Vehicle read(String vehicleId) {

        Vehicle vehicleToReturn = null;

        Vehicle[] cloneOfVehicles = vehicles.toArray(new Vehicle[vehicles.size()]);

        for (int i = 0; i<cloneOfVehicles.length;i++) {
            if (cloneOfVehicles[i].getVehicleId() == vehicleId) {
                vehicleToReturn = cloneOfVehicles[i];
            }
        }

        return vehicleToReturn;
    }
}