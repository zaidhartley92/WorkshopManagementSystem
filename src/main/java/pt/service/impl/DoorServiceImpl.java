package pt.service.impl;

import pt.domain.Door;
import pt.repository.DoorRepository;
import pt.repository.impl.DoorRepositoryImpl;
import pt.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DoorServiceImpl implements DoorService {

    @Autowired
    @Qualifier("DoorRepo")
    private static DoorServiceImpl service = null;
    private DoorRepository repository;

    private DoorServiceImpl(){
        this.repository = DoorRepositoryImpl.getRepository();
    }

    public static DoorService getService(){
        if (service == null) service = new DoorServiceImpl();
        return service;
    }

    @Override
    public Door create(Door door) {
        return this.repository.create(door);
    }

    @Override
    public Door update(Door door) {
        return this.repository.update(door);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Door read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Door> getAll() {
        return repository.getAll();
    }

}