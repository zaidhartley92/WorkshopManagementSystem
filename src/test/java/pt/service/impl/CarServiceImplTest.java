package pt.service.impl;

import pt.domain.Car;
import pt.factory.CarFactory;
import pt.service.CarService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class CarServiceImplTest {
    private CarService service;
    private Car car;

    private Car getSavedCar(){
        Set<Car> savedCars = this.service.getAll();
        return savedCars.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = CarServiceImpl.getService();
        this.car = CarFactory.getCar("Test Car");
    }

    @Test
    public void create() {

        Car testCreate = this.service.create(this.car);
        Assert.assertSame(testCreate, this.car);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Car savedCar = getSavedCar();
        this.service.delete(savedCar.getCarId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another car after deleting so that Read() has something to read.
        this.service.create(this.car);

    }

    @Test
    public void read() {

        Car savedCar = getSavedCar();
        String id = savedCar.getCarId();
        Car readCar = this.service.read(id);
        Assert.assertEquals(savedCar, readCar);
    }

    @Test
    public void update() {

        Car saved = getSavedCar();
        String id = saved.getCarId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Car> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}