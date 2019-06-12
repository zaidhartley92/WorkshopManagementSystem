package pt.service.impl;

import pt.domain.Part;
import pt.repository.PartRepository;
import pt.repository.impl.PartRepositoryImpl;
import pt.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    @Qualifier("PartRepo")
    private static PartServiceImpl service = null;
    private PartRepository repository;

    private PartServiceImpl(){
        this.repository = PartRepositoryImpl.getRepository();
    }

    public static PartService getService(){
        if (service == null) service = new PartServiceImpl();
        return service;
    }

    @Override
    public Part create(Part part) {
        return this.repository.create(part);
    }

    @Override
    public Part update(Part part) {
        return this.repository.update(part);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Part read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Part> getAll() {
        return repository.getAll();
    }

}