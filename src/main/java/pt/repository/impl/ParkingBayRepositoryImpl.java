package pt.repository.impl;

import pt.domain.ParkingBay;
import pt.repository.ParkingBayRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ParkingBayRepo")
public class ParkingBayRepositoryImpl implements ParkingBayRepository {

    private static ParkingBayRepositoryImpl repository = null;
    private Set<ParkingBay> parkingBays;

    private ParkingBayRepositoryImpl(){
        this.parkingBays = new HashSet<>();
    }

    public static ParkingBayRepositoryImpl getRepository(){
        if (repository == null) repository = new ParkingBayRepositoryImpl();
        return repository;
    }

    @Override
    public Set<ParkingBay> getAll() {
        return this.parkingBays;
    }

    @Override
    public ParkingBay create(ParkingBay parkingBay) {
        this.parkingBays.add(parkingBay);
        return parkingBay;
    }

    @Override
    public ParkingBay update(ParkingBay parkingBay) {

        ParkingBay[] cloneOfParkingBays = parkingBays.toArray(new ParkingBay[parkingBays.size()]);
        for (int i = 0; i<cloneOfParkingBays.length;i++) {
            if (cloneOfParkingBays[i].equals(parkingBay)) {
                parkingBays.remove(cloneOfParkingBays[i]);
            }
        }
        return create(parkingBay);
    }

    @Override
    public void delete(String parkingBayId) {
        ParkingBay[] cloneOfParkingBays = parkingBays.toArray(new ParkingBay[parkingBays.size()]);
        for (int i = 0; i<cloneOfParkingBays.length;i++) {
            if (cloneOfParkingBays[i].getParkingBayId() == parkingBayId) {
                if (parkingBays.contains(cloneOfParkingBays[i])){
                    parkingBays.remove(cloneOfParkingBays[i]);
                }
            }
        }
    }

    @Override
    public ParkingBay read(String parkingBayId) {

        ParkingBay parkingBayToReturn = null;

        ParkingBay[] cloneOfParkingBays = parkingBays.toArray(new ParkingBay[parkingBays.size()]);

        for (int i = 0; i<cloneOfParkingBays.length;i++) {
            if (cloneOfParkingBays[i].getParkingBayId() == parkingBayId) {
                parkingBayToReturn = cloneOfParkingBays[i];
            }
        }

        return parkingBayToReturn;
    }
}