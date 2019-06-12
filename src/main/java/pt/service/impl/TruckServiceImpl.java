package pt.service.impl;

import pt.domain.Truck;
import pt.repository.TruckRepository;
import pt.repository.impl.TruckRepositoryImpl;
import pt.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    @Qualifier("TruckRepo")
    private static TruckServiceImpl service = null;
    private TruckRepository repository;

    private TruckServiceImpl(){
        this.repository = TruckRepositoryImpl.getRepository();
    }

    public static TruckService getService(){
        if (service == null) service = new TruckServiceImpl();
        return service;
    }

    @Override
    public Truck create(Truck truck) {
        return this.repository.create(truck);
    }

    @Override
    public Truck update(Truck truck) {
        return this.repository.update(truck);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Truck read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Truck> getAll() {
        return repository.getAll();
    }

}