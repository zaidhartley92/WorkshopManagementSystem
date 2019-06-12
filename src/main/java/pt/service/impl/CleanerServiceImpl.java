package pt.service.impl;

import pt.domain.Cleaner;
import pt.repository.CleanerRepository;
import pt.repository.impl.CleanerRepositoryImpl;
import pt.service.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CleanerServiceImpl implements CleanerService {

    @Autowired
    @Qualifier("CleanerRepo")
    private static CleanerServiceImpl service = null;
    private CleanerRepository repository;

    private CleanerServiceImpl(){
        this.repository = CleanerRepositoryImpl.getRepository();
    }

    public static CleanerService getService(){
        if (service == null) service = new CleanerServiceImpl();
        return service;
    }

    @Override
    public Cleaner create(Cleaner cleaner) {
        return this.repository.create(cleaner);
    }

    @Override
    public Cleaner update(Cleaner cleaner) {
        return this.repository.update(cleaner);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Cleaner read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Cleaner> getAll() {
        return repository.getAll();
    }

}