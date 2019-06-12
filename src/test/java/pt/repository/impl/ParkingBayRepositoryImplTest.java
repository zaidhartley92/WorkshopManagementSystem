package pt.repository.impl;

import org.junit.Test;

import pt.domain.ParkingBay;
import pt.factory.ParkingBayFactory;
import pt.repository.ParkingBayRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@FixMethodOrder(MethodSorters.DEFAULT)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ParkingBayRepositoryImplTest {

    private ParkingBayRepository repository;
    private ParkingBay parkingBay;

    private ParkingBay getSavedParkingBay(){
        Set<ParkingBay> savedParkingBays = this.repository.getAll();
        return savedParkingBays.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = ParkingBayRepositoryImpl.getRepository();
        this.parkingBay = ParkingBayFactory.getParkingBay("Test ParkingBay");
    }

    @Test
    public void create() {

        ParkingBay testCreate = this.repository.create(this.parkingBay);
        Assert.assertSame(testCreate, this.parkingBay);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        ParkingBay savedParkingBay = getSavedParkingBay();
        this.repository.delete(savedParkingBay.getParkingBayId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another parkingBay after deleting so that Read() has something to read.
        this.repository.create(this.parkingBay);

    }

    @Test
    public void read() {

        ParkingBay savedParkingBay = getSavedParkingBay();
        String id = savedParkingBay.getParkingBayId();
        ParkingBay readParkingBay = this.repository.read(id);
        Assert.assertEquals(savedParkingBay, readParkingBay);
    }

    @Test
    public void update() {

        ParkingBay saved = getSavedParkingBay();
        String id = saved.getParkingBayId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<ParkingBay> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}