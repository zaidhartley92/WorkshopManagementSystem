package pt.service.impl;

import pt.domain.Tire;
import pt.repository.TireRepository;
import pt.repository.impl.TireRepositoryImpl;
import pt.service.TireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TireServiceImpl implements TireService {

    @Autowired
    @Qualifier("TireRepo")
    private static TireServiceImpl service = null;
    private TireRepository repository;

    private TireServiceImpl(){
        this.repository = TireRepositoryImpl.getRepository();
    }

    public static TireService getService(){
        if (service == null) service = new TireServiceImpl();
        return service;
    }

    @Override
    public Tire create(Tire tire) {
        return this.repository.create(tire);
    }

    @Override
    public Tire update(Tire tire) {
        return this.repository.update(tire);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Tire read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Tire> getAll() {
        return repository.getAll();
    }

}