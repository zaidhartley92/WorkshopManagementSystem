package pt.service.impl;

import pt.domain.TraineeMechanic;
import pt.repository.TraineeMechanicRepository;
import pt.repository.impl.TraineeMechanicRepositoryImpl;
import pt.service.TraineeMechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TraineeMechanicServiceImpl implements TraineeMechanicService {

    @Autowired
    @Qualifier("TraineeMechanicRepo")
    private static TraineeMechanicServiceImpl service = null;
    private TraineeMechanicRepository repository;

    private TraineeMechanicServiceImpl(){
        this.repository = TraineeMechanicRepositoryImpl.getRepository();
    }

    public static TraineeMechanicService getService(){
        if (service == null) service = new TraineeMechanicServiceImpl();
        return service;
    }

    @Override
    public TraineeMechanic create(TraineeMechanic traineeMechanic) {
        return this.repository.create(traineeMechanic);
    }

    @Override
    public TraineeMechanic update(TraineeMechanic traineeMechanic) {
        return this.repository.update(traineeMechanic);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public TraineeMechanic read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<TraineeMechanic> getAll() {
        return repository.getAll();
    }

}