package pt.service.impl;

import pt.domain.Truck;
import pt.factory.TruckFactory;
import pt.service.TruckService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class TruckServiceImplTest {
    private TruckService service;
    private Truck truck;

    private Truck getSavedTruck(){
        Set<Truck> savedTrucks = this.service.getAll();
        return savedTrucks.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = TruckServiceImpl.getService();
        this.truck = TruckFactory.getTruck("Test Truck");
    }

    @Test
    public void create() {

        Truck testCreate = this.service.create(this.truck);
        Assert.assertSame(testCreate, this.truck);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Truck savedTruck = getSavedTruck();
        this.service.delete(savedTruck.getTruckId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another truck after deleting so that Read() has something to read.
        this.service.create(this.truck);

    }

    @Test
    public void read() {

        Truck savedTruck = getSavedTruck();
        String id = savedTruck.getTruckId();
        Truck readTruck = this.service.read(id);
        Assert.assertEquals(savedTruck, readTruck);
    }

    @Test
    public void update() {

        Truck saved = getSavedTruck();
        String id = saved.getTruckId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Truck> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}