package pt.service.impl;

import pt.domain.Car;
import pt.repository.CarRepository;
import pt.repository.impl.CarRepositoryImpl;
import pt.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    @Qualifier("CarRepo")
    private static CarServiceImpl service = null;
    private CarRepository repository;

    private CarServiceImpl(){
        this.repository = CarRepositoryImpl.getRepository();
    }

    public static CarService getService(){
        if (service == null) service = new CarServiceImpl();
        return service;
    }

    @Override
    public Car create(Car car) {
        return this.repository.create(car);
    }

    @Override
    public Car update(Car car) {
        return this.repository.update(car);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Car read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Car> getAll() {
        return repository.getAll();
    }

}