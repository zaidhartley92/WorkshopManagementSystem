package pt.service.impl;

import pt.domain.Vehicle;
import pt.factory.VehicleFactory;
import pt.service.VehicleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class VehicleServiceImplTest {
    private VehicleService service;
    private Vehicle vehicle;

    private Vehicle getSavedVehicle(){
        Set<Vehicle> savedVehicles = this.service.getAll();
        return savedVehicles.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = VehicleServiceImpl.getService();
        this.vehicle = VehicleFactory.getVehicle("Test Vehicle");
    }

    @Test
    public void create() {

        Vehicle testCreate = this.service.create(this.vehicle);
        Assert.assertSame(testCreate, this.vehicle);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Vehicle savedVehicle = getSavedVehicle();
        this.service.delete(savedVehicle.getVehicleId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another vehicle after deleting so that Read() has something to read.
        this.service.create(this.vehicle);

    }

    @Test
    public void read() {

        Vehicle savedVehicle = getSavedVehicle();
        String id = savedVehicle.getVehicleId();
        Vehicle readVehicle = this.service.read(id);
        Assert.assertEquals(savedVehicle, readVehicle);
    }

    @Test
    public void update() {

        Vehicle saved = getSavedVehicle();
        String id = saved.getVehicleId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Vehicle> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}
