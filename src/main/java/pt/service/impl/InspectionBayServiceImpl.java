package pt.service.impl;

import pt.domain.InspectionBay;
import pt.repository.InspectionBayRepository;
import pt.repository.impl.InspectionBayRepositoryImpl;
import pt.service.InspectionBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class InspectionBayServiceImpl implements InspectionBayService {

    @Autowired
    @Qualifier("InspectionBayRepo")
    private static InspectionBayServiceImpl service = null;
    private InspectionBayRepository repository;

    private InspectionBayServiceImpl(){
        this.repository = InspectionBayRepositoryImpl.getRepository();
    }

    public static InspectionBayService getService(){
        if (service == null) service = new InspectionBayServiceImpl();
        return service;
    }

    @Override
    public InspectionBay create(InspectionBay inspectionBay) {
        return this.repository.create(inspectionBay);
    }

    @Override
    public InspectionBay update(InspectionBay inspectionBay) {
        return this.repository.update(inspectionBay);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public InspectionBay read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<InspectionBay> getAll() {
        return repository.getAll();
    }

}