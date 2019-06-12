package pt.service.impl;

import pt.domain.Reception;
import pt.repository.ReceptionRepository;
import pt.repository.impl.ReceptionRepositoryImpl;
import pt.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReceptionServiceImpl implements ReceptionService {

    @Autowired
    @Qualifier("SecretaryRepo")
    private static ReceptionServiceImpl service = null;
    private ReceptionRepository repository;

    private ReceptionServiceImpl(){
        this.repository = ReceptionRepositoryImpl.getRepository();
    }

    public static ReceptionService getService(){
        if (service == null) service = new ReceptionServiceImpl();
        return service;
    }

    @Override
    public Reception create(Reception reception) {
        return this.repository.create(reception);
    }

    @Override
    public Reception update(Reception reception) {
        return this.repository.update(reception);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Reception read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Reception> getAll() {
        return repository.getAll();
    }

}