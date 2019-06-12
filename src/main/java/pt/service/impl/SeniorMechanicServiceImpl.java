package pt.service.impl;

import pt.domain.SeniorMechanic;
import pt.repository.SeniorMechanicRepository;
import pt.repository.impl.SeniorMechanicRepositoryImpl;
import pt.service.SeniorMechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SeniorMechanicServiceImpl implements SeniorMechanicService {

    @Autowired
    @Qualifier("SeniorMechanicRepo")
    private static SeniorMechanicServiceImpl service = null;
    private SeniorMechanicRepository repository;

    private SeniorMechanicServiceImpl(){
        this.repository = SeniorMechanicRepositoryImpl.getRepository();
    }

    public static SeniorMechanicService getService(){
        if (service == null) service = new SeniorMechanicServiceImpl();
        return service;
    }

    @Override
    public SeniorMechanic create(SeniorMechanic seniorMechanic) {
        return this.repository.create(seniorMechanic);
    }

    @Override
    public SeniorMechanic update(SeniorMechanic seniorMechanic) {
        return this.repository.update(seniorMechanic);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public SeniorMechanic read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<SeniorMechanic> getAll() {
        return repository.getAll();
    }

}