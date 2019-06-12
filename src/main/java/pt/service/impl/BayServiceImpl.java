package pt.service.impl;

import pt.domain.Bay;
import pt.repository.BayRepository;
import pt.repository.impl.BayRepositoryImpl;
import pt.service.BayService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BayServiceImpl implements BayService {

    @Autowired
    @Qualifier("BayRepo")
    private static BayServiceImpl service = null;
    private BayRepository repository;

    private BayServiceImpl(){
        this.repository = BayRepositoryImpl.getRepository();
    }

    public static BayServiceImpl getService(){
        if (service == null) service = new BayServiceImpl();
        return service;
    }

    @Override
    public Bay create(Bay bay) {
        return this.repository.create(bay);
    }

    @Override
    public Bay update(Bay bay) {
        return this.repository.update(bay);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Bay read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Bay> getAll() {
        return repository.getAll();
    }

}
