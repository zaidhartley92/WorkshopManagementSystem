package pt.repository.impl;

import pt.domain.Door;
import pt.repository.DoorRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("DoorRepo")
public class DoorRepositoryImpl implements DoorRepository {

    private static DoorRepositoryImpl repository = null;
    private Set<Door> doors;

    private DoorRepositoryImpl(){
        this.doors = new HashSet<>();
    }

    public static DoorRepositoryImpl getRepository(){
        if (repository == null) repository = new DoorRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Door> getAll() {
        return this.doors;
    }

    @Override
    public Door create(Door door) {
        this.doors.add(door);
        return door;
    }

    @Override
    public Door update(Door door) {

        Door[] cloneOfDoors = doors.toArray(new Door[doors.size()]);
        for (int i = 0; i<cloneOfDoors.length;i++) {
            if (cloneOfDoors[i].equals(door)) {
                doors.remove(cloneOfDoors[i]);
            }
        }
        return create(door);
    }

    @Override
    public void delete(String doorId) {
        Door[] cloneOfDoors = doors.toArray(new Door[doors.size()]);
        for (int i = 0; i<cloneOfDoors.length;i++) {
            if (cloneOfDoors[i].getDoorId() == doorId) {
                if (doors.contains(cloneOfDoors[i])){
                    doors.remove(cloneOfDoors[i]);
                }
            }
        }
    }

    @Override
    public Door read(String doorId) {

        Door doorToReturn = null;

        Door[] cloneOfDoors = doors.toArray(new Door[doors.size()]);

        for (int i = 0; i<cloneOfDoors.length;i++) {
            if (cloneOfDoors[i].getDoorId() == doorId) {
                doorToReturn = cloneOfDoors[i];
            }
        }

        return doorToReturn;
    }
}
